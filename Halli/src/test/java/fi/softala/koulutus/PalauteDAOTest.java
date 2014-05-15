package fi.softala.koulutus;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Ignore;
// import org.junit.Ignore;
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

import fi.softala.bean.Palaute;
import fi.softala.service.PalauteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testiContext.xml"})
@DatabaseSetup("classpath:testidata.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class })
public class PalauteDAOTest {
	
	private final String palauteteksti = "Paras koulutus";
	private Palaute palaute;
	private int koulutusId;
	
	@Inject
	private JdbcTemplate template;
	
	public void setJdbcTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return template;
	}
	
	@Inject
	private PalauteService palauteService;
	
	public void setPalauteService (PalauteService palauteService) {
		this.palauteService = palauteService;
	}
	
	public PalauteService getPalauteService () {
		return palauteService;
	}
	
	@Before
	public void init() {
		palaute = new Palaute();
		palaute.setArvosana(4);
		palaute.setOpiskelijanro("7654321");
		palaute.setPalauteteksti(palauteteksti);
		koulutusId = 4;
	}
	
	@Ignore
	@Transactional(readOnly = false)
	public void tallennaPalaute() {
		palauteService.tallenna(palaute, koulutusId);
		
		List<Palaute> list = palauteService.haeIdlla(palaute.getPalaute_id());
		System.out.println("TEST tallennapalaute: " + list.get(1).getOpiskelijanro());
		String opiskelijanro = list.get(1).getOpiskelijanro();
		
		assertEquals("7654321", opiskelijanro);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void haeKaikki() {
		List<Palaute> palautteet = palauteService.haePalautteet();
		System.out.println(palautteet.size());
		assertEquals(palautteet.get(0).getPalauteteksti(), palauteteksti);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void haePalautteet() {
		String opiskelijanro = "1102030";
		
		List<Palaute> lista = palauteService.haePalautteet(opiskelijanro);
		assertTrue(lista.size() != 0);
	}
	
}
