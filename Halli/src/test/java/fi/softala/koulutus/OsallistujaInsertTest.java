package fi.softala.koulutus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

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

import fi.softala.bean.Osallistuja;
import fi.softala.dao.OsallistujaDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:testiContext.xml" })
@Transactional
@DatabaseSetup("classpath:testidata.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionDbUnitTestExecutionListener.class })
public class OsallistujaInsertTest {

	@Inject
	private OsallistujaDAO dao;

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Test
	public void Ilmoittaudu() {
		Osallistuja osallistuja = new Osallistuja();
		osallistuja.setEtunimi("Ossi");
		osallistuja.setSukunimi("Osallistuja");
		osallistuja.setOpiskelijanro("1204567");
		osallistuja.setSahkoposti("ossi", "osallistuja");
		String[] osallistumiset = new String[] { "3" };
		dao.talleta(osallistuja, osallistumiset);

		String sql = "Select osallistuja_id from osallistuja "
				+ "where osallistujan_opiskelijanro = '1204567'";
		Integer id = jdbcTemplate.queryForObject(sql, Integer.class);
		assertNotNull(id);

		sql = "Select osallistuja_id from ilmoittautuminen where osallistuja_id = "
				+ id;
		List<Integer> ilmoittautumiset = jdbcTemplate.queryForList(sql,
				Integer.class);
		assertEquals(ilmoittautumiset.size(), osallistumiset.length);
	}
}