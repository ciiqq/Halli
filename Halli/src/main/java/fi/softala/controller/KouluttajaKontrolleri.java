package fi.softala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.bean.Kouluttaja;


@Controller
@RequestMapping (value="/mikatahansa")
public class KouluttajaKontrolleri {
	
	@RequestMapping(value="kouluttajien_lisays", method=RequestMethod.GET)
	public String kouluttajienLisaysSivu(Model model) {
		Kouluttaja kouluttaja = new Kouluttaja();
		model.addAttribute("kouluttaja", kouluttaja);
		
		return "kouluttajien_lisays/lisays";
	}
	
	@RequestMapping(value="kouluttajien_lisays", method=RequestMethod.POST)
	public String create( @ModelAttribute(value="kouluttaja") Kouluttaja kouluttaja) {
		System.err.println(kouluttaja.getEtunimi());
		return "kouluttajien_lisays/lisays";
	}
}

