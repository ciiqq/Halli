package fi.softala.koulutus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import fi.softala.bean.Koulutustilaisuus;
import fi.softala.dao.KoulutusHakuDAO;
import fi.softala.dao.KoulutusHakuDAOImpl;
import fi.softala.dao.KoulutusHakuRsE;
import fi.softala.service.KoulutusHakuService;
import fi.softala.service.KoulutusHakuServiceImpl;
import static org.junit.Assert.*;


/**
 * 
 * @author Jarkko Kuusela
 * 
 *
 */

public class KoulutustilaisuusTest {
	@Inject
	private KoulutusHakuService hakuservice;
//	@Before

	@Test
	public void testHaeKaikki() {
		List<Koulutustilaisuus> actualList = hakuservice.haeKaikki();
		
		assertEquals(2, actualList.get(0).getId());
		/*assertEquals("JQuery", actualList.get(0).getAihe());
		assertEquals("JQuery luento", actualList.get(0).getKuvaus());
		assertEquals("Alkeet", actualList.get(0).getLahtotaso());
		assertEquals(true, actualList.get(0).isNakyvyys());
		assertEquals("12:00", actualList.get(0).getSuomiKlo());
		assertEquals("18.03.2014", actualList.get(0).getSuomiPvm());
		assertEquals("Auditorio", actualList.get(0).getPaikka());
		assertEquals(1, actualList.get(0).getOpe().getId());
		assertEquals("1234567", actualList.get(0).getKouluttajat().get(0).getOpiskelijanro());
		assertEquals("1122334", actualList.get(0).getKouluttajat().get(1).getOpiskelijanro());
		assertEquals("Ohjelmointi", actualList.get(0).getAvainsanat().get(0));
		assertEquals("Tietokannat", actualList.get(0).getAvainsanat().get(1));
		
		assertEquals(3, actualList.get(1).getId());
		assertEquals("Scrum", actualList.get(1).getAihe());
		assertEquals("Rakennetaan legoilla", actualList.get(1).getKuvaus());
		assertEquals("haastava", actualList.get(1).getLahtotaso());
		assertEquals(true, actualList.get(1).isNakyvyys());
		assertEquals("08:00", actualList.get(1).getSuomiKlo());
		assertEquals("30.03.2014", actualList.get(1).getSuomiPvm());
		assertEquals("5007", actualList.get(1).getPaikka());
		assertEquals(1, actualList.get(1).getOpe().getId());
		assertEquals("3335556", actualList.get(1).getKouluttajat().get(0).getOpiskelijanro());
		assertEquals("Liiketoimintaprosessit", actualList.get(1).getAvainsanat().get(0));
		assertEquals("Tietohallinto", actualList.get(1).getAvainsanat().get(1));
		*/
	}
	
}
