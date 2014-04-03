package fi.softala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.bean.Palaute;


@Controller
@RequestMapping (value="/testaus")
public class Controller1 {
	
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
}

