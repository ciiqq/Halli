package fi.softala.testi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

import org.dbunit.dataset.IDataSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import fi.softala.GeneroiXML;
import fi.softala.TietokantaTesti;
import fi.softala.bean.Palaute;
import fi.softala.dao.PalauteDAOimpl;
import fi.softala.dao.PalauteRowMapper;

public class PalauteDAOTesti {
	
	private Connection jdbcConnection;
	private IDataSet testidata;
	private final Palaute palaute = new Palaute();
	private Palaute palaute2 = new Palaute();

	@Before
	public void setup() throws Exception {
		GeneroiXML.main(null);
		TietokantaTesti testi = new TietokantaTesti();
		this.jdbcConnection = testi.haeJdbcConnection();
		this.testidata = testi.haeTestidata();
		
		palaute.setPalaute_id(3);
		palaute.setArvosana(3);
		palaute.setOpiskelijanumero(1234567);
		palaute.setPalauteteksti("skfdeopjsfojfåpfwe");
	}
	
	@Test
	public void setupOK() {
		assertNotNull(jdbcConnection);
		assertNotNull(testidata);
		assertNotNull(palaute);
	}
	
	@Test
	public void testaaHaeKaikki() throws Exception {
		PalauteDAOimpl dao = new PalauteDAOimpl();
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(new SingleConnectionDataSource(jdbcConnection, false));
		dao.setJdbcTemplate(jdbcTemplate);
		List<Palaute> palautteet = dao.haeKaikki();
		
		System.out.println(testidata.getTable("palaute").getValue(0, "arvosana"));
		System.out.println(palautteet.get(0).getArvosana());

		assertEquals( (int) (Integer.valueOf((String) testidata.getTable("palaute").getValue(0, "arvosana"))), palautteet.get(0).getArvosana());

	}
	
	@Test
	public void testaaTalletaPalaute() throws Exception {
		
		final String sql = "insert into palaute (arvosana, palauteteksti, opiskelijanumero) "
				+ "values (?,?,?)";
		final int arvosana = palaute.getArvosana();
		final String palauteteksti = palaute.getPalauteteksti();
		final int opiskelijanumero = palaute.getOpiskelijanumero();
		KeyHolder holder = new GeneratedKeyHolder();
		
		PalauteDAOimpl dao = new PalauteDAOimpl();
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(new SingleConnectionDataSource(jdbcConnection, false));
		dao.setJdbcTemplate(jdbcTemplate);
		
		jdbcTemplate.update(new PreparedStatementCreator(){
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, new String[] { "palaute_id" });
				ps.setInt(1, arvosana);
				ps.setString(2, palauteteksti);
				ps.setInt(3, opiskelijanumero);
				return ps;
			}
		}, holder);
		
		String sql2 = "select (arvosana, palauteteksti, opiskelijanumero)"
				+ " from palaute where palaute_id = " + palaute.getPalaute_id() + ";";
		RowMapper<Palaute> mapper = new PalauteRowMapper();
		palaute2 = jdbcTemplate.queryForObject(sql2, mapper);
		
		assertEquals(palaute, palaute2);
	}
	
	@After
	public void rollback() throws SQLException {
		jdbcConnection.rollback();
		jdbcConnection.close();
	}
}