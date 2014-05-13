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
<<<<<<< HEAD
		final String sqlPalaute = "insert into palaute(arvosana, palauteteksti) values (?, ?)";
		final String sqlIlmoittautuminen = "update ilmoittautuminen set palaute_id = ? where osallistujan_opiskelijanro = ?";
		
=======
		final String sql = "insert into palaute(arvosana, palauteteksti, opiskelijanro) values(?,?,?)";
>>>>>>> 0d95bc259bcdc93c4c804a5fd796323fb9049164
		final int arvosana = palaute.getArvosana();
		final String palauteteksti = palaute.getPalauteteksti();
		final int opiskelijanumero = Integer.parseInt(palaute.getOpiskelijanumero());

		KeyHolder idHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "palaute_id" });
				ps.setInt(1, arvosana);
				ps.setString(2, palauteteksti);
				ps.setInt(3, opiskelijanumero);
				return ps;
			}
<<<<<<< HEAD
		}, kh);
		
		palaute.setPalaute_id(kh.getKey().intValue());
		palauteId = palaute.getPalaute_id();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sqlIlmoittautuminen);
				ps.setInt(1, palauteId);
				ps.setString(2, opiskelijanro);
				return ps;
			}
		});
		
		
	}
=======
		}, idHolder);

		palaute.setPalaute_id(idHolder.getKey().intValue());
>>>>>>> 0d95bc259bcdc93c4c804a5fd796323fb9049164

	}
	public Palaute haePalautteenOpiskelianumero(String opiskelijanumero) {
		String sql = "select opiskelijanro from palaute where opiskelijanro = ?";
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
