package fi.softala.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fi.softala.DAO.KouluttajienLisaysDAO;
import fi.softala.bean.ExcelParseri;
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
	public String kouluttajienLisaysSivu(Model model, Model model2) {
		Kouluttaja kouluttaja = new Kouluttaja();
		model.addAttribute("kouluttaja", kouluttaja);
		model2.addAttribute("excel", "");
		
		return "kouluttajien_lisays/lisays";
	}
	
	@RequestMapping(value="kouluttajien_lisays", method=RequestMethod.POST)
	public String lisaaKouluttaja(@ModelAttribute(value="kouluttaja") Kouluttaja kouluttaja) {
		
		if(dao.kouluttajanHaku(Integer.parseInt(kouluttaja.getOpiskelijanro())) == null ){
			dao.kouluttajanLisays(kouluttaja);
			System.out.println("Kouluttaja lis�tty!");
			System.out.println(kouluttaja);
		}
		
		else{
			System.out.println("Kouluttaja t�ll� opiskelijanumerolla on jo kannassa.");
		}
		

		return "kouluttajien_lisays/lisays";
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
			if(dao.kouluttajanHaku(Integer.parseInt(kouluttajat.get(i).getOpiskelijanro())) == null ){
				lisataan.add(kouluttajat.get(i));
			}else{
				eiLisata.add(kouluttajat.get(i));
			}
		}
		
		//Lis�t��n "lisataan" listan kouluttajat kantaan
		for (int i = 0; i < lisataan.size(); i++){
			dao.kouluttajanLisays(lisataan.get(i));
		}
		
		//Testi� varten kolme seuraavaa rivi�
		System.out.println("\n\n*****Nyt se loppu*****\n\n");
		Kouluttaja kouluttaja = new Kouluttaja();
		model.addAttribute("kouluttaja", kouluttaja);	
		
		
		return "kouluttajien_lisays/lisays";
	}
}

