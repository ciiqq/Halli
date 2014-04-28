package fi.softala.service;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import fi.softala.dao.KoulutusVahvistusDAO;

/**
 * 
 * @author Miro Metsänheimo
 * @author ...
 *
 */

@Service
public class KoulutuksenVahvistusServiceImpl implements KoulutuksenVahvistusService {
		
	@Inject
	private KoulutusVahvistusDAO dao;

	public void VahvistaKoulutus(int kID) {
		dao.VahvistaKoulutus(kID);
	}

	public void VahvistaKaikkiKoulutukset() {
		dao.VahvistaKaikkiKoulutukset();
	}
}
