package fi.softala.controller;

import java.util.Enumeration;
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
@RequestMapping(value = "/koulutukset")
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
	
	@RequestMapping(value = "vahvistamattomat", method = RequestMethod.GET)
	public String listaaVahvistamattomatKoulutukset(Model model) {
		List<Koulutustilaisuus> koulutukset = hakuservice.haeVahvistamattomat();
		model.addAttribute("koulutukset", koulutukset);
		return "vahvistamattomatkoulutukset";
	}
	
	@RequestMapping(value = "vahvistakoulutus", method = RequestMethod.POST)
	public String VahvistaKoulutus(HttpServletRequest req) {
		Enumeration<String> checkboxasd = req.getParameterNames();
		System.out.println(checkboxasd);
		vahvistusservice.VahvistaKoulutus(0);
		return "vahvistamattomatkoulutukset";
	}
	
	@RequestMapping(value = "VahvistaKaikkiKoulutukset")
	public void VahvistaKaikkiKoulutukset() {
		vahvistusservice.VahvistaKaikkiKoulutukset();
	}
	
	@RequestMapping(value = "uusi_ui", method = RequestMethod.GET)
	public String listaaVahvistamattomatKoulutuksetUusiUi(Model model) {
		List<Koulutustilaisuus> koulutukset = hakuservice.haeVahvistamattomat();
		model.addAttribute("koulutukset", koulutukset);
		return "vahvistamattomat_uusi_ui";
	}
}