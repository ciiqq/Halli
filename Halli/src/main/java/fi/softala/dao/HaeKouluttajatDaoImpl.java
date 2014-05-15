package fi.softala.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fi.softala.bean.Kouluttaja;

@Repository
public class HaeKouluttajatDaoImpl implements HaeKouluttajatDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	

	public List<Kouluttaja> haeKouluttajat() {
		
		String sql = "SELECT henkilotunnus, etunimi, sukunimi FROM henkilo WHERE rooli='kouluttaja'";
		return jdbcTemplate.query(sql, new HaeKouluttajatRowMapper());
	}

}
