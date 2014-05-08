package fi.softala.controller;

import javax.inject.Inject;
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
	public String lisaaSlotti(@ModelAttribute(value="aikaslotti") @Valid Aikatauluslotti aikatauluslotti, BindingResult result, Model model) {
		return "testi";
		
	}

}
