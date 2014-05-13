package fi.softala.dao;

import static org.junit.Assert.*;

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

import fi.softala.DAO.KouluttajienLisaysDAO;
import fi.softala.bean.Kouluttaja;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testiContext.xml"})
@Transactional(readOnly = true)
@DatabaseSetup("classpath:testidata.xml") // Inserttaa jokaisen testin (transaktion) alussa testidatan tietokantaan
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class })

public class KouluttajienLisaysDaoTest {
	
	@Inject
	private KouluttajienLisaysDAO dao;
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void kouluttajienHaku() {
		List<Kouluttaja> kouluttajat = dao.kouluttajienHaku();
		assertEquals("Kalle", kouluttajat.get(0).getEtunimi());
	}
	
	@Test
	public void kouluttajanHaku() {
		Kouluttaja kouluttaja = dao.kouluttajanHaku("1234567");
		assertEquals("Tarmo Testaaja", kouluttaja.getEtunimi() + " " + kouluttaja.getSukunimi());
	}
	
	@Test
	public void kouluttajanLisays() {
		
		Kouluttaja kouluttaja = new Kouluttaja();
		kouluttaja.setEtunimi("Joni");
		kouluttaja.setSukunimi("Testaaja");
		kouluttaja.setOpiskelijanro("9999999");
		kouluttaja.setSalasana("salasana");
		kouluttaja.setSuola("suola");
		
		dao.kouluttajanLisays(kouluttaja);

		String sql = "Select henkilotunnus from henkilo where henkilotunnus = '9999999'";
		String henkilotunnus = jdbcTemplate.queryForObject(sql, String.class);

		assertEquals(henkilotunnus, kouluttaja.getOpiskelijanro());
	}
	
	
}