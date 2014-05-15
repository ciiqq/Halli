package fi.softala.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.bean.Kouluttaja;
import fi.softala.bean.Koulutustilaisuus;
import fi.softala.service.AikatauluslottiService;
import fi.softala.service.KouluttajaService;
import fi.softala.service.KoulutustilaisuusService;


@Controller
@RequestMapping (value="/")
public class Controller1 {

	@Inject
	private KoulutustilaisuusService koulutustilaisuusService;
	@Inject
	private KouluttajaService kouluttajaService;
	@Inject
	private AikatauluslottiService aikatauluslottiService;

	public void setKoulutustilaisuusService(
			KoulutustilaisuusService koulutustilaisuusService) {
		this.koulutustilaisuusService = koulutustilaisuusService;
	}

	public void setKouluttajaService(KouluttajaService kouluttajaService) {
		this.kouluttajaService = kouluttajaService;
	}
	
	public void setAikatauluslottiService(AikatauluslottiService aikatauluslottiService) {
		this.aikatauluslottiService = aikatauluslottiService;
	}

	
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
	public String getCreateForm9(Model model) {
		Koulutustilaisuus kt = new Koulutustilaisuus();
		//List<Kouluttaja> kouluttajat = new LinkedList<Kouluttaja>();
		//kouluttajat.add(new Kouluttaja("1000001", "Kimmo", "Kouluttaja", "salasana", "suola"));
		//kt.setKouluttajat(kouluttajat);
		model.addAttribute("koulutustilaisuus", kt);
		model.addAttribute("kouluttajat", kouluttajaService.haeKouluttajat());
		model.addAttribute("vapaatajat", aikatauluslottiService.haeVapaatAjat());
		return "kouluttaja-uusikoulutus";
	}
	
	@RequestMapping (value="kouluttaja/koulutus", method=RequestMethod.POST)
	public String saveCreateForm9( @ModelAttribute(value="koulutustilaisuus") Koulutustilaisuus koulutustilaisuus, Model model) {
		koulutustilaisuusService.tallennaUusiKoulutustilaisuus(koulutustilaisuus);
		return "redirect:/";
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
