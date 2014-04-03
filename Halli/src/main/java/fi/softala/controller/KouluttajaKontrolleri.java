package fi.softala.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.DAO.KouluttajienLisaysDAO;
import fi.softala.bean.Kouluttaja;


@Controller
@RequestMapping (value="/mikatahansa")
public class KouluttajaKontrolleri {
	
	@Inject
	private KouluttajienLisaysDAO dao;
	
	public KouluttajienLisaysDAO getDao() {
		return dao;
	}

	public void setDao(KouluttajienLisaysDAO dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping(value="kouluttajien_lisays", method=RequestMethod.GET)
	public String kouluttajienLisaysSivu(Model model) {
		Kouluttaja kouluttaja = new Kouluttaja();
		model.addAttribute("kouluttaja", kouluttaja);
		
		return "kouluttajien_lisays/lisays";
	}
	
	@RequestMapping(value="kouluttajien_lisays", method=RequestMethod.POST)
	public String create( @ModelAttribute(value="kouluttaja") Kouluttaja kouluttaja) {
		
		if(dao.kouluttajanHaku(Integer.parseInt(kouluttaja.getOpiskelijanro())) == null ){
			dao.kouluttajanLisays(kouluttaja);
			System.out.println("Kouluttaja lisätty!");
			System.out.println(kouluttaja);
		}
		
		else{
			System.out.println("Kouluttaja tällä opiskelijanumerolla on jo kannassa.");
		}
		
		
		return "kouluttajien_lisays/lisays";
	}
}

