package fi.softala.koulutuslistaus;

import static org.junit.Assert.*;

<<<<<<< HEAD
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
=======
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
>>>>>>> 4419dc95f6dfd28b358bfe1c6bfe7780880f0698
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.softala.bean.Aikatauluslotti;
import fi.softala.dao.KoulutusDAO;
import fi.softala.dao.KoulutusRowMapper;

public class KoulutuslistausTest {
	
<<<<<<< HEAD
	@BeforeClass //Ajetaan ennen kaikkia testejä.  Tänne voi laittaa alustukset, jotka ovat kaikille testeille yhteiset
    public static void setUpClass() throws Exception {
    }

    @AfterClass //Ajetaan kaikkien testien jälkeen
    public static void tearDownClass() throws Exception {
    }

    @Before //Ajetaan ennen jokaista testiä
    public void setUp() {
    }

    @After //Ajetaan jokaisen testin jälkeen
    public void tearDown() {
    }
	
=======
	@Inject
	private KoulutusDAO dao;
	
	public KoulutusDAO getDao() {
		return dao;
	}

	public void setDao(KoulutusDAO dao) {
		this.dao = dao;
	}

	@Test
	public void koulutusListausTest(){

		//List<Aikatauluslotti> koulutuslista = dao.haeKoulutukset();
		
		List<Aikatauluslotti> testilista = new ArrayList<Aikatauluslotti>();
		
		String lol = "moi";
		
		assertNotNull(lol);
	}
>>>>>>> 4419dc95f6dfd28b358bfe1c6bfe7780880f0698
	
	
	@Test
	public void testaaKoulutuksenHaku(){
		KoulutusDAO test = new MockKoulutus();
		Aikatauluslotti koulutusTest = test.haeKoulutus(1);
		assertNotNull(koulutusTest);		
	}
	
	@Test
	public void testaaKoulutusListaus(){
		
		KoulutusDAO test = new MockKoulutus();		
		
		List<Aikatauluslotti> actual = test.haeKoulutukset();
		List<String> expected = Arrays.asList("fee", "fi", "foe");		
			
	
		
		assertEquals(actual, expected);            
		
		
	}

}
