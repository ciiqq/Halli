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
import fi.softala.service.OsallistujaService;
import fi.softala.service.PalauteService;

/**
 * 
 * @author Timo Kottonen
 * @author Teemu Kälviäinen
 * @author Henna Kiiveri
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
	
	public PalauteService getPalauteService() {
		return palauteservice;
	}

	public void setPalauteService(PalauteService palauteservice) {
		this.palauteservice = palauteservice;
	}
	
	@RequestMapping(value="palaute", method=RequestMethod.POST)
	public String create(@ModelAttribute(value="palaute") Palaute palaute, Model model, ServletRequest request, RedirectAttributes redirectAttrs) {
				try {
					int koulutus_id = Integer.parseInt(request.getParameter("koulutus_id"));
					palauteservice.tallenna(palaute, koulutus_id);
					redirectAttrs.addFlashAttribute("viesti", "Palautteen lähetys onnistui. Kiitos palautteesta!");
					redirectAttrs.addAttribute("opiskelijanumero", palaute.getOpiskelijanro());
					return "redirect:palaute?opiskelijanumero={opiskelijanumero}";				
				} catch (Exception e) {
					redirectAttrs.addFlashAttribute("virheviesti", "Palautteen lähetys ei onnistunut.");
					return "redirect:palaute";
				}	
	}
	@RequestMapping(value="palaute", method=RequestMethod.GET)
	public String getCreateForm2(Model model, ServletRequest request) {
		String opiskelijanro = request.getParameter("opiskelijanumero");
		Palaute palaute = new Palaute(opiskelijanro);
		List<Koulutustilaisuus> koulutukset = hakuservice.haePalauteKelpoiset(palaute.getOpiskelijanro());
		model.addAttribute("koulutukset", koulutukset);		
		model.addAttribute("palaute", palaute);
		return "palaute";
	}
	@RequestMapping(value="anna_palautetta", method=RequestMethod.POST)
	public String getCreateForm(Model model, ServletRequest request, RedirectAttributes redirectAttrs) {
		String opiskelijanro = request.getParameter("opiskelijanumero");
		redirectAttrs.addAttribute("opiskelijanumero", opiskelijanro);
		return "redirect:palaute";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listaaTulevatKoulutukset(Model model) {
		List<Koulutustilaisuus> koulutukset = hakuservice.haeTulevat();
		model.addAttribute("koulutukset", koulutukset);
		model.addAttribute("tulevatValittu", "x");
		return "listausuusi";
	}
	
	@RequestMapping(value = "menneet", method = RequestMethod.GET)
	public String listaaMenneetKoulutukset(Model model) {
		List<Koulutustilaisuus> koulutukset = hakuservice.haeMenneet();
		model.addAttribute("koulutukset", koulutukset);
		model.addAttribute("menneetValittu", "x");
		return "listausuusi";
	}
	
	@RequestMapping(value="hakutulokset", method=RequestMethod.GET)
	public String listaaKoulutuksetHakusanalla(Model model, ServletRequest request) throws UnsupportedEncodingException {
		//Tomcat aiheuttaa vaikeuksia ääkkösten kanssa, pakotetaan UTF-8 :ksi
		String ehto = new String(request.getParameter("haku").getBytes("iso-8859-1"), "UTF-8");
		List<Koulutustilaisuus> koulutukset = hakuservice.haeHakusanalla(ehto);
		model.addAttribute("koulutukset", koulutukset);
		model.addAttribute("hakusana", ehto);
		return "listausuusi";
	}
	
	@RequestMapping(value="avainsana", method=RequestMethod.GET)
	public String listaaKoulutuksetAvainsanalla(Model model, ServletRequest request) throws UnsupportedEncodingException {
		//Tomcat aiheuttaa vaikeuksia ääkkösten kanssa, pakotetaan UTF-8 :ksi
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
		//.trim() poistaa whitespacet (välilyönti, tabulaattori, rivinvaihto) Stringin
		//alusta ja lopusta
		Osallistuja osallistuja = new Osallistuja(onro.trim(), enimi.trim(), snimi.trim());
		osallistujaservice.tallenna(osallistuja, osallistumiset);
		//tieto onnistumisesta palautetaan redirectin flash-attribuuttina: tämä käsitellään 
		//c:iffillä jsp-tiedostossa
		redirectAttrs.addFlashAttribute("viesti", "EI OLE NULL");
		return "redirect:/";
	}
}
