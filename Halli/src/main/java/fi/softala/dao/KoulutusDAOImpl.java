package fi.softala.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.softala.bean.Aikatauluslotti;
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



	public List<Aikatauluslotti> haeKoulutukset() {
		final String sql = "SELECT asl.aika_id, asl.pvm, asl.alkukello, asl.loppukello, asl.koulutustila, kt.aihe, kt.kuvaus, kt.lahtotaso, kt.nakyvyys FROM aikatauluslotti asl JOIN koulutustilaisuus kt ON " +
							"asl.koulutus_id = kt.koulutus_id;";
		
		RowMapper<Aikatauluslotti> rm = new KoulutusRowMapper();
		
		List<Aikatauluslotti> koulutuslista = jdbcTemplate.query(sql, rm);
		
		return koulutuslista;
	}
	
	public Aikatauluslotti haeKoulutus(int id) {
		final String sql = "SELECT asl.aika_id, asl.pvm, asl.alkukello, asl.loppukello, asl.koulutustila, kt.aihe, kt.kuvaus, kt.lahtotaso, kt.nakyvyys FROM aikatauluslotti asl JOIN koulutustilaisuus kt ON " +
				"asl.koulutus_id = kt.koulutus_id WHERE asl.aika_id = ?;";
		Object[] parametrit = new Object[] { id };
		
		RowMapper<Aikatauluslotti> rm = new KoulutusRowMapper();
		
		Aikatauluslotti koulutus = jdbcTemplate.queryForObject(sql, parametrit, rm);
		
		return koulutus;
	}



	public void paivitaKoulutus(Aikatauluslotti as) {
		final String sql = "UPDATE aikatauluslotti asl"
						+ " INNER JOIN koulutustilaisuus kt ON asl.koulutus_id = kt.koulutus_id SET asl.pvm = ?, asl.alkukello = ?, asl.loppukello = ?, asl.koulutustila = ?, kt.aihe = ?, kt.kuvaus = ?, kt.lahtotaso = ?, kt.nakyvyys = ?"
						+ " WHERE asl.aika_id = ?;";
		
		//Muutetaan takaisin SQL-muotoon
		String asConvert = as.getPvm().replace(".", "-");
		String[] suomiPvm = asConvert.split("-");
		as.setPvm(suomiPvm[2] + "-" + suomiPvm[1] + "-" + suomiPvm[0]);	
		
		Object[] parametrit = new Object[] {as.getPvm(), as.getAlkukello(), as.getLoppukello(), as.getKoulutustila(), as.getKoulutus().getAihe(), as.getKoulutus().getKuvaus(), as.getKoulutus().getLahtotaso(), as.getKoulutus().getNakyvyys(), as.getId()};
		
		jdbcTemplate.update(sql, parametrit);
		
	}

}
