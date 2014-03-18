package fi.softala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping (value="/koulutus")
public class KoulutusController {
	
	@RequestMapping (value="/uusi", method=RequestMethod.GET)
	public String getCreateForm() {
		return "koulutuslomake";
}
}
