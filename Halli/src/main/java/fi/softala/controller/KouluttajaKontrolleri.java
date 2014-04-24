package fi.softala.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fi.softala.DAO.KouluttajienLisaysDAO;
import fi.softala.bean.Kouluttaja;
import fi.softala.funktiot.ExcelParseri;


@Controller
@RequestMapping (value="/kouluttajien_lisays")
public class KouluttajaKontrolleri {
	
	@Inject
	private KouluttajienLisaysDAO dao;
	
	public KouluttajienLisaysDAO getDao() {
		return dao;
	}

	public void setDao(KouluttajienLisaysDAO dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping(value="lisays", method=RequestMethod.GET)
	public String kouluttajienLisaysSivu(Model model) {
		//Tyhjä kouluttaja oletuksena
		Kouluttaja kouluttaja = new Kouluttaja();
		model.addAttribute("kouluttaja", kouluttaja);
		
		return "kouluttajien_lisays/lisays";
	}
	
	@RequestMapping(value="lisaaKouluttaja", method=RequestMethod.POST)
	public String lisaaKouluttaja(@ModelAttribute(value="kouluttaja") @Valid Kouluttaja kouluttaja, BindingResult result, Model model){
		
		//Validointi tarkistus
		if(result.hasErrors()){
			return "kouluttajien_lisays/lisays";
		}
		else{
			//Lista tietokantaa varten
			List<Kouluttaja> k = new LinkedList<Kouluttaja>();
			k.add(kouluttaja);
			
			//Jos opiskelijanumerolla ei löydy opiskelijaa, lisätään se kantaan
			if(dao.kouluttajanHaku(kouluttaja.getOpiskelijanro()) == null ){
				dao.kouluttajanLisays(kouluttaja);
				System.out.println("Kouluttaja lisätty!");
				System.out.println(kouluttaja);
				
				model.addAttribute("lisatyt", k);
				k = null;
				model.addAttribute("eiLisatyt", k);
			}
			//Jos opiskelija löytyy, ei sitä lisätä kantaan
			else{
				System.out.println("Kouluttaja tällä opiskelijanumerolla on jo kannassa.");
				
				model.addAttribute("eiLisatyt", k);
				k = null;
				model.addAttribute("lisatyt", k);
				
			}
			

			return "kouluttajien_lisays/lisatty";
		}
		
	}
	
	@RequestMapping(value="lisaaLista", method=RequestMethod.POST)
	public String lisaaKouluttajat(@RequestParam("kouluttajaLista") MultipartFile file, Model model){
		
		//Lista, johon haetaan excelistä kouluttajat
		List<Kouluttaja> kouluttajat = ExcelParseri.parseta(file);
		
		
		//Kouluttajat, jotka eivät ole jo systeemissä, menevät "lisataan" listaan
		//Kouluttajat, jotka ovat jo systeemissä, menevät "eiLisata" listaan
		List<Kouluttaja> lisataan = new ArrayList<Kouluttaja>();
		List<Kouluttaja> eiLisata = new ArrayList<Kouluttaja>();
		
		//Tarkistetaan systeemistä listan opiskelijat
		for (int i = 0; i < kouluttajat.size(); i++){
			if(dao.kouluttajanHaku(kouluttajat.get(i).getOpiskelijanro()) == null ){
				lisataan.add(kouluttajat.get(i));
			}else{
				eiLisata.add(kouluttajat.get(i));
			}
		}
		
		//Lisätään "lisataan" listan kouluttajat kantaan
		for (int i = 0; i < lisataan.size(); i++){
			dao.kouluttajanLisays(lisataan.get(i));
		}
		
		//Annetaan modelille listat lisätyistä ja ei lisätyistä kouluttajista
		model.addAttribute("lisatyt", lisataan);
		model.addAttribute("eiLisatyt", eiLisata);
		
		
		return "kouluttajien_lisays/lisatty";
	}
	
}

