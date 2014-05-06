package fi.softala.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fi.softala.bean.Koulutustilaisuus;

/**
 * 
 * @author Timo Kottonen, Teemu Kälviäinen
 * @author ...
 *
 */

@Repository
public class KoulutusHakuDAOImpl implements KoulutusHakuDAO {

	@Inject
	private JdbcTemplate jt;

	public JdbcTemplate getJdbcTemplate() {
		return jt;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jt = jdbcTemplate;
	}

	public List<Koulutustilaisuus> haeTulevat() {
		String sql = "SELECT k.*, ats.*, ko.henkilotunnus, ko.etunimi AS etunimi, ko.sukunimi AS sukunimi, 1 kouluttaja_true, '' AS avainsana "
				+ "FROM koulutustilaisuus k "
				+ "JOIN koulutuksenkouluttaja kk ON k.koulutus_id = kk.koulutus_id "
				+ "JOIN henkilo ko ON ko.henkilotunnus = kk.kouluttajatunnus "
				+ "JOIN aikatauluslotti ats ON ats.koulutus_id = k.koulutus_id "
				+ "WHERE ats.pvm > curdate() AND nakyvyys = 1 "
				+ "UNION ALL "
				+ "SELECT k.*, ats.*, '', '', '', 0 kouluttaja_true, a.avainsana "
				+ "FROM koulutustilaisuus k "
				+ "JOIN koulutuksenavainsana ka ON ka.koulutus_id = k.koulutus_id "
				+ "JOIN avainsana a ON a.avainsana_id = ka.avainsana_id "
				+ "JOIN aikatauluslotti ats ON ats.koulutus_id = k.koulutus_id "
				+ "WHERE ats.pvm > curdate() AND nakyvyys = 1 "
				+ "ORDER BY pvm, alkukello";
		List<Koulutustilaisuus> koulutukset = jt.query(sql,
				new KoulutusHakuRsExtractor());
		return koulutukset;
	}
	
	public List<Koulutustilaisuus> haeMenneet() {
		String sql = "SELECT k.*, ats.*, ko.henkilotunnus, ko.etunimi AS etunimi, ko.sukunimi AS sukunimi, 1 kouluttaja_true, '' AS avainsana "
				+ "FROM koulutustilaisuus k "
				+ "JOIN koulutuksenkouluttaja kk ON k.koulutus_id = kk.koulutus_id "
				+ "JOIN henkilo ko ON ko.henkilotunnus = kk.kouluttajatunnus "
				+ "JOIN aikatauluslotti ats ON ats.koulutus_id = k.koulutus_id "
				+ "WHERE ats.pvm <= curdate() AND nakyvyys = 1 "
				+ "UNION ALL "
				+ "SELECT k.*, ats.*, '', '', '', 0 kouluttaja_true, a.avainsana "
				+ "FROM koulutustilaisuus k "
				+ "JOIN koulutuksenavainsana ka ON ka.koulutus_id = k.koulutus_id "
				+ "JOIN avainsana a ON a.avainsana_id = ka.avainsana_id "
				+ "JOIN aikatauluslotti ats ON ats.koulutus_id = k.koulutus_id "
				+ "WHERE ats.pvm <= curdate() AND nakyvyys = 1 "
				+ "ORDER BY pvm, alkukello";
		List<Koulutustilaisuus> koulutukset = jt.query(sql,
				new KoulutusHakuRsExtractor());
		return koulutukset;
	}
	
