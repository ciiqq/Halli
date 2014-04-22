package fi.softala.dao;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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

	public void talleta(Osallistuja o, String[] idTaulukko) {
		final String sql = "insert into osallistuja(osallistujan_opiskelijanro, etunimi, sukunimi) values(?,?,?)";

		Object[] parametrit = new Object[] { o.getOpiskelijanro(),
				o.getEtunimi(), o.getSukunimi() };

		jdbcTemplate.update(sql, parametrit);

		// Keyholderi tietokannan ID:seen.
		KeyHolder idHolder = new GeneratedKeyHolder();

		o.setId(idHolder.getKey().intValue());

		String koulutuksenId = null;

		for (int i = 0; i < idTaulukko.length; i++) {
			final String toinenSql = "insert into ilmoittautuminen(osallistuja_id, koulutus_id) values (?,?)";

			koulutuksenId = idTaulukko[i];

			Object toisetParametrit = new Object[] { idHolder, koulutuksenId };

			jdbcTemplate.update(toinenSql, toisetParametrit);
		}

	}

}
