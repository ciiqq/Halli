package fi.softala.service;

import java.util.List;

import org.springframework.stereotype.Service;

import javax.inject.Inject;

import fi.softala.bean.Aikatauluslotti;
import fi.softala.dao.HaeAjatDao;
import fi.softala.dao.HaeAjatDaoImpl;

@Service
public class AikatauluslottiServiceImpl implements AikatauluslottiService {
	
	@Inject
	private HaeAjatDao haeAjatDao;
	
	public void setHaeAjatDao(HaeAjatDaoImpl haeAjatDao) {
		this.haeAjatDao = haeAjatDao;		
	}

	public List<Aikatauluslotti> haeVapaatAjat() {
		return haeAjatDao.haeVapaatAjat();
	}

}
