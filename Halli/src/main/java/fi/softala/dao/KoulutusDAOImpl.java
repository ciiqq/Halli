package fi.softala.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fi.softala.bean.Koulutustilaisuus;


@Repository
public class KoulutusDAOImpl implements KoulutusDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void tallennaVaraus(Koulutustilaisuus koulutus) {
		
	}

	public Koulutustilaisuus etsi(int id) {
		return null;
	}

	public List<Koulutustilaisuus> haeKaikki() {
		return null;
	}


}
