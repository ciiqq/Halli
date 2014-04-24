package fi.softala.dao;

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

	public List<Koulutustilaisuus> haeKaikki() {
		String sql = "SELECT k.*, ast.*, ko.opiskelijanro, ko.etunimi AS etunimi, ko.sukunimi AS sukunimi, 1 kouluttaja_true, '' AS avainsana "
				+ "FROM koulutustilaisuus k "
				+ "JOIN koulutuksenKouluttaja kk ON k.koulutus_id = kk.koulutus_id "
				+ "JOIN kouluttaja ko ON ko.opiskelijanro = kk.opiskelijanro "
				+ "JOIN aikatauluslotti ast ON ast.koulutus_id = k.koulutus_id "
				+ "UNION ALL "
				+ "SELECT k.*, ast.*, '', '', '', 0 kouluttaja_true, a.avainsana "
				+ "FROM koulutustilaisuus k "
				+ "JOIN koulutuksenAvainsana ka ON ka.koulutus_id = k.koulutus_id "
				+ "JOIN avainsana a ON a.avainsana_id = ka.avainsana_id "
				+ "JOIN aikatauluslotti ast ON ast.koulutus_id = k.koulutus_id;";
		List<Koulutustilaisuus> koulutukset = jt.query(sql,
				new KoulutusHakuRsE());
		return koulutukset;
	}
	
	public List<Koulutustilaisuus> haeValitut(String ehto) {
		ehto = "%"+ehto+"%";
		String idLause = "WHERE k.koulutus_id = ";
		Object[] parametrit = new Object[] {ehto, ehto, ehto};
		String sqlIdt = "SELECT DISTINCT koulutustilaisuus.koulutus_id FROM koulutustilaisuus "
				+ "JOIN koulutuksenAvainsana ON koulutustilaisuus.koulutus_id = koulutuksenAvainsana.koulutus_id "
				+ "JOIN avainsana ON koulutuksenAvainsana.avainsana_id  = avainsana.avainsana_id "
				+ "WHERE koulutustilaisuus.kuvaus LIKE ? OR koulutustilaisuus.aihe LIKE ? OR avainsana.avainsana LIKE ?";
		List<Integer> koulutusIdt = jt.query(sqlIdt, parametrit, new IdHakuRowMapper());
		for (int i=0; i<koulutusIdt.size(); i++){
			if (koulutusIdt.size()==1){			
				idLause = idLause + ""+koulutusIdt.get(i)+" ";
				}
			else if (i < koulutusIdt.size()-1){			
			idLause = idLause + ""+koulutusIdt.get(i)+" OR k.koulutus_id = ";
			}
			else if(i == koulutusIdt.size()-1) {
			idLause = idLause + ""+koulutusIdt.get(i)+" ";
			}
		}
		String sql = "SELECT k.*, ast.*, ko.opiskelijanro, ko.etunimi AS etunimi, ko.sukunimi AS sukunimi, 1 kouluttaja_true, '' AS avainsana "
				+ "FROM koulutustilaisuus k "
				+ "JOIN koulutuksenKouluttaja kk ON k.koulutus_id = kk.koulutus_id "
				+ "JOIN kouluttaja ko ON ko.opiskelijanro = kk.opiskelijanro "
				+ "JOIN aikatauluslotti ast ON ast.koulutus_id = k.koulutus_id "
				+ ""+idLause+" "
				+ "UNION ALL "
				+ "SELECT k.*, ast.*, '', '', '', 0 kouluttaja_true, a.avainsana "
				+ "FROM koulutustilaisuus k "
				+ "JOIN koulutuksenAvainsana ka ON ka.koulutus_id = k.koulutus_id "
				+ "JOIN avainsana a ON a.avainsana_id = ka.avainsana_id "
				+ "JOIN aikatauluslotti ast ON ast.koulutus_id = k.koulutus_id "
				+ ""+idLause+";";
		List<Koulutustilaisuus> koulutukset = jt.query(sql, new KoulutusHakuRsE());
		return koulutukset;
	}
}
