package fi.softala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;






import java.util.LinkedList;
import java.util.List;

import fi.softala.bean.Kouluttaja;
import fi.softala.bean.Koulutustilaisuus;
import fi.softala.service.KouluttajaService;
import fi.softala.service.KoulutustilaisuusService;

@Controller
@RequestMapping (value="/")
public class KoulutusController {
	
	@Inject
	private KoulutustilaisuusService koulutustilaisuusService;
	@Inject
	private KouluttajaService kouluttajaService;

	public void setKoulutustilaisuusService(
			KoulutustilaisuusService koulutustilaisuusService) {
		this.koulutustilaisuusService = koulutustilaisuusService;
	}

	public void setKouluttajaService(KouluttajaService kouluttajaService) {
		this.kouluttajaService = kouluttajaService;
	}



	@RequestMapping (value="koulutus/uusi", method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		Koulutustilaisuus kt = new Koulutustilaisuus();
		List<Kouluttaja> kouluttajat = new LinkedList<Kouluttaja>();
		kouluttajat.add(new Kouluttaja("1000001", "Kimmo", "Kouluttaja", "salasana", "suola"));
		kt.setKouluttajat(kouluttajat);
		model.addAttribute("koulutustilaisuus", kt);
		model.addAttribute("kouluttajat", kouluttajaService.haeKouluttajat());
		return "koulutuslomake";
	}

	@RequestMapping (value="koulutus/uusi", method=RequestMethod.POST)
	public String saveCreateForm( @ModelAttribute(value="koulutustilaisuus") Koulutustilaisuus koulutustilaisuus, Model model) {
		koulutustilaisuusService.tallennaUusiKoulutustilaisuus(koulutustilaisuus);
		return "redirect:/";
	}
}
