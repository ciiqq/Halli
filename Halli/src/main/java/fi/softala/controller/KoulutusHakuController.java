package fi.softala.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.bean.Koulutustilaisuus;
import fi.softala.service.KoulutusHakuService;
import fi.softala.bean.Osallistuja;
import fi.softala.service.OsallistujaService;

/**
 * 
 * @author Timo Kottonen
 * @author ...
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
	
	@Inject
	private OsallistujaService osallistujaservice;

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
	
	@RequestMapping(value="ilmoittaudu", method=RequestMethod.GET)
	public String talletaOsallistuja(Model model, HttpServletRequest request){
		String osallistumiset = request.getParameter("valitutkoulutukset");
		String enimi = request.getParameter("etunimi");
		String snimi = request.getParameter("sukunimi");
		String onro = request.getParameter("opiskelijanro");
		Osallistuja osallistuja = new Osallistuja(onro, enimi, snimi);
		System.out.println(osallistuja.getEtunimi() + " " + osallistumiset);
		//model.addAttribute("osallistuja", osallistuja);
		//model.addAttribute("osallistumiset", osallistumiset);
		osallistujaservice.tallenna(osallistuja, osallistumiset);
		return "listausuusi";
	}

}
