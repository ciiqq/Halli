package fi.softala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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

	public void talletaPalaute(Palaute palaute) {
		final String sql = "insert into palaute(arvosana, palauteteksti, opiskelijanumero) values(?,?,?)";
		final int arvosana = palaute.getArvosana();
		final String palauteteksti = palaute.getPalauteteksti();
		final String opiskelijanumero = palaute.getOpiskelijanumero();

		KeyHolder idHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "palaute_id" });
				ps.setInt(1, arvosana);
				ps.setString(2, palauteteksti);
				ps.setString(3, opiskelijanumero);
				return ps;
			}
		}, idHolder);

		palaute.setPalaute_id(idHolder.getKey().intValue());

	}
	public Palaute haePalautteenOpiskelianumero(String opiskelijanumero) {
		String sql = "select opiskelijanumero from palaute where opiskelijanumero = ?";
		Object[] parametrit = new Object[] { opiskelijanumero };
		Palaute palaute;
		RowMapper<Palaute> mapper = new PalauteRowMapper();
		try {
			palaute = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw e;
		}
		return palaute;
	}

	public List<Palaute> haeKaikki() {

		String sql = "select palaute_id, arvosana, palauteteksti from palaute";
		RowMapper<Palaute> mapper = new PalauteRowMapper();
		List<Palaute> palautteet = jdbcTemplate.query(sql, mapper);

		return palautteet;
	}
	
	public List<Palaute> haeIdlla() {

		String sql = "SELECT i.koulutus_id, p.palaute_id, p.palauteteksti, p.arvosana FROM ilmoittautuminen i "
				+ "JOIN palaute p ON p.palaute_id = i.palaute_id WHERE i.koulutus_id = 3";
		RowMapper<Palaute> mapper = new PalauteRowMapper();
		List<Palaute> palautteet = jdbcTemplate.query(sql, mapper);

		return palautteet;
	}
	public List<Palaute> haeKaikkiPalautteet() {

		String sql = "select * from palaute";
		RowMapper<Palaute> mapper = new PalauteRowMapper();
		List<Palaute> palautteet = jdbcTemplate.query(sql, mapper);

		return palautteet;
	}
}
