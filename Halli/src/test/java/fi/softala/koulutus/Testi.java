package fi.softala.koulutus;

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

import fi.softala.bean.Koulutustilaisuus;
import fi.softala.dao.KoulutusHakuDAOImpl;

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
		KoulutusHakuDAOImpl dao = new KoulutusHakuDAOImpl();
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(new SingleConnectionDataSource(jdbcConnection, false));
		dao.setJdbcTemplate(jdbcTemplate);
		List<Koulutustilaisuus> koulutukset = dao.haeTulevat();
		
		System.out.println(testidata.getTable("koulutustilaisuus").getValue(0, "aihe"));
		System.out.println(koulutukset.get(0).getAihe());
		assertEquals("Windows XP - Legenda el‰‰", koulutukset.get(0).getAihe());
	}
	
	@After
	public void rollback() throws SQLException {
		jdbcConnection.rollback();
		jdbcConnection.close();
	}
}
