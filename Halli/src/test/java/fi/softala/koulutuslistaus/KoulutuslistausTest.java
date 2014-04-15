package fi.softala.koulutuslistaus;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fi.softala.bean.Aikatauluslotti;
import fi.softala.dao.KoulutusDAO;

public class KoulutuslistausTest {
	
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
