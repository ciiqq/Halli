package fi.softala.koulutuslistaus;

import static org.junit.Assert.*;

import org.junit.Test;

import fi.softala.bean.Aikatauluslotti;
import fi.softala.dao.KoulutusDAO;

public class KoulutuslistausTest {
	
	
	
	@Test
	public void testaaKoulutustenHaku(){
		KoulutusDAO test = new MockKoulutus();
		Aikatauluslotti koulutusTest = test.haeKoulutus(1);
		assertNotNull(koulutusTest);
		
		
	}

}
