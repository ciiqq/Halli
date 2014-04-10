package fi.softala.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import fi.softala.bean.Aikatauluslotti;
import fi.softala.DAO.AikatauluslottiDAO;

import javax.inject.Inject;


@Controller
@RequestMapping (value="/aikatauluslotti")
public class Aikatauluslottikontrolleri {
	@Inject
	AikatauluslottiDAO dao;
		
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

