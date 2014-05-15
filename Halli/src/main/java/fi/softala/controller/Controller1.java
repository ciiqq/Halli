package fi.softala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping (value="/")
public class Controller1 {
	
	@RequestMapping(value="opettaja/aikataulut", method=RequestMethod.GET)
	public String getCreateForm() {
		return "aikataulut";
	}
	
	@RequestMapping(value="opettaja/kouluttajat", method=RequestMethod.GET)
	public String getCreateForm2() {
		return "kouluttajat";
	}
	
	@RequestMapping(value="opettaja/koulutukset/julkaisemattomat", method=RequestMethod.GET)
	public String getCreateForm3() {
		return "julkaisemattomatkoulutukset";
	}
	
	@RequestMapping(value="opettaja/koulutukset/julkaisemattomat/koulutustiedot", method=RequestMethod.GET)
	public String getCreateForm4() {
		return "koulutustiedot";
	}
	
	@RequestMapping(value="opettaja/koulutukset/julkaisemattomat/muokkaa", method=RequestMethod.GET)
	public String getCreateFormXXX() {
		return "muokkaakoulutusta";
	}
	
	@RequestMapping(value="opettaja/koulutukset/julkaisemattomat/uusikoulutus", method=RequestMethod.GET)
	public String getCreateForm5() {
		return "uusikoulutus";
	}

	@RequestMapping(value="opettaja/koulutukset/julkaistut", method=RequestMethod.GET)
	public String getCreateForm6() {
		return "julkaistutkoulutukset";
	}
	
	@RequestMapping(value="opettaja/palautteet", method=RequestMethod.GET)
	public String getCreateForm7() {
		return "palautteet";
	}
	
	@RequestMapping(value="opettaja/palautteet/koulutus", method=RequestMethod.GET)
	public String getCreateForm8() {
		return "palautteetkoulutus";
	}
	
	@RequestMapping(value="kouluttaja/koulutus", method=RequestMethod.GET)
	public String getCreateForm9() {
		return "kouluttaja-uusikoulutus";
	}
	
	@RequestMapping(value="kouluttaja/koulutus/muokkaa", method=RequestMethod.GET)
	public String getCreateForm10() {
		return "kouluttaja-muokkaakoulutusta";
	}
	
	@RequestMapping(value="kouluttaja/palaute", method=RequestMethod.GET)
	public String getCreateForm11() {
		return "kouluttaja-palaute";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String getLogin() {
		return "login";
	}
	
}
