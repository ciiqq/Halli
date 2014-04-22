package fi.softala.testi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import fi.softala.bean.Palaute;

public class PalauteTest {

	private Palaute palaute;
	
	@Before
	public void luoPalaute(){
		// annetaan palaute-oliolle testidata jota vasten testit suoritetaan
		palaute = new Palaute();
		palaute.setArvosana(1);
		palaute.setOpiskelijanumero(1234567);
		palaute.setPalaute_id(1);
		palaute.setPalauteteksti("Palaute teksti 123!");
	}
	
	@Test
	public void testaaArvosana(){
		int todellinen = palaute.getArvosana();
		int odotettu = 1;
		assertEquals("Kentän arvosana arvo ei ollut odotettu", odotettu, todellinen);
	}
	
	@Test
	public void testaaOpiskelijanumero(){
		int todellinen = palaute.getOpiskelijanumero();
		int odotettu = 1234567;
		assertEquals("Kentän opiskelijanumero arvo ei ollut odotettu", odotettu, todellinen);
	}
	
	@Test
	public void testaaPalaute_id(){
		int todellinen = palaute.getPalaute_id();
		int odotettu = 1;
		assertEquals("Kentän palaute_id arvo ei ollut odotettu", odotettu, todellinen);
	}
	
	@Test
	public void testaaPalauteteksti(){
		String todellinen = palaute.getPalauteteksti();
		String odotettu = "Palaute teksti 123!";
		assertEquals("Kentän palauteteksti arvo ei ollut odotettu", odotettu, todellinen);
	}
	
	@Ignore
	public void testaaPalautetekstiB()
	{
		String todellinen = palaute.getPalauteteksti();
		String odotettu = "hölynpöly";
		assertEquals("Kentän palauteteksti arvo ei ollut odotettu", odotettu, todellinen);
	}
	
}
