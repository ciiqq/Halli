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

<<<<<<< HEAD
	public void talletaPalaute(Palaute palaute, int koulutus_id) {
		final String sql = "insert into palaute(arvosana, palauteteksti) values(?,?)";
		final String sql2 = "update ilmoittautuminen set palaute_id = ? where osallistujan_opiskelijanro = ? and koulutus_id = ?";
		final int arvosana = palaute.getArvosana();
		final String palauteteksti = palaute.getPalauteteksti();
		final String opiskelijanumero = palaute.getOpiskelijanro();
		final int koulutusid = koulutus_id;
=======
	public void talletaPalaute(Palaute palaute) {
		final String sqlPalaute = "insert into palaute(arvosana, palauteteksti) values (?, ?)";
		final String sqlIlmoittautuminen = "update ilmoittautuminen set palaute_id = ? where osallistujan_opiskelijanro = ?";
		
		final int arvosana = palaute.getArvosana();
		final String palauteteksti = palaute.getPalauteteksti();
		final String opiskelijanro = palaute.getOpiskelijanro();
>>>>>>> FETCH_HEAD

		KeyHolder idHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
<<<<<<< HEAD
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, new String[] { "palaute_id" });
=======
			public PreparedStatement createPreparedStatement(Connection connection) 
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sqlPalaute,
						new String[] { "palaute_id" });
>>>>>>> FETCH_HEAD
				ps.setInt(1, arvosana);
				ps.setString(2, palauteteksti);
				return ps;
			}
		}, idHolder);
		
		palaute.setPalaute_id(idHolder.getKey().intValue());
<<<<<<< HEAD
		
		final int palauteid = palaute.getPalaute_id();
		System.out.println("PALAUTE_ID:");
		System.out.println(palauteid);
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection2) throws SQLException {
				PreparedStatement ps2 = connection2.prepareStatement(sql2);
				ps2.setInt(1, palauteid);
				ps2.setString(2, opiskelijanumero);
				ps2.setInt(3, koulutusid);
				return ps2;
			}
		});
=======
		final int palauteId = palaute.getPalaute_id();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sqlIlmoittautuminen);
				ps.setInt(1, palauteId);
				ps.setString(2, opiskelijanro);
				return ps;
			}
		});
		
		
>>>>>>> FETCH_HEAD
	}
	
	public List<Palaute> haePalautteet(String opiskelijanro) {
		
		String sql = "select p.palaute_id, arvosana, palauteteksti, i.osallistujan_opiskelijanro "
				+ "from palaute p "
				+ "join ilmoittautuminen i "
				+ "on p.palaute_id = i.palaute_id "
				+ "where osallistujan_opiskelijanro = " + opiskelijanro + ";";
		
		RowMapper<Palaute> mapper = new PalauteRowMapper();
		List<Palaute> palautteet = jdbcTemplate.query(sql, mapper);
		
		return palautteet;
	}
	

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
	public List<Palaute> haeKaikkiPalautteet() {

		String sql = "select * from palaute";
		RowMapper<Palaute> mapper = new PalauteRowMapper();
		List<Palaute> palautteet = jdbcTemplate.query(sql, mapper);

		return palautteet;
	}
}
