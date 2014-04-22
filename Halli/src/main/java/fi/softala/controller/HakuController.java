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
 * @author Teemu Kälviäinen
 * @author ...
 *
 */

@Controller
@RequestMapping (value="/koulutukset")
public class HakuController {
	
	@Inject
	private KoulutusHakuService hakuservice;
	
	public KoulutusHakuService getService() {
		return hakuservice;
	}

	public void setService(KoulutusHakuService service) {
		this.hakuservice = service;
	}
	
	@RequestMapping(value="hakutulokset", method=RequestMethod.GET)
	public String naytaHakutulokset(Model model, HttpServletRequest httpRequest) {
		String ehto = httpRequest.getParameter("haku");
		List<Koulutustilaisuus> koulutukset = hakuservice.haeValitut(ehto);
		model.addAttribute("koulutukset", koulutukset);
		System.out.println(ehto);
		return "hakutulokset";
	}
}
