package fi.softala.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import fi.softala.bean.Kouluttaja;
import fi.softala.dao.HaeKouluttajatDaoImpl;

@Service
public class KouluttajaServiceImpl implements KouluttajaService {
	
	@Inject
	private HaeKouluttajatDaoImpl haeKouluttajatDao;
	
		

	public List<Kouluttaja> haeKouluttajat() {
		
		return haeKouluttajatDao.haeKouluttajat();
	}



	public void setHaeKouluttajatDao(HaeKouluttajatDaoImpl haeKouluttajatDao) {
		this.haeKouluttajatDao = haeKouluttajatDao;
	}

	
}
