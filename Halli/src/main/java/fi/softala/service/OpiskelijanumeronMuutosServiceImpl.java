package fi.softala.service;

import org.springframework.stereotype.Service;

@Service
public class OpiskelijanumeronMuutosServiceImpl implements OpiskelijanumeronMuutosService {

	/* (non-Javadoc)
	 * @see fi.softala.bean.OpiskelijanumeronMuutos#OpiskelijanumeronMuotoilu(java.lang.String)
	 */
	public String OpiskelijanumeronMuotoilu(String opiskelijanumero) {

		if (opiskelijanumero.indexOf("a") != -1) {
			System.out.println("A kirjain löytyy ja poistettu");
			return opiskelijanumero.substring(1);
		} else {
			System.out.println("Ei löytynyt a kirjainta");
			return opiskelijanumero;
		}
	}

}