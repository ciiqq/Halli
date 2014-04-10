/**
 * 
 */
package fi.softala.koulutuslistaus;

import java.util.List;

import fi.softala.bean.Aikatauluslotti;
import fi.softala.bean.Koulutustilaisuus;
import fi.softala.dao.KoulutusDAO;

/**
 * @author a1200880
 *
 */
public class MockKoulutus implements KoulutusDAO {

	public List<Aikatauluslotti> haeKoulutukset() {
		// TODO Auto-generated method stub
		return null;
	}

	public Aikatauluslotti haeKoulutus(int id) {
		Aikatauluslotti a = new Aikatauluslotti();
		Koulutustilaisuus k = new Koulutustilaisuus();
		k.setId(1);
		k.setAihe("lol");
		a.setKoulutus(k);
		return a;
	}
	
	
	

	

}
