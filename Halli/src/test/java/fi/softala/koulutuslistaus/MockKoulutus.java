/**
 * 
 */
package fi.softala.koulutuslistaus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.bean.Aikatauluslotti;
import fi.softala.bean.Koulutustilaisuus;
import fi.softala.dao.KoulutusDAO;
import fi.softala.dao.KoulutusRowMapper;

/**
 * @author a1200880
 *
 */
public class MockKoulutus implements KoulutusDAO {
	
	@Inject
	private KoulutusDAO dao;
	
	public KoulutusDAO getDao() {
		return dao;
	}

	public void setDao(KoulutusDAO dao) {
		this.dao = dao;
	}

	public List<Aikatauluslotti> haeKoulutukset() {	
		
//		List<Aikatauluslotti> koulutuslista = new ArrayList<Aikatauluslotti>();
//		
//		Aikatauluslotti a = new Aikatauluslotti();
//		Koulutustilaisuus k = new Koulutustilaisuus();
//		k.setId(1);
//		a.setAlkukello("12:00");
//		a.setLoppukello("14:00");
//		a.setKoulutustila("5008");
//		a.setPvm("15.4.2014");
//		k.setAihe("SQL");
//		k.setKuvaus("SQL perusteet tiiviissä paketissa.");
//		k.setLahtotaso("Perustaso");
//		k.setNakyvyys(false);
//		a.setKoulutus(k);
//		
//		koulutuslista.add(a);
		
		List<Aikatauluslotti> koulutuslista = dao.haeKoulutukset();
		
	
		
		return koulutuslista;
	}

	public Aikatauluslotti haeKoulutus(int id) {
		Aikatauluslotti a = new Aikatauluslotti();
		Koulutustilaisuus k = new Koulutustilaisuus();
		k.setId(1);
		a.setAlkukello("12:00");
		a.setLoppukello("14:00");
		a.setKoulutustila("5008");
		a.setPvm("15.4.2014");
		k.setAihe("SQL");
		k.setKuvaus("SQL perusteet tiiviissä paketissa.");
		k.setLahtotaso("Perustaso");
		k.setNakyvyys(false);
		a.setKoulutus(k);
		return a;
	}
	
	
	

	

}
