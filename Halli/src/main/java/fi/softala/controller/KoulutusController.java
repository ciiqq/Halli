package fi.softala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;




import java.util.List;
import java.util.ArrayList;

import fi.softala.bean.Kouluttaja;
import fi.softala.bean.Koulutustilaisuus;
import fi.softala.service.KoulutustilaisuusService;
import fi.softala.service.KoulutustilaisuusServiceImpl;

@Controller
@RequestMapping (value="/koulutus")
public class KoulutusController {
	
	@Inject
	private KoulutustilaisuusService koulutustilaisuusService;

	public void setKoulutustilaisuusService(
			KoulutustilaisuusService koulutustilaisuusService) {
		this.koulutustilaisuusService = koulutustilaisuusService;
	}

	public KoulutustilaisuusService getKoulutustilaisuusService() {
		return koulutustilaisuusService;
	}



	@RequestMapping (value="/uusi", method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		Koulutustilaisuus kt = new Koulutustilaisuus();
		List<Kouluttaja> kouluttajat = new ArrayList<Kouluttaja>();
		kouluttajat.add(new Kouluttaja("", "Kimmo \'Default\'", "Kouluttaja", "", ""));
		kt.setKouluttajat(kouluttajat);
		model.addAttribute("koulutustilaisuus", kt);
		return "koulutuslomake";
	}

	@RequestMapping (value="/uusi", method=RequestMethod.POST)
	public String saveCreateForm( @ModelAttribute(value="koulutustilaisuus") Koulutustilaisuus koulutustilaisuus) {
		koulutustilaisuusService.tallennaKoulutustilaisuus(koulutustilaisuus);		
		return "koulutuslomake";
	}
}
