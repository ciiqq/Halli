package fi.softala.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import fi.softala.bean.Aikatauluslotti;
import fi.softala.DAO.AikatauluslottiDAO;

import javax.inject.Inject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping (value="/aikatauluslotti")
public class Aikatauluslottikontrolleri {
	@Inject
	AikatauluslottiDAO dao;

	@RequestMapping(value="lisaa", method=RequestMethod.GET)
	public String aikatauluslottiLisaa(Model model) { /* JariK 20140319 */
		List<Aikatauluslotti> aikatauluslotit = dao.haeKaikki();
 		model.addAttribute("aikatauluslotit", aikatauluslotit);
		return "aikatauluslottilisaa";
	}
	@RequestMapping(value="vaihdakuukausi", method=RequestMethod.GET)
	public String vaihdakuukausi(Model model, HttpServletRequest request) { /* JariK 20140319 */
		String vvvvkk = (String)request.getSession().getAttribute("vvvvkk");
		return "aikatauluslottilisaa";
	}	
	@RequestMapping(value="lista2", method=RequestMethod.GET)
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

