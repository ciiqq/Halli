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
import fi.softala.funktiot.SalasanaGeneraattori;


@Controller
@RequestMapping (value="/opettaja/kouluttajat")
public class KouluttajaKontrolleri {
	
	private final String polku = "kouluttajien_lisays/lista";
	
	@Inject
	private KouluttajienLisaysDAO dao;
	
	public KouluttajienLisaysDAO getDao() {
		return dao;
	}

	public void setDao(KouluttajienLisaysDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String kouluttajaLista(Model model) {
		//Tyhj� kouluttaja oletuksena
		Kouluttaja kouluttaja = new Kouluttaja();
		model.addAttribute("kouluttaja", kouluttaja);
		
		List<Kouluttaja> kouluttajat = dao.kouluttajienHaku();
		
		model.addAttribute("kouluttajat", kouluttajat);
		
		return polku;
	}
	
	@RequestMapping(value="lisays", method=RequestMethod.GET)
	public String kouluttajienLisaysSivu(Model model) {
		//Tyhj� kouluttaja oletuksena
		Kouluttaja kouluttaja = new Kouluttaja();
		model.addAttribute("kouluttaja", kouluttaja);
		
		return polku;
	}
	
	@RequestMapping(value="lisaaKouluttaja", method=RequestMethod.POST)
	public String lisaaKouluttaja(@ModelAttribute(value="kouluttaja") @Valid Kouluttaja kouluttaja, BindingResult result, Model model){
		
		//Validointi tarkistus
		if(result.hasErrors()){
			List<Kouluttaja> kouluttajat = dao.kouluttajienHaku();
			
			model.addAttribute("kouluttajat", kouluttajat);
			return polku;
		}
		else{
			//Lista tietokantaa varten
			List<Kouluttaja> k = new LinkedList<Kouluttaja>();
			k.add(kouluttaja);
			
			//Jos opiskelijanumerolla ei l�ydy opiskelijaa, lis�t��n se kantaan
			if(dao.kouluttajanHaku(kouluttaja.getOpiskelijanro()) == null ){
				kouluttaja.setSalasana(SalasanaGeneraattori.generoiSalasana());
				dao.kouluttajanLisays(kouluttaja);
				System.out.println("Kouluttaja lis�tty!");
				System.out.println(kouluttaja);
				
				model.addAttribute("lisatyt", k);
				k = null;
				model.addAttribute("eiLisatyt", k);
			}
			//Jos opiskelija l�ytyy, ei sit� lis�t� kantaan
			else{
				System.out.println("Kouluttaja t�ll� opiskelijanumerolla on jo kannassa.");
				
				model.addAttribute("eiLisatyt", k);
				k = null;
				model.addAttribute("lisatyt", k);
				
			}
			kouluttaja = new Kouluttaja();
			model.addAttribute("kouluttaja", kouluttaja);
			
			List<Kouluttaja> kouluttajat = dao.kouluttajienHaku();
			model.addAttribute("kouluttajat", kouluttajat);
			

			return polku;
		}
		
	}
	
	@RequestMapping(value="lisaaLista", method=RequestMethod.POST)
	public String lisaaKouluttajat(@RequestParam("kouluttajaLista") MultipartFile file, Model model){
		
		//Lista, johon haetaan excelist� kouluttajat
		List<Kouluttaja> kouluttajat = ExcelParseri.parseta(file);
		
		
		//Kouluttajat, jotka eiv�t ole jo systeemiss�, menev�t "lisataan" listaan
		//Kouluttajat, jotka ovat jo systeemiss�, menev�t "eiLisata" listaan
		List<Kouluttaja> lisataan = new ArrayList<Kouluttaja>();
		List<Kouluttaja> eiLisata = new ArrayList<Kouluttaja>();
		
		//Tarkistetaan systeemist� listan opiskelijat
		for (int i = 0; i < kouluttajat.size(); i++){
			if(dao.kouluttajanHaku(kouluttajat.get(i).getOpiskelijanro()) == null ){
				lisataan.add(kouluttajat.get(i));
				lisataan.get(lisataan.size()-1).setSalasana(SalasanaGeneraattori.generoiSalasana());
			}else{
				eiLisata.add(kouluttajat.get(i));
			}
		}
		
		//Lis�t��n "lisataan" listan kouluttajat kantaan
		for (int i = 0; i < lisataan.size(); i++){
			dao.kouluttajanLisays(lisataan.get(i));
		}
		
		//Annetaan modelille listat lis�tyist� ja ei lis�tyist� kouluttajista
		model.addAttribute("lisatyt", lisataan);
		model.addAttribute("eiLisatyt", eiLisata);
		Kouluttaja kouluttaja = new Kouluttaja();
		model.addAttribute("kouluttaja", kouluttaja);
		
		kouluttajat = dao.kouluttajienHaku();
		model.addAttribute("kouluttajat", kouluttajat);
		
		
		return polku;
	}
	
}

