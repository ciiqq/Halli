package fi.softala.controller;

import org.springframework.stereotype.Controller;
import fi.softala.dao.*;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/palaute")
public class PalauteController {

	@Inject
	private PalauteDAO dao;

	public PalauteDAO getDao() {

		return dao;
	}

	public void setDao(PalauteDAO dao) {

		this.dao = dao;
	}

	@RequestMapping(value = "palautteet", method = RequestMethod.GET)
	public ModelAndView palautelista2(HttpServletRequest request,

	HttpServletResponse response) throws Exception {

		ModelMap model = new ModelMap();

		model.addAttribute("palautteet", dao.haeIdlla());
		return new ModelAndView("palaute", model);

	}

	@RequestMapping(value = "kaikkikoulutukset", method = RequestMethod.GET)
	public ModelAndView palautelista3(HttpServletRequest request,

	HttpServletResponse response) throws Exception {

		ModelMap model = new ModelMap();

		model.addAttribute("kaikkikoulutukset", dao.haeKaikki());
		return new ModelAndView("kaikkikoulutukset", model);

	}

}
