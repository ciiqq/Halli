package fi.softala.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fi.softala.bean.Aikatauluslotti;
import fi.softala.bean.Avainsana;
import fi.softala.bean.Kouluttaja;
import fi.softala.bean.Koulutustilaisuus;
@Repository
public class KoulutusDAOImpl implements KoulutusDAO{
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbc() {
		return jdbcTemplate;
	}



	public void setJdbc(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	public List<Koulutustilaisuus> haeKoulutukset(boolean julkaistu) {
		String sql = "SELECT kt.koulutus_id, asl.aika_id, asl.pvm, asl.alkukello, asl.loppukello, asl.koulutustila, kt.aihe, kt.kuvaus, kt.lahtotaso, kt.nakyvyys FROM koulutustilaisuus kt JOIN aikatauluslotti asl ON " +
							"asl.koulutus_id = kt.koulutus_id AND ";
		
		if(julkaistu){
			sql =  sql + "nakyvyys = 1";
		}else{
			sql =  sql + "nakyvyys = 0";
		}
		
		RowMapper<Koulutustilaisuus> rm = new KoulutusRowMapper();
		
		List<Koulutustilaisuus> koulutuslista = jdbcTemplate.query(sql, rm);
		
		return koulutuslista;
	}
	
	public Koulutustilaisuus haeKoulutus(int id) {
		final String sql = "SELECT kt.koulutus_id, asl.aika_id, asl.pvm, asl.alkukello, asl.loppukello, asl.koulutustila, kt.aihe, kt.kuvaus, kt.lahtotaso, kt.nakyvyys FROM koulutustilaisuus kt JOIN aikatauluslotti asl ON " +
				"asl.koulutus_id = kt.koulutus_id WHERE kt.koulutus_id = ?;";
		Object[] parametrit = new Object[] { id };
		
		RowMapper<Koulutustilaisuus> rm = new KoulutusRowMapper();
		
		Koulutustilaisuus koulutus = jdbcTemplate.queryForObject(sql, parametrit, rm);
		
		return koulutus;
	}



	public void paivitaKoulutus(Koulutustilaisuus kt) {
		final String sql = "UPDATE aikatauluslotti asl"
						+ " INNER JOIN koulutustilaisuus kt ON asl.koulutus_id = kt.koulutus_id SET kt.aihe = ?, kt.kuvaus = ?, kt.lahtotaso = ?"
						+ " WHERE asl.aika_id = ?;";
		
//		Muutetaan takaisin SQL-muotoon
//		String asConvert = kt.getAikaslotti().getPvm().replace(".", "-");
//		String[] suomiPvm = asConvert.split("-");
//		kt.getAikaslotti().setPvm(suomiPvm[2] + "-" + suomiPvm[1] + "-" + suomiPvm[0]);	
		
		Object[] parametrit = new Object[] { kt.getAihe(), kt.getKuvaus(), kt.getLahtotaso(), kt.getId()};
		
		jdbcTemplate.update(sql, parametrit);
		
	}



	public void peruutaKoulutus(int id) {
		final String sql = "UPDATE aikatauluslotti asl"
						+ " INNER JOIN koulutustilaisuus kt ON asl.koulutus_id = kt.koulutus_id"
						+ " SET asl.koulutus_id = null"
						+ " WHERE asl.koulutus_id = ?;";
		
		Object[] parametrit = new Object[] {id};
		jdbcTemplate.update(sql, parametrit);
		
		
	}
	
//	Koulutuksen siirto toiseen aikatauluslottiin

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.SERIALIZABLE, readOnly=false)
	public void siirraKoulutus(int koulutusId, int aikaId) {
		
		final String sql = "UPDATE aikatauluslotti asl"
						+ " INNER JOIN koulutustilaisuus kt ON asl.koulutus_id = kt.koulutus_id"
						+ " SET asl.koulutus_id = null"
						+ " WHERE asl.koulutus_id = ?";
		
		Object[] parametrit = new Object[] {koulutusId};
		
		jdbcTemplate.update(sql, parametrit);
		
		
		final String sql2 = "UPDATE aikatauluslotti "
						+ " SET koulutus_id = ?"
						+ " WHERE aika_id = ?";
		
		Object[] parametrit2 = new Object[] {koulutusId, aikaId};
		
		jdbcTemplate.update(sql2, parametrit2);
	}



	public List<Kouluttaja> haeKouluttajat(int id) {
		final String sql = "SELECT h.etunimi, h.sukunimi FROM koulutustilaisuus kt JOIN koulutuksenkouluttaja kk ON kt.koulutus_id = kk.koulutus_id " +
							"JOIN henkilo h ON kk.kouluttajatunnus = h.henkilotunnus WHERE kt.koulutus_id = ? AND h.rooli = 'kouluttaja';";
		Object[] parametrit = new Object[] { id };
		
		RowMapper<Kouluttaja> rm = new HenkiloRowMapper();
		
		List<Kouluttaja> kouluttajat = jdbcTemplate.query(sql, parametrit, rm);
		
		return kouluttajat;
	}



	public List<Avainsana> haeAvainsanat(int id) {
		final String sql = "SELECT a.avainsana_id, a.avainsana FROM koulutustilaisuus kt JOIN koulutuksenAvainsana ka ON kt.koulutus_id = ka.koulutus_id " + 
							"JOIN avainsana a ON ka.avainsana_id = a.avainsana_id WHERE kt.koulutus_id = ?;";
		Object[] parametrit = new Object[] { id };
		
		RowMapper<Avainsana> rm = new AvainsanaRowMapper();
		
		List<Avainsana> avainsanat = jdbcTemplate.query(sql, parametrit, rm);
		
		return avainsanat;
	}

}
