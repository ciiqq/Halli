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
		final String sql = "SELECT asl.pvm, asl.alkukello, asl.loppukello, asl.koulutustila, kt.aihe, kt.kuvaus, kt.lahtotaso, kt.nakyvyys FROM aikatauluslotti asl JOIN koulutustilaisuus kt ON " +
							"asl.koulutus_id = kt.koulutus_id;";
		
		RowMapper<Aikatauluslotti> rm = new KoulutusRowMapper();
		
		List<Aikatauluslotti> koulutuslista = jdbcTemplate.query(sql, rm);
		
		return koulutuslista;
	}

}
