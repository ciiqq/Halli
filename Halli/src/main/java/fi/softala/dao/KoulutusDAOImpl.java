package fi.softala.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.softala.bean.Aikatauluslotti;
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



	public List<Koulutustilaisuus> haeKoulutukset() {
		final String sql = "SELECT kt.koulutus_id, asl.aika_id, asl.pvm, asl.alkukello, asl.loppukello, asl.koulutustila, kt.aihe, kt.kuvaus, kt.lahtotaso, kt.nakyvyys FROM koulutustilaisuus kt JOIN aikatauluslotti asl ON " +
							"asl.koulutus_id = kt.koulutus_id;";
		
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
						+ " INNER JOIN koulutustilaisuus kt ON asl.koulutus_id = kt.koulutus_id SET asl.pvm = ?, asl.alkukello = ?, asl.loppukello = ?, asl.koulutustila = ?, kt.aihe = ?, kt.kuvaus = ?, kt.lahtotaso = ?, kt.nakyvyys = ?"
						+ " WHERE asl.aika_id = ?;";
		
		//Muutetaan takaisin SQL-muotoon
		String asConvert = kt.getAikaslotti().getPvm().replace(".", "-");
		String[] suomiPvm = asConvert.split("-");
		kt.getAikaslotti().setPvm(suomiPvm[2] + "-" + suomiPvm[1] + "-" + suomiPvm[0]);	
		
		Object[] parametrit = new Object[] {kt.getAikaslotti().getPvm(), kt.getAikaslotti().getAlkukello(), kt.getAikaslotti().getLoppukello(), kt.getAikaslotti().getKoulutustila(), kt.getAihe(), kt.getKuvaus(), kt.getLahtotaso(), kt.getNakyvyys(), kt.getId()};
		
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

}
