package fi.softala.controller;

import java.util.List;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;


import fi.softala.bean.Aikatauluslotti;
import fi.softala.DAO.AikatauluslottiDAO;

@Controller
@RequestMapping (value="/testaus")
public class Controller1 {
	@Inject
	AikatauluslottiDAO dao;
	
	@RequestMapping(value="uusi", method=RequestMethod.GET)
	public String getCreateForm() {
		return "testi2";
	}
	
	@RequestMapping(value="kouluttajien_lisays", method=RequestMethod.GET)
	public String kouluttajienLisaysSivu() {
		return "kouluttajien_lisays/lisays";
	}

	@RequestMapping(value="aikatauluslottilista2", method=RequestMethod.GET)
	public String aikatauluslottiLista(Model model) { /* JariK 20140319 */
		List<Aikatauluslotti> aikatauluslotit = dao.haeKaikki();
 		model.addAttribute("aikatauluslotit", aikatauluslotit);
		return "aikatauluslottilista";
	}
	@RequestMapping(value="kalenteri", method=RequestMethod.GET)
	public String kalenteri(Model model) { /* JariK 20140319 */
		return "kalenteri";
	}
	
}

