package fi.softala.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.bean.Palaute;
import fi.softala.dao.PalauteDAO;

@Controller
@RequestMapping (value="/testaus")
public class Controller1 {
	
	@Inject
	private PalauteDAO dao;

	public PalauteDAO getDao() {
		return dao;
	}

	public void setDao(PalauteDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="uusi", method=RequestMethod.GET)
	public String getCreateForm() {
		return "testi2";
	}
	@RequestMapping(value="palaute", method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		Palaute tyhjaPalaute = new Palaute();
		model.addAttribute("palaute", tyhjaPalaute);
		return "palaute";
	}
	@RequestMapping(value="palaute", method=RequestMethod.POST)
	public String create(@ModelAttribute(value="palaute") Palaute palaute, Model model) {
		try {
			dao.talletaPalaute(palaute);
			model.addAttribute("onnistunutviesti", "Palautteen lähetys onnistui");	
			return "palaute";
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("virheviesti", "Palautteen lähetys ei onnistunut");
			return "palaute";
		}

	}
}

