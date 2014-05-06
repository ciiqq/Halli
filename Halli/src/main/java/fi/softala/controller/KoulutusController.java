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

import fi.softala.bean.Aikatauluslotti;
import fi.softala.bean.Koulutustilaisuus;
import fi.softala.dao.KoulutusDAO;

/*
 * Testi
 */

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
		public String getCreateForm(Model model) {
			List<Koulutustilaisuus> koulutuslista = dao.haeKoulutukset();
			
			model.addAttribute("koulutukset", koulutuslista);
			
			return "koulutuslista";
		}
		
		
		//Tämä metodi kuuntelee valuessa olevaa osoitetta koulutuslistat.jsp:ltä.	
		@RequestMapping(value = "/koulutuslistaus/{DaoId}", method = RequestMethod.GET)
	    public String siirryKoulutukseen(Model model, @PathVariable Integer DaoId) {
	       Koulutustilaisuus koulutus = dao.haeKoulutus(DaoId);
	        
	        model.addAttribute("ks", koulutus);
	       
	        
	        Koulutustilaisuus koulutusTemplate = new Koulutustilaisuus();
	        koulutusTemplate.setKuvaus(koulutus.getKuvaus());
	        model.addAttribute("muokattavaKoulutus", koulutusTemplate);
	        
	        return "koulutustiedot";
	    } 
		
		
		
		@RequestMapping(value = "/koulutuslistaus/{DaoId}", method = RequestMethod.POST)
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
			
			return "redirect:/koulutuslistaus/" + DaoId;
		}
		

		@RequestMapping(value = "/koulutuslistaus/peruutus/{DaoId}", method = RequestMethod.POST)
		public String peruutaKoulutus( @PathVariable Integer DaoId){
			
			dao.peruutaKoulutus(DaoId);
			
			return "koulutuslista";
		}
		


		
	}

