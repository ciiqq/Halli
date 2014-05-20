package fi.softala.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.dbunit.dataset.IDataSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import fi.softala.bean.Palaute;

public class Testi {
	
	private Connection jdbcConnection;
	private IDataSet testidata;

	@Before
	public void setup() throws Exception {
		TietokantaTesti testi = new TietokantaTesti();
		this.jdbcConnection = testi.haeJdbcConnection();
		this.testidata = testi.haeTestidata();
	}
	
	@Test
	public void setupOK() {
		assertNotNull(jdbcConnection);
		assertNotNull(testidata);
	}
	
	@Test
	public void testaa() throws Exception {
		PalauteDAOimpl dao = new PalauteDAOimpl();
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(new SingleConnectionDataSource(jdbcConnection, false));
		dao.setJdbcTemplate(jdbcTemplate);
		List<Palaute> palautteet = dao.haeKaikki();
		
		System.out.print(testidata.getTable("palaute").getValue(0, "arvosana"));
		System.out.print(testidata.getTable("palaute").getValue(0, "palauteteksti"));
		System.out.println(palautteet.get(0).getPalauteteksti());
		assertEquals(testidata.getTable("palaute").getValue(0, "palauteteksti"),
				palautteet.get(0).getPalauteteksti());
	}
	
	@After
	public void rollback() throws SQLException {
		jdbcConnection.rollback();
		jdbcConnection.close();
	}
}