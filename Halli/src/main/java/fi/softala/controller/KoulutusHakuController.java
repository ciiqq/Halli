package fi.softala.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.bean.Koulutustilaisuus;
import fi.softala.service.KoulutuksenVahvistusService;
import fi.softala.service.KoulutusHakuService;

/**
 * 
 * @author Miro Mets�nheimo
 * @author ...
 *
 */

@Controller
@RequestMapping(value = "/")
public class KoulutusHakuController {

	@Inject
	private KoulutuksenVahvistusService vahvistusservice;
	
	@Inject
	private KoulutusHakuService hakuservice;

	public void setService(KoulutusHakuService service) {
		this.hakuservice = service;
	}

	public void setService(KoulutuksenVahvistusService service) {
		this.vahvistusservice = service;
	}
	
	@RequestMapping(value = "opettaja/koulutukset/julkaisemattomat", method = RequestMethod.GET)
	public String listaaVahvistamattomatKoulutukset(Model model) {
		List<Koulutustilaisuus> koulutukset = hakuservice.haeVahvistamattomat();
		model.addAttribute("koulutukset", koulutukset);
		return "julkaisemattomatkoulutukset";
	}
	
	@RequestMapping(value = "vahvistakoulutus", method = RequestMethod.POST)
	public String VahvistaKoulutus(Model model, HttpServletRequest request){
		String vahvistettavat = request.getParameter("valitutkoulutukset");

		vahvistusservice.VahvistaKoulutus(vahvistettavat);
		return "uusi_ui";
	}
	
	@RequestMapping(value = "VahvistaKaikkiKoulutukset")
	public String VahvistaKaikkiKoulutukset() {
		vahvistusservice.VahvistaKaikkiKoulutukset();
		return "uusi_ui";
	}
	
	@RequestMapping(value="opettaja/aikataulut", method=RequestMethod.GET)
	public String getCreateForm() {
		return "aikataulut";
	}
	
	@RequestMapping(value="opettaja/kouluttajat", method=RequestMethod.GET)
	public String getCreateForm2() {
		return "kouluttajat";
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
}