package fi.softala.dao;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import fi.softala.bean.Koulutustilaisuus;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:testiContext.xml" })
@Transactional
@DatabaseSetup("classpath:testidata.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionDbUnitTestExecutionListener.class })

	

public class KoulutusDAOTest {
	
		@Inject
		private KoulutusDAO dao;

		@Inject
		private JdbcTemplate jdbcTemplate;

		@Test
		public void luoKoulutus() {
			Koulutustilaisuus koulutustilaisuus = new Koulutustilaisuus();
			koulutustilaisuus.setAihe("Softala");
			koulutustilaisuus.setLahtotaso("keskitaso");
			koulutustilaisuus.setNakyvyys(true);
			koulutustilaisuus.setKoulutusmenetelmat("esitys");
			dao.tallennaKoulussuunnitelma(koulutustilaisuus);

			String sql = "Select koulutus_id from koulutustilaisuus "
					+ "where aihe = 'Softala'";
			Integer id = jdbcTemplate.queryForObject(sql, Integer.class);
			assertNotNull(id);


		}
	}

