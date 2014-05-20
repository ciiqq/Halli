package fi.softala.koulutus;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fi.softala.bean.Palaute;

@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testiContext.xml"})
public class PalauteTest {
	
	private Palaute palaute;
	
	@Before
	public void setup() {
		palaute = new Palaute();
		palaute.setOpiskelijanro("a1202757");
	}
	
	@Test
	public void muotoileOpiskelijanro() {
		assertEquals(palaute.getOpiskelijanro(), "1202757");
	}
}
