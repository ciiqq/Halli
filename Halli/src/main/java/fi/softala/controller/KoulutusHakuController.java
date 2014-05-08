package fi.softala.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fi.softala.bean.Koulutustilaisuus;
import fi.softala.bean.Osallistuja;
import fi.softala.bean.Palaute;
import fi.softala.service.KoulutusHakuService;
import fi.softala.service.OpiskelijanumeronMuutosService;
import fi.softala.service.OsallistujaService;
import fi.softala.service.PalauteService;

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
	
	@Inject
	private OsallistujaService osallistujaservice;
	
	@Inject
	private PalauteService palauteservice;
	
	@Inject
	private OpiskelijanumeronMuutosService muutosservice;

	public PalauteService getPalauteService() {
		return palauteservice;
	}

	public void setPalauteService(PalauteService palauteservice) {
		this.palauteservice = palauteservice;
	}
	public OpiskelijanumeronMuutosService getMuutosService() {
		return muutosservice;
	}
	public void setMuutos(OpiskelijanumeronMuutosService muutosservice) {
		this.muutosservice = muutosservice;
	}
	
	@RequestMapping(value="palaute", method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		Palaute tyhjaPalaute = new Palaute();
		model.addAttribute("palaute", tyhjaPalaute);
		return "palaute";
	}
	
	@RequestMapping(value="palaute", method=RequestMethod.POST)
	public String create(@ModelAttribute(value="palaute") Palaute palaute, Model model) {	
				String opiskelijanumero = palaute.getOpiskelijanumero();
				//Koulutus_id jostain listasta?
				String koulutus_id = "";
				opiskelijanumero = muutosservice.OpiskelijanumeronMuotoilu(opiskelijanumero);
				if (palauteservice.tarkistaOpiskelijanumero(opiskelijanumero) == false && palauteservice.tarkistaOsallistuja(opiskelijanumero, koulutus_id) == true) {
					palauteservice.tallenna(palaute);
					model.addAttribute("onnistunutviesti", "Palautteen lähetys onnistui");	
					return "palaute";
				}
				else {
					model.addAttribute("virheviesti", "Palautteen lähetys ei onnistunut");
					return "palaute";
				}
		
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listaaTulevatKoulutukset(Model model) {
		List<Koulutustilaisuus> koulutukset = hakuservice.haeTulevat();
		model.addAttribute("koulutukset", koulutukset);
		return "listausuusi";
	}
	
	@RequestMapping(value = "menneet", method = RequestMethod.GET)
	public String listaaMenneetKoulutukset(Model model) {
		List<Koulutustilaisuus> koulutukset = hakuservice.haeMenneet();
		model.addAttribute("koulutukset", koulutukset);
		return "listausuusi";
	}
	
	@RequestMapping(value="hakutulokset", method=RequestMethod.GET)
	public String listaaKoulutuksetHakusanalla(Model model, ServletRequest request) throws UnsupportedEncodingException {
		String ehto = new String(request.getParameter("haku").getBytes("iso-8859-1"), "UTF-8");
		List<Koulutustilaisuus> koulutukset = hakuservice.haeHakusanalla(ehto);
		model.addAttribute("koulutukset", koulutukset);
		model.addAttribute("hakusana", ehto);
		return "listausuusi";
	}
	
	@RequestMapping(value="avainsana", method=RequestMethod.GET)
	public String listaaKoulutuksetAvainsanalla(Model model, ServletRequest request) throws UnsupportedEncodingException {
		String ehto = new String(request.getParameter("avainsana").getBytes("iso-8859-1"), "UTF-8");
		List<Koulutustilaisuus> koulutukset = hakuservice.haeAvainsanalla(ehto);
		model.addAttribute("koulutukset", koulutukset);
		model.addAttribute("hakusana", ehto);
		return "listausuusi";
	}

	@RequestMapping(value="ilmoittaudu", method=RequestMethod.POST)
	public String talletaOsallistuja(Model model, ServletRequest request
			, final RedirectAttributes redirectAttrs){
		String osallistumiset = request.getParameter("valitutkoulutukset");
		String enimi = request.getParameter("etunimi");
		String snimi = request.getParameter("sukunimi");
		String onro = request.getParameter("opiskelijanro");
		Osallistuja osallistuja = new Osallistuja(onro.trim(), enimi.trim(), snimi.trim());
		osallistujaservice.tallenna(osallistuja, osallistumiset);
		redirectAttrs.addFlashAttribute("viesti", "PARAS KOODI EI OLE NULL");
		return "redirect:/";
	}
}
