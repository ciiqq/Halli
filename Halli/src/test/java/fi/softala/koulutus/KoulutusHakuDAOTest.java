package fi.softala.koulutus;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import fi.softala.bean.Koulutustilaisuus;
import fi.softala.dao.KoulutusHakuDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testiContext.xml"})
@Transactional(readOnly = true)
@DatabaseSetup("classpath:testidata.xml") // Inserttaa jokaisen testin (transaktion) alussa testidatan tietokantaan
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class })

public class KoulutusHakuDAOTest {
	
	@Inject
	private KoulutusHakuDAO dao;
	
	@Test
	public void haeTulevatKoulutukset() {
		List<Koulutustilaisuus> koulutukset = dao.haeTulevat();
		assertEquals("jQueryn alkeet", koulutukset.get(0).getAihe());
	}
	
	@Test
	public void haeMenneetKoulutukset() {
		List<Koulutustilaisuus> koulutukset = dao.haeMenneet();
		assertEquals("Java-ohjelmointi", koulutukset.get(0).getAihe());
	}
	
	@Test
	public void haeHakusanalla() {
		List<Koulutustilaisuus> koulutukset = dao.haeHakusanalla("gitti");
		assertEquals("Git-versionhallinta: mikä se on?", koulutukset.get(0).getAihe());
	}
	
	@Test
	public void haeAvainsanalla() {
		List<Koulutustilaisuus> koulutukset = dao.haeAvainsanalla("ohjelmointi");
		assertEquals("Teknologia ja anime", koulutukset.get(0).getAihe());
	}
}
