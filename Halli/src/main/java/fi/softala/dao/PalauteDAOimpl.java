package fi.softala.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.softala.bean.Palaute;

@Repository
public class PalauteDAOimpl implements PalauteDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Palaute> haeIdlla() {

		String sql = "SELECT i.koulutus_id, p.palaute_id, p.palauteteksti, p.arvosana, kk.koulutus_id, k.aihe, k.kuvaus FROM ilmoittautuminen i "
				+ " JOIN koulutuksentoimija kk ON i.koulutus_id = kk.koulutus_id"
				+ " JOIN palaute p ON i.palaute_id = p.palaute_id "
				+ " JOIN koulutustilaisuus k ON kk.koulutus_id = k.koulutus_id"
				+ " WHERE kk.koulutus_id = 3;";
		RowMapper<Palaute> mapper = new PalauteRowMapper();
		List<Palaute> palautteet = jdbcTemplate.query(sql, mapper);

		return palautteet;
	}

	public List<Palaute> haeKaikki() {

		String sql = "SELECT aihe, kuvaus FROM koulutustilaisuus;";
		RowMapper<Palaute> mapper = new KaikkiKoulutuksetRowMapper();
		List<Palaute> palautteet = jdbcTemplate.query(sql, mapper);

		return palautteet;
	}
}
