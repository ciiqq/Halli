package fi.softala.dao;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.softala.bean.Osallistuja;

@Repository
public class OsallistujaDAOImpl implements OsallistujaDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void talleta(Osallistuja o, String[] osallistumiset) {

		final String sql = "insert into osallistuja(osallistujan_opiskelijanro, etunimi, sukunimi) values(?,?,?)";

		Object[] parametrit = new Object[] { o.getOpiskelijanro(),
				o.getEtunimi(), o.getSukunimi()};

		jdbcTemplate.update(sql, parametrit);
		
		int max = jdbcTemplate.queryForObject( "select last_insert_id()", Integer.class );		
		
		String toinenSql = "";

		for (int i = 0; i < osallistumiset.length; i++) {
			toinenSql = "insert into ilmoittautuminen(osallistuja_id, koulutus_id) values ("+max+","+osallistumiset[i]+")";

			jdbcTemplate.update(toinenSql);
		}

	}
	public Osallistuja haeOsallistuja(String opiskelijanumero, String koulutus_id) {
		String sql = "select * from ilmoittautuminen where opiskelijanumero = ? and koulutus_id = ?";
		Object[] parametrit = new Object[] { opiskelijanumero, koulutus_id };
		Osallistuja osallistuja;
		RowMapper<Osallistuja> mapper = new OsallistujaRowMapper();
		try {
			osallistuja = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw e;
		}
		return osallistuja;
	}

}