	public List<Koulutustilaisuus> haeHakusanalla(String ehto) {
		ehto = "%"+ehto+"%";
		Object[] parametrit = new Object[] {ehto, ehto, ehto};
		String sql = "SELECT DISTINCT koulutustilaisuus.koulutus_id FROM koulutustilaisuus "
				+ "JOIN koulutuksenavainsana ON koulutustilaisuus.koulutus_id = koulutuksenavainsana.koulutus_id "
				+ "JOIN avainsana ON koulutuksenavainsana.avainsana_id  = avainsana.avainsana_id "
				+ "WHERE (koulutustilaisuus.kuvaus LIKE ? OR koulutustilaisuus.aihe LIKE ? "+
				"OR avainsana.avainsana LIKE ? ) AND nakyvyys = 1";
		List<Integer> koulutustunnukset = jt.queryForList(sql, parametrit, Integer.class);
		if(koulutustunnukset.size() == 0){
			return new ArrayList<Koulutustilaisuus>();
		}
		
		String sqlehto = "WHERE k.koulutus_id = ";
		for (int i = 0; i < koulutustunnukset.size(); i++) {
 			if (i < koulutustunnukset.size() -1) {			
 				// += on lyhenne [sqlehto = sqlehto + "..."]
 				sqlehto += koulutustunnukset.get(i)+" OR k.koulutus_id = ";
 			} else {
 				sqlehto += koulutustunnukset.get(i);
 			}
 		}
		
		sql = "SELECT k.*, ats.*, ko.henkilotunnus, ko.etunimi AS etunimi, ko.sukunimi AS sukunimi, 1 kouluttaja_true, '' AS avainsana "
				+ "FROM koulutustilaisuus k "
				+ "JOIN koulutuksenkouluttaja kk ON k.koulutus_id = kk.koulutus_id "
				+ "JOIN henkilo ko ON ko.henkilotunnus = kk.kouluttajatunnus "
				+ "JOIN aikatauluslotti ats ON ats.koulutus_id = k.koulutus_id "
				+ ""+sqlehto+" "
				+ "UNION ALL "
				+ "SELECT k.*, ats.*, '', '', '', 0 kouluttaja_true, a.avainsana "
				+ "FROM koulutustilaisuus k "
				+ "JOIN koulutuksenavainsana ka ON ka.koulutus_id = k.koulutus_id "
				+ "JOIN avainsana a ON a.avainsana_id = ka.avainsana_id "
				+ "JOIN aikatauluslotti ats ON ats.koulutus_id = k.koulutus_id "
				+ ""+sqlehto+" "
				+ "ORDER BY pvm, alkukello";
		List<Koulutustilaisuus> koulutukset = jt.query(sql, new KoulutusHakuRsExtractor());
		return koulutukset;
	}
	
	public List<Koulutustilaisuus> haeAvainsanalla(String ehto) {
		 		Object[] parametrit = new Object[] {ehto};
		 		String sql = "SELECT DISTINCT koulutustilaisuus.koulutus_id FROM koulutustilaisuus "
		 				+ "JOIN koulutuksenavainsana ON koulutustilaisuus.koulutus_id = koulutuksenavainsana.koulutus_id "
		 				+ "JOIN avainsana ON koulutuksenavainsana.avainsana_id  = avainsana.avainsana_id "
		 				+ "WHERE avainsana.avainsana = ? AND nakyvyys = 1";
		 		List<Integer> koulutustunnukset = jt.queryForList(sql, parametrit, Integer.class);
		 		if(koulutustunnukset.size() == 0) {
		 			return new ArrayList<Koulutustilaisuus>();
		 		}
		 		
		 		String sqlehto = "WHERE k.koulutus_id = ";
		 		for (int i = 0; i < koulutustunnukset.size(); i++){
		 			if (i < koulutustunnukset.size() -1){			
		 				sqlehto += koulutustunnukset.get(i)+" OR k.koulutus_id = ";
		 			} else {
		 				sqlehto += koulutustunnukset.get(i);
		 			}
		 		}
		 		
		 		sql = "SELECT k.*, ats.*, ko.henkilotunnus, ko.etunimi AS etunimi, ko.sukunimi AS sukunimi, 1 kouluttaja_true, '' AS avainsana "
		 				+ "FROM koulutustilaisuus k "
		 				+ "JOIN koulutuksenkouluttaja kk ON k.koulutus_id = kk.koulutus_id "
		 				+ "JOIN henkilo ko ON ko.henkilotunnus = kk.kouluttajatunnus "
		 				+ "JOIN aikatauluslotti ats ON ats.koulutus_id = k.koulutus_id "
		 				+ ""+sqlehto+" "
		 				+ "UNION ALL "
		 				+ "SELECT k.*, ats.*, '', '', '', 0 kouluttaja_true, a.avainsana "
		 				+ "FROM koulutustilaisuus k "
		 				+ "JOIN koulutuksenavainsana ka ON ka.koulutus_id = k.koulutus_id "
		 				+ "JOIN avainsana a ON a.avainsana_id = ka.avainsana_id "
		 				+ "JOIN aikatauluslotti ats ON ats.koulutus_id = k.koulutus_id "
		 				+ ""+sqlehto+" "
		 				+ "ORDER BY pvm, alkukello";
		 		List<Koulutustilaisuus> koulutukset = jt.query(sql, new KoulutusHakuRsExtractor());
		 		return koulutukset;
		 	}
}
