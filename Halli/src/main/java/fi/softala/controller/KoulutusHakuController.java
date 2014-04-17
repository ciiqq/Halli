package fi.softala.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.bean.Koulutustilaisuus;
import fi.softala.service.KoulutusHakuService;

/**
 * 
 * @author Timo Kottonen
 * @author ...
 *
 */

@Controller
@RequestMapping(value = "/koulutukset")
public class KoulutusHakuController {

	@Inject
	private KoulutusHakuService hakuservice;

	public KoulutusHakuService getService() {
		return hakuservice;
	}

	public void setService(KoulutusHakuService service) {
		this.hakuservice = service;
	}

	@RequestMapping(value = "testi", method = RequestMethod.GET)
	public String listaaKoulutukset(Model model) {
		List<Koulutustilaisuus> koulutukset = hakuservice.haeKaikki();
		model.addAttribute("koulutukset", koulutukset);
		return "listaus";
	}
	@RequestMapping(value = "vahvistamattomat", method = RequestMethod.GET)
	public String listaaVahvistamattomatKoulutukset(Model model) {
		List<Koulutustilaisuus> koulutukset = hakuservice.haeVahvistamattomat();
		model.addAttribute("koulutukset", koulutukset);
		return "vahvistamattomatkoulutukset";
	}
	
}
