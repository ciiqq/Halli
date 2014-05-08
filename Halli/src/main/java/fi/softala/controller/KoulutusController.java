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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fi.softala.bean.Avainsana;
import fi.softala.bean.Kouluttaja;
import fi.softala.bean.Koulutustilaisuus;
import fi.softala.dao.KoulutusDAO;

@Controller
public class KoulutusController {
	
	@Inject
	private KoulutusDAO dao;
	
	public KoulutusDAO getDao() {
		return dao;
	}

	public void setDao(KoulutusDAO dao) {
		this.dao = dao;
	}
		
		@RequestMapping(value="/koulutuslistaus", method=RequestMethod.GET)
		public String haeKoulutukset(Model model) {
			List<Koulutustilaisuus> koulutuslista = dao.haeKoulutukset(true);
			
			model.addAttribute("koulutukset", koulutuslista);
			
			return "julkaisemattomatkoulutukset";
		}
		
		
//		//Tämä metodi kuuntelee valuessa olevaa osoitetta koulutuslistat.jsp:ltä.	
//		@RequestMapping(value = "/koulutuslistaus/{DaoId}", method = RequestMethod.GET)
//	    public String siirryKoulutukseen(Model model, @PathVariable Integer DaoId) {
//			
//			//Hakee koulutuksen tiedot
//	       Koulutustilaisuus koulutus = dao.haeKoulutus(DaoId);
//	       
//	       //Hakee kaikki koulutuksen kouluttajat ja laittaa sen koulutus-olioon
//	       List<Kouluttaja> kouluttajat = dao.haeKouluttajat(DaoId);
//	       koulutus.setKouluttajat(kouluttajat);
//	       
//	       //Hakee kaikki koulutuksen avainsanat ja laittaa sen koulutus-olioon
//	       List<Avainsana> avainsanat = dao.haeAvainsanat(DaoId);
//	       koulutus.setAvainsanat(avainsanat);
//	        
//	       //Laitetaan Modeliin koulustusolio, jotta voidaan sivulla 
//	       model.addAttribute("ks", koulutus);
//	       
//
//	        //Luodaan olio Springin formia varten ,jossa voidaan muokata koulutusta
//	        dao.haeVapaatSlotit();
//
//	        Koulutustilaisuus koulutusTemplate = new Koulutustilaisuus();
//	        koulutusTemplate.setKuvaus(koulutus.getKuvaus());
//	        model.addAttribute("muokattavaKoulutus", koulutusTemplate);
//	        
//	        return "koulutustiedot";
//	    } 
		
		
//		
//		@RequestMapping(value = "/koulutuslistaus/{DaoId}", method = RequestMethod.POST)
//		public String muokkaaKoulutusta(Model model, @PathVariable Integer DaoId, @Valid @ModelAttribute("muokattavaKoulutus") Koulutustilaisuus koulutus,
//				BindingResult bindingResult, final RedirectAttributes reAts){
//			
//			if(bindingResult.hasErrors()) {
//				Koulutustilaisuus virheellinenKoulutus = dao.haeKoulutus(DaoId);
//		        
//				
//		        model.addAttribute("ks", virheellinenKoulutus);
//		        model.addAttribute("avaaModal", "avaaModal");
//				
//				return "koulutustiedot";
//			}
//			
//			koulutus.setId(DaoId);
//			
//			dao.paivitaKoulutus(koulutus);
//			
//			reAts.addFlashAttribute("muokkausOnnistui", "Koulutuksen muokkaus onnistui!");
//			
//			return "redirect:/koulutuslistaus/" + DaoId;
//		}
		

		@RequestMapping(value = "/opettaja/koulutukset/julkaisemattomat/koulutustiedot/peruutus/{DaoId}", method = RequestMethod.GET)
		public String peruutaKoulutus(Model model, @PathVariable Integer DaoId){
			
			dao.peruutaKoulutus(DaoId);
			
			haeKoulutukset(model);
			
			return "redirect:/opettaja/koulutukset/julkaisemattomat";
		}
		
		@RequestMapping(value = "/opettaja/koulutukset/julkaisemattomat/koulutustiedot/julkaise/{DaoId}", method = RequestMethod.GET)
		public String julkaiseKoulutus(Model model, @PathVariable Integer DaoId){
			
			dao.julkaiseKoulutus(DaoId);
			
			haeKoulutukset(model);
			
			return "redirect:/opettaja/koulutukset/julkaisemattomat";
		}
		
		@RequestMapping(value = "/koulutuslistaus/siirto/{DaoId}/{DaoId2}", method = RequestMethod.GET)
		public String siirraKoulutus(Model model, @PathVariable Integer DaoId, @PathVariable Integer DaoId2){
			
			dao.siirraKoulutus(DaoId, DaoId2);
			
			
			
			//siirryKoulutukseen(model, DaoId);
			
			return "redirect:/koulutuslistaus/{DaoId}";
		}
		


		
	}

