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

	/**
	 * @RequestMapping(value = "palautteet", method = RequestMethod.GET) public
	 *                       ModelAndView palautelista(HttpServletRequest
	 *                       request,
	 * 
	 *                       HttpServletResponse response) throws Exception {
	 * 
	 *                       ModelMap model = new ModelMap();
	 * 
	 *                       model.addAttribute("palautteet", dao.haeKaikki());
	 *                       return new ModelAndView("palaute", model);
	 * 
	 *                       }
	 */

	@RequestMapping(value = "palautteet", method = RequestMethod.GET)
	public ModelAndView palautelista2(HttpServletRequest request,

	HttpServletResponse response) throws Exception {

		ModelMap model = new ModelMap();

		model.addAttribute("palautteet", dao.haeIdlla());
		return new ModelAndView("palaute", model);

	}

	@RequestMapping(value = "kaikkipalautteet", method = RequestMethod.GET)
	public ModelAndView palautelista3(HttpServletRequest request,

	HttpServletResponse response) throws Exception {

		ModelMap model = new ModelMap();

		model.addAttribute("kaikkipalautteet", dao.haeKaikki());
		return new ModelAndView("kaikkipalautteet", model);

	}

	@RequestMapping(value = "opiskelijanpalautteet", method = RequestMethod.GET)
	public ModelAndView palautelista4(HttpServletRequest request,

	HttpServletResponse response) throws Exception {

		ModelMap model = new ModelMap();

		model.addAttribute("opiskelijanpalautteet", dao.haeKouluttajaIdlla());
		return new ModelAndView("opiskelijanpalautteet", model);

	}

}