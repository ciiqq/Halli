package fi.softala.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import fi.softala.bean.Osallistuja;
import fi.softala.dao.OsallistujaDAO;


@Service
public class OsallistujaServiceImpl implements OsallistujaService {
	
	@Inject
	private OsallistujaDAO dao;
	
	public OsallistujaDAO getDao() {
		return dao;
	}

	public void setDao(OsallistujaDAO dao) {
		this.dao = dao;
	}
		
		
	public void enTieda(Osallistuja o, String osallistumiset){
		System.out.println(o + " " + osallistumiset);
		tallenna(o, osallistumiset);
	}

		
	public void tallenna(Osallistuja o, String osallistumiset){
		String[] idTaulukko = osallistumiset.split(",");
		dao.talleta(o, idTaulukko);
	}	
	
}
