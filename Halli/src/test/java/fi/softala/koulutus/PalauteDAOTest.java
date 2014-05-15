package fi.softala.koulutus;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
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
import fi.softala.dao.PalauteDAO;

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
	private PalauteDAO dao;
	
	public void setPalauteDao(PalauteDAO dao) {
		this.dao = dao;
	}
	
	public PalauteDAO getPalauteDao() {
		return dao;
	}
	
	@Inject
	private JdbcTemplate template;
	
	public void setJdbcTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return template;
	}
	
	@Before
	public void init() {
		palaute = new Palaute();
		palaute.setArvosana(4);
		palaute.setOpiskelijanro("7654321");
		palaute.setPalauteteksti(palauteteksti);
		koulutusId = 4;
	}
	
	@Test
	@Transactional(readOnly = false)
	public void tallennaPalaute() {
		dao.talletaPalaute(palaute, koulutusId);
		System.out.println(palaute.getPalaute_id());
		
		String sql = "select osallistujan_opiskelijanro "
				+ "from ilmoittautuminen where palaute_id = " + palaute.getPalaute_id() + ";";
		
		List<String> list = template.queryForList(sql, String.class);
		
		String opiskelijanro = list.get(1);
		
		assertEquals("7654321", opiskelijanro);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void haeKaikki() {
		List<Palaute> palautteet = dao.haeKaikki();
		System.out.println(palautteet.size());
		assertEquals(palautteet.get(0).getPalauteteksti(), palauteteksti);
	}
	
	@Test
	@Transactional(readOnly = true)
	public void haePalautteet() {
		String opiskelijanro = "1102030";
		
		List<Palaute> lista = dao.haePalautteet(opiskelijanro);
		assertTrue(lista.size() != 0);
	}
	
}
