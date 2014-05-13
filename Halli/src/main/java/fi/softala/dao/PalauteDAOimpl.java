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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Transactional (readOnly = false, isolation = Isolation.REPEATABLE_READ)
	public void talletaPalaute(Palaute palaute) {
		final String sqlPalaute = "insert into palaute(arvosana, palauteteksti) values (?, ?)";
		final String sqlIlmoittautuminen = "update ilmoittautuminen set palaute_id = ? where osallistujan_opiskelijanro = ?";
		
		final int arvosana = palaute.getArvosana();
		final String palauteteksti = palaute.getPalauteteksti();
		final String opiskelijanro = palaute.getOpiskelijanro();
		final int palauteId;
		
		KeyHolder kh = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sqlPalaute, new String[] {"palaute_id"} );
				ps.setInt(1, arvosana);
				ps.setString(2, palauteteksti);
				return ps;
			}
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

	public List<Palaute> haePalaute(String opiskelijanro) {
		
		String sql = "select p.palaute_id, arvosana, palauteteksti, i.osallistujan_opiskelijanro "
				+ "from palaute p "
				+ "join ilmoittautuminen i "
				+ "on p.palaute_id = i.palaute_id "
				+ "where osallistujan_opiskelijanro = " + opiskelijanro + ";";
		
		RowMapper<Palaute> mapper = new PalauteRowMapper();
		List<Palaute> palautteet = jdbcTemplate.query(sql, mapper);
		
		return palautteet;
	}

	@Transactional (readOnly = false, isolation = Isolation.REPEATABLE_READ)
	public List<Palaute> haeKaikki() {

		String sql = "select p.palaute_id, arvosana, palauteteksti, i.osallistujan_opiskelijanro "
				+ "from palaute p "
				+ "join ilmoittautuminen i "
				+ "on p.palaute_id = i.palaute_id;";
		
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

}
