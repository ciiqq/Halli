package fi.softala.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.bean.Kouluttaja;
import fi.softala.bean.Koulutustilaisuus;


@Controller
@RequestMapping (value="/testaus")
public class Controller1 {
	
	@RequestMapping(value="uusi", method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		Koulutustilaisuus kt = new Koulutustilaisuus();
		List<Kouluttaja> kouluttajat = new ArrayList<Kouluttaja>();
		kouluttajat.add(new Kouluttaja("", "Kimmo \'Default\'", "Kouluttaja", "", ""));
		kt.setKouluttajat(kouluttajat);
		model.addAttribute("koulutustilaisuus", kt);
		return "koulutuslomake";
	}

	//Juhani iz da shit :D
	//HALOO T. JUHANI
	//TESTATAAN LIS�� T. JUHANI
 //test t kale
}

