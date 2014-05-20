package fi.softala.dao;

import static org.junit.Assert.*;

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

import fi.softala.bean.Palaute;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testiContext.xml"})
@Transactional(readOnly = true)
@DatabaseSetup("classpath:testidata.xml") // Inserttaa jokaisen testin (transaktion) alussa testidatan tietokantaan
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class })

public class PalauteDAOHakuTest {
	
	@Inject
	private PalauteDAO dao;
	
	@Test
	public void haeKaikkiPalalautteet() {
		List<Palaute> palautteet = dao.haeIdlla();
		assertEquals("Jooooh...", palautteet.get(0).getPalauteteksti());
	}

}