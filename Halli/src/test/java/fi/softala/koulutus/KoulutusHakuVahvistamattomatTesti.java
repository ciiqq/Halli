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
@ContextConfiguration(locations = {"classpath:testiContext.xml" })
@Transactional(readOnly = true)
@DatabaseSetup("classpath:testidata.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionDbUnitTestExecutionListener.class })
public class KoulutusHakuVahvistamattomatTesti {

	@Inject
	private KoulutusHakuDAO dao;

	@Test
	public void haeVahvistamattomatKoulutukset() {
		List<Koulutustilaisuus> koulutukset = dao.haeVahvistamattomat();
		System.out.println(koulutukset);
		assertEquals(0, koulutukset.get(0)
				.getNakyvyys());
	}

	
}