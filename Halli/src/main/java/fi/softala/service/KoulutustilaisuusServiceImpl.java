package fi.softala.service;

import fi.softala.bean.Koulutustilaisuus;
import fi.softala.dao.KoulutusDAO;
import fi.softala.dao.KoulutusDAOImpl;

import javax.inject.Inject;

public class KoulutustilaisuusServiceImpl implements KoulutustilaisuusService {
	
	@Inject
	private KoulutusDAO koulutusDao;

	public void tallennaKoulutustilaisuus(Koulutustilaisuus koulutustilaisuus) {
		
		
	}

	public void setKoulutusDao(KoulutusDAOImpl koulutusDao) {
		this.koulutusDao = koulutusDao;
	}

}
