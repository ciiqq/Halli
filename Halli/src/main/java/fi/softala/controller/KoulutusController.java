package fi.softala.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class KoulutusController {
	
	@Inject
	private KoulutuslistausDAO dao;
	
	public KoulutuslistausDAO getDao() {
		return dao;
	}

	public void setDao(KoulutuslistausDAO dao) {
		this.dao = dao;
	}

	
	
	
		
		@RequestMapping(value="/koulutuslistaus", method=RequestMethod.GET)
		public String getCreateForm(Model model) {
			ListKoulutuslista> koulutuslista = dao.haeKoulutukset();
			
			model.addAttribute("koulutukset", koulutuslista);
			
			return "naytakoulutukset";
		}

		
	}

