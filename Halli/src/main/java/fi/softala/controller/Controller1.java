package fi.softala.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fi.softala.bean.Avainsana;
import fi.softala.bean.Kouluttaja;
import fi.softala.bean.Koulutustilaisuus;
import fi.softala.dao.KoulutusDAO;


@Controller
@RequestMapping (value="/")
public class Controller1 {
	
	@Inject
	private KoulutusDAO dao;
	
	public KoulutusDAO getDao() {
		return dao;
	}

	public void setDao(KoulutusDAO dao) {
		this.dao = dao;
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
	public String haeJulkaisemattomat(Model model) {
		List<Koulutustilaisuus> koulutuslista = dao.haeKoulutukset(false);
		
		model.addAttribute("koulutukset", koulutuslista);
		
		return "julkaisemattomatkoulutukset";
	}
	
	
	@RequestMapping(value="opettaja/koulutukset/julkaisemattomat/koulutustiedot/{DaoId}", method=RequestMethod.GET)
	public String siirryKoulutukseen(Model model, @PathVariable Integer DaoId) {
		
		//Hakee koulutuksen tiedot
       Koulutustilaisuus koulutus = dao.haeKoulutus(DaoId);
       
       //Hakee kaikki koulutuksen kouluttajat ja laittaa sen koulutus-olioon
       List<Kouluttaja> kouluttajat = dao.haeKouluttajat(DaoId);
       koulutus.setKouluttajat(kouluttajat);
       
       //Hakee kaikki koulutuksen avainsanat ja laittaa sen koulutus-olioon
       List<Avainsana> avainsanat = dao.haeAvainsanat(DaoId);
       koulutus.setAvainsanat(avainsanat);
        
       //Laitetaan Modeliin koulustusolio, jotta voidaan sivulla 
       model.addAttribute("ks", koulutus);
       

        //Luodaan olio Springin formia varten ,jossa voidaan muokata koulutusta
//        dao.haeVapaatSlotit();

        Koulutustilaisuus koulutusTemplate = new Koulutustilaisuus();
        koulutusTemplate.setKuvaus(koulutus.getKuvaus());
        model.addAttribute("muokattavaKoulutus", koulutusTemplate);
        
        return "koulutustiedot";
    }
	
	@RequestMapping(value="opettaja/koulutukset/julkaisemattomat/koulutustiedot/{DaoId}", method=RequestMethod.POST)
	public String muokkaaKoulutusta(Model model, @PathVariable Integer DaoId, @Valid @ModelAttribute("muokattavaKoulutus") Koulutustilaisuus koulutus,
			BindingResult bindingResult, final RedirectAttributes reAts){
		
		if(bindingResult.hasErrors()) {
			Koulutustilaisuus virheellinenKoulutus = dao.haeKoulutus(DaoId);
	        
			
	        model.addAttribute("ks", virheellinenKoulutus);
	        model.addAttribute("avaaModal", "avaaModal");
			
			return "koulutustiedot";
		}
		
		koulutus.setId(DaoId);
		
		dao.paivitaKoulutus(koulutus);
		
		reAts.addFlashAttribute("muokkausOnnistui", "Koulutuksen muokkaus onnistui!");
		
		return "redirect:/opettaja/koulutukset/julkaisemattomat/koulutustiedot/" + DaoId;
	}
	
	@RequestMapping(value="opettaja/koulutukset/julkaisemattomat/muokkaa", method=RequestMethod.GET)
	public String getCreateFormXXX() {
		return "muokkaakoulutusta";
	}
	

	@RequestMapping(value = "/opettaja/koulutukset/julkaisemattomat/koulutustiedot/peruutus/{DaoId}", method = RequestMethod.GET)
	public String peruutaKoulutus(Model model, @PathVariable Integer DaoId, final RedirectAttributes ra){
		
		dao.peruutaKoulutus(DaoId);
		
		ra.addFlashAttribute("peruutusvahvistus", "Koulutus on peruutettu onnistuneesti!");
		
		return "redirect:/opettaja/koulutukset/julkaisemattomat";
	}
	
	@RequestMapping(value = "/opettaja/koulutukset/julkaisemattomat/koulutustiedot/julkaisu/{DaoId}", method = RequestMethod.GET)
	public String julkaiseKoulutus(Model model, @PathVariable Integer DaoId, final RedirectAttributes ra){
		
		dao.julkaiseKoulutus(DaoId);
		
		ra.addFlashAttribute("julkaisuvahvistus", "Koulutus on julkaistu ja siihen voi ilmoittautua!");
		
		return "redirect:/opettaja/koulutukset/julkaistut";
	}
	
	@RequestMapping(value="opettaja/koulutukset/julkaisemattomat/uusikoulutus", method=RequestMethod.GET)
	public String getCreateForm5() {
		return "uusikoulutus";
	}

	@RequestMapping(value="opettaja/koulutukset/julkaistut", method=RequestMethod.GET)
	public String haeJulkaistut(Model model) {
		List<Koulutustilaisuus> koulutuslista = dao.haeKoulutukset(true);
		
		model.addAttribute("koulutukset", koulutuslista);
		
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
