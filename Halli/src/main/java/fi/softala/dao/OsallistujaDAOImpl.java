package fi.softala.dao;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional(readOnly = false, isolation = Isolation.REPEATABLE_READ)
	public void talleta(Osallistuja o, String[] osallistumiset) {

		String sql = "Select osallistujan_opiskelijanro FROM "
				+ "osallistuja where osallistujan_opiskelijanro = ?";
		Object[] parametrit = new Object[] { o.getOpiskelijanro() };
		String opnro = null;
		try {
			opnro = jdbcTemplate.queryForObject(sql, parametrit,
					String.class);
		} catch (IncorrectResultSizeDataAccessException e) {
			opnro = null;
		}

		if (opnro != null) {
			for (int i = 0; i < osallistumiset.length; i++) {
				sql = "insert into ilmoittautuminen(osallistujan_opiskelijanro, koulutus_id) " +
						"values ("+ opnro + ", "+ osallistumiset[i] + ")";
				jdbcTemplate.update(sql);
			}

		} else {
			sql = "insert into osallistuja(osallistujan_opiskelijanro, etunimi, sukunimi) values(?,?,?)";
			parametrit = new Object[] { o.getOpiskelijanro(), o.getEtunimi(),
					o.getSukunimi() };

			jdbcTemplate.update(sql, parametrit);

			for (int i = 0; i < osallistumiset.length; i++) {
				sql = "insert into ilmoittautuminen(osallistujan_opiskelijanro, koulutus_id) "
						+ "values ("+ o.getOpiskelijanro()+"," + osallistumiset[i] + ")";
				jdbcTemplate.update(sql);
			}
		}
	}

	public Osallistuja haeOsallistuja(String opiskelijanumero,
			String koulutus_id) {
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
