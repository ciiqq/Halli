package fi.softala.controller;

import java.text.SimpleDateFormat;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.DAO.AikatauluslottiDAO;
import fi.softala.bean.Aikatauluslotti;
import fi.softala.bean.Kouluttaja;

@Controller
@RequestMapping (value="/")
public class AikaslottiKontrolleri {
	
	@Inject
	private AikatauluslottiDAO dao;
	
	public AikatauluslottiDAO getDao() {
		return dao;
	}

	public void setDao(AikatauluslottiDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="opettaja/aikataulut", method=RequestMethod.GET)
	public String aikatauluslottiLista() {
		return "aikataulut";
		
	}
	
	@RequestMapping(value="opettaja/aikataulut/lisaa", method=RequestMethod.POST)
	public String lisaaSlotti(HttpServletRequest request, Model model) {
		Aikatauluslotti a = new Aikatauluslotti();
//		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
//		String date = DATE_FORMAT.format(request.getParameter("paivamaara"));
		a.setPvm(request.getParameter("paivamaara"));
		a.setAlkukello(request.getParameter("alkuaika"));
		a.setLoppukello(request.getParameter("loppuaika"));
		a.setKoulutustila(request.getParameter("tila"));
		
		dao.talleta(a);
		
		return "testi";
		
	}

}
