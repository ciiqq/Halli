package fi.softala.service;

import fi.softala.bean.Koulutustilaisuus;
import fi.softala.dao.KoulutusDAO;
import fi.softala.dao.KoulutusDAOImpl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class KoulutustilaisuusServiceImpl implements KoulutustilaisuusService {
	
	@Inject
	private KoulutusDAO koulutusDao;

	public void tallennaKoulutustilaisuus(Koulutustilaisuus koulutustilaisuus) {
		koulutusDao.tallennaKoulussuunnitelma(koulutustilaisuus);		
	}

	public void setKoulutusDao(KoulutusDAOImpl koulutusDao) {
		this.koulutusDao = koulutusDao;
	}

}
