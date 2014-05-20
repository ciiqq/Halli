package fi.softala.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fi.softala.bean.Aikatauluslotti;

@Repository
public class HaeAjatDaoImpl implements HaeAjatDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	

	public List<Aikatauluslotti> haeVapaatAjat() {
		
		String sql = "SELECT aika_id, pvm, alkukello, loppukello, koulutustila FROM aikatauluslotti WHERE koulutus_id IS NULL;";
		return jdbcTemplate.query(sql, new AikatauluslottiRowMapper());
	}

}
