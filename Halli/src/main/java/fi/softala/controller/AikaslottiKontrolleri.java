package fi.softala.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.DAO.AikatauluslottiDAO;

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

}
