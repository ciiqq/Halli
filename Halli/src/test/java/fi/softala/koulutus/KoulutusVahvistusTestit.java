package fi.softala.koulutus;

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

import fi.softala.bean.Koulutustilaisuus;
import fi.softala.dao.KoulutusHakuDAO;
import fi.softala.dao.KoulutusVahvistusDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testiContext.xml" })
@Transactional(readOnly = true)
@DatabaseSetup("classpath:testidata.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionDbUnitTestExecutionListener.class })
public class KoulutusVahvistusTestit {

	@Inject
	KoulutusVahvistusDAO vahvistusDAO;
	@Inject 
	KoulutusHakuDAO hakuDAO;
	
	
	@Test
	public void koulutuksenVahvistusTesti() {
		List<Koulutustilaisuus> koulutukset = hakuDAO.haeVahvistamattomat();
		assertEquals(0, koulutukset.get(0)
				.getNakyvyys());
		
		//muutos vahvistetaan id:llä 1 oleva koulutus
		String [] vahvistettavat = {"1"};
		vahvistusDAO.VahvistaKoulutus(vahvistettavat);
		
		
		//testi ettei id 1 ole enään vahvistamaton.
		koulutukset = hakuDAO.haeKaikki();
		assertEquals(1,koulutukset.get(0).getNakyvyys());
	}
	@Test
	public void koulutuksenVahvistusKaikkiTesti() {
		//testi että on vahvistamattomia testejä
		List<Koulutustilaisuus> koulutukset = hakuDAO.haeVahvistamattomat();
		assertEquals(0, koulutukset.get(0)
				.getNakyvyys());
		
		
		vahvistusDAO.VahvistaKaikkiKoulutukset();
		
		
		//ja testi ettei kannassa enään ole vahvistamatonta tilaisuutta
		koulutukset = hakuDAO.haeVahvistamattomat();
		assertTrue(koulutukset.isEmpty());
	}

}
