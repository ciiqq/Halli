package fi.softala.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.dbunit.*;
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

import fi.softala.bean.Kouluttaja;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testiContext.xml"})
@Transactional(readOnly = true)
@DatabaseSetup("classpath:testidata.xml") // Inserttaa jokaisen testin (transaktion) alussa testidatan tietokantaan
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class })

public class HaeKouluttajatDaoTest {
	
	@Inject
	private HaeKouluttajatDao dao;
	
	@Test
	public void haeKouluttajat() {
		List<Kouluttaja> kouluttajat = dao.haeKouluttajat();
		assertEquals("1122334", kouluttajat.get(0).getOpiskelijanro());
		assertEquals("Kalle", kouluttajat.get(0).getEtunimi());
		assertEquals("Kouluttaja", kouluttajat.get(0).getSukunimi());
}

}
