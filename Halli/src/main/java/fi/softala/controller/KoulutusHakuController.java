package fi.softala.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.bean.Koulutustilaisuus;
import fi.softala.service.KoulutusHakuService;

/**
 * 
 * @author Timo Kottonen
 * @author Teemu Kälviäinen
 *
 */

@Controller
@RequestMapping(value = "/")
public class KoulutusHakuController {

	@Inject
	private KoulutusHakuService hakuservice;

	public KoulutusHakuService getService() {
		return hakuservice;
	}

	public void setService(KoulutusHakuService service) {
		this.hakuservice = service;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listaaKoulutukset(Model model) {
		List<Koulutustilaisuus> koulutukset = hakuservice.haeKaikki();
		model.addAttribute("koulutukset", koulutukset);
		return "listausuusi";
	}
	@RequestMapping(value="hakutulokset", method=RequestMethod.GET)
	public String naytaHakutulokset(Model model, HttpServletRequest httpRequest) {
		String ehto = httpRequest.getParameter("haku");
		List<Koulutustilaisuus> koulutukset = hakuservice.haeValitut(ehto);
		model.addAttribute("koulutukset", koulutukset);
		System.out.println(ehto);
		return "listausuusi";
	}
	@RequestMapping(value="avainsana", method=RequestMethod.GET)
	public String naytaAvainsana(Model model, HttpServletRequest httpRequest) {
		String ehto = httpRequest.getParameter("avainsana");
		List<Koulutustilaisuus> koulutukset = hakuservice.haeAvainsana(ehto);
		model.addAttribute("koulutukset", koulutukset);
		System.out.println(ehto);
		return "listausuusi";
	}
}
