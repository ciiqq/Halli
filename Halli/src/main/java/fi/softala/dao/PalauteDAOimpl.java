package fi.softala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

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

	public void talletaPalaute(Palaute palaute, int koulutus_id) {
		final String sql = "insert into palaute(arvosana, palauteteksti) values(?,?)";
		final String sql2 = "update ilmoittautuminen set palaute_id = ? where osallistujan_opiskelijanro = ? and koulutus_id = ?";
		final int arvosana = palaute.getArvosana();
		final String palauteteksti = palaute.getPalauteteksti();
		final String opiskelijanro = palaute.getOpiskelijanro();
		final int koulutusid = koulutus_id;

		KeyHolder idHolder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, new String[] { "palaute_id" });
				ps.setInt(1, arvosana);
				ps.setString(2, palauteteksti);
				return ps;
			}
		}, idHolder);
		
		palaute.setPalaute_id(idHolder.getKey().intValue());

		final int palauteid = palaute.getPalaute_id();
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection2) throws SQLException {
				PreparedStatement ps2 = connection2.prepareStatement(sql2);
				ps2.setInt(1, palauteid);
				ps2.setString(2, opiskelijanro);
				ps2.setInt(3, koulutusid);
				return ps2;
			}
		});
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
	
	public List<Palaute> haeIdlla(int id) {
		String sql = "select osallistujan_opiskelijanro, koulutus_id, p.palaute_id, arvosana, palauteteksti "
				+ "FROM ilmoittautuminen i "
				+ "join palaute p on i.palaute_id = p.palaute_id "
				+ "where p.palaute_id = ?";
		
		RowMapper<Palaute> mapper = new PalauteRowMapper();
		Object[] params = new Object[] { id };
		List<Palaute> palautteet = jdbcTemplate.query(sql, params, mapper);

		if (palautteet.size() == 0) {
			System.out.println("DAO: Palautteet tyhjä");
		}
		
		return palautteet;
	}
	public List<Palaute> haeKaikkiPalautteet() {

		String sql = "select * from palaute";
		RowMapper<Palaute> mapper = new PalauteRowMapper();
		List<Palaute> palautteet = jdbcTemplate.query(sql, mapper);

		return palautteet;
	}
}
