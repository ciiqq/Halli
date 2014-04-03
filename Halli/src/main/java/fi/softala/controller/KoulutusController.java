package fi.softala.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.bean.Aikatauluslotti;
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
		public String getCreateForm(Model model) {
			List<Aikatauluslotti> koulutuslista = dao.haeKoulutukset();
			
			model.addAttribute("koulutukset", koulutuslista);
			
			return "naytakoulutukset";
		}
		
		
		@RequestMapping(value="{id}", method=RequestMethod.GET)
		public String naytaKoulutus(Model model, @PathVariable Integer id){
			
			return "placeholder";
		}
		
		

		
	}

