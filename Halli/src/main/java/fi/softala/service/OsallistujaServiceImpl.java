package fi.softala.service;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import fi.softala.bean.Osallistuja;
import fi.softala.dao.OsallistujaDAO;


@Service
public class OsallistujaServiceImpl implements OsallistujaService {
	
	@Inject
	private OsallistujaDAO dao;
	
	private Osallistuja o = new Osallistuja();
	
	private String[] idTaulukko;
	
	public OsallistujaDAO getDao() {
		return dao;
	}

	public void setDao(OsallistujaDAO dao) {
		this.dao = dao;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String submit = request.getParameter("submit");
		
		System.out.println(submit);
		
		String tunnus = request.getParameter("tunnus");
		System.out.println("Tunnus= "+tunnus);
		
		if (submit.equals("lisays")){
			String enimi = request.getParameter("etunimi");
			String snimi = request.getParameter("sukunimi");
			String onro = request.getParameter("opiskelijanro");
			
			String koulutusId = request.getParameter("valitutkoulutukset");
			
			o.setEtunimi(enimi);
			o.setSukunimi(snimi);
			o.setOpiskelijanro(onro);
			idTaulukko = koulutusId.split(",");
		}

	}
		
		
	
	public void talleta(){
		dao.talleta(o, idTaulukko);
	}
	
}
