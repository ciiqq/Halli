package fi.softala.halli;

/**
 * @author Jiri
 */

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import fi.softala.bean.Aikatauluslotti;
import fi.softala.bean.Avainsana;
import fi.softala.bean.Henkilo;
import fi.softala.bean.Koulutustilaisuus;
import fi.softala.dao.KoulutusDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:testiContext.xml" })
@Transactional(readOnly = true)
@DatabaseSetup("classpath:testidata.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionDbUnitTestExecutionListener.class })
public class KoulutusHakuTestit {

	@Inject
	private KoulutusDAO dao;

	@Test
	public void haeVahvistamattomatKoulutukset() {
		List<Koulutustilaisuus> koulutukset = dao.haeKoulutukset(false);
		for (Koulutustilaisuus kt : koulutukset) {
			assertEquals(false, kt.getNakyvyys());
		}
	}

	@Test
	public void haeVahvistetutKoulutukset() {
		List<Koulutustilaisuus> koulutukset = dao.haeKoulutukset(true);
		for (Koulutustilaisuus kt : koulutukset) {
			assertEquals(true, kt.getNakyvyys());
		}
	}

	@Test
	public void haeTiettyKoulutus() {
		Koulutustilaisuus kt = dao.haeKoulutus(1);
		assertEquals("Scrum", kt.getAihe());

	}
	
	@Test
	public void koulutuksenVahvistusTesti() {
		// tsekataan että on vahvistamaton koulutus
		List<Koulutustilaisuus> koulutukset = dao.haeKoulutukset(false);
		assertEquals(false, koulutukset.get(0).getNakyvyys());

		// muutos vahvistetaan id:ll� 1 oleva koulutus
		dao.julkaiseKoulutus(1);

		// testi ettei id 1 ole enään vahvistamaton.
		koulutukset = dao.haeKoulutukset(true);
		assertEquals(true, koulutukset.get(0).getNakyvyys());
	}
	@Test
	public void paivitaKoulutusTesti() {
		Koulutustilaisuus kt = new Koulutustilaisuus();
		kt.setId(1);
		kt.setAihe("Junit");
		kt.setKuvaus("Testaisu");
		kt.setLahtotaso("Keskitaso");
		kt.setNakyvyys(false);
		
		Koulutustilaisuus koulutus = dao.haeKoulutus(1);
		assertEquals("Scrum", koulutus.getAihe());
		
		dao.paivitaKoulutus(kt);
		
		koulutus = dao.haeKoulutus(1);
		assertEquals("Junit", koulutus.getAihe());

		
	}
	@Test
	public void peruutaKoulutusTesti() {
		Koulutustilaisuus kt = new Koulutustilaisuus();
		kt.setId(1);
		kt.setAihe("Junit");
		kt.setKuvaus("Testaisu");
		kt.setLahtotaso("Keskitaso");
		kt.setNakyvyys(false);
		
		Koulutustilaisuus koulutus = dao.haeKoulutus(1);
		assertEquals("Scrum", koulutus.getAihe());
		
		dao.peruutaKoulutus(1);
		
		try{
		assertNull(dao.haeKoulutus(1));

	}catch (EmptyResultDataAccessException e) {
		System.out.println("Tyhjää tuli niinkuin piti");
	}
	}
	@Test
	public void haeAvainsanatTesti() {
		
		List <Avainsana> as = dao.haeAvainsanat(1);
	
		assertEquals("Scrum",as.get(0).getAvainsana());
	}
	@Test
	public void haeVapaatSlotitTesti() {
		
		List <Aikatauluslotti> as = dao.haeVapaatSlotit();
		
		for(Aikatauluslotti slotti: as){
		assertNull(slotti.getId());
		}
	}
	//EI TOIMI VIELÄ ja puuttuu henkilohakutesti
	@Test
	public void siirraKoulutusTesti() {
		
		
		Koulutustilaisuus koulutus = dao.haeKoulutus(1);
		assertEquals(1, koulutus.getAikaslotti().getId());
		
		dao.siirraKoulutus(1,7);
		
		koulutus = dao.haeKoulutus(1);
		
		assertEquals(7, koulutus.getAikaslotti().getId());
		

		
	}

	
}
