package fi.softala.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.service.KoulutuksenVahvistusService;
import fi.softala.service.KoulutusHakuService;

/**
 * 
 * @author Miro Metsänheimo
 * @author ...
 *
 */

@Controller
@RequestMapping(value = "/vahvistaKoulutukset")
public class KoulutusVahvistusController {

	@Inject
	private KoulutuksenVahvistusService vahvistusservice;
	
	public KoulutuksenVahvistusService getService() {
		return vahvistusservice;
	}

	public void setService(KoulutuksenVahvistusService service) {
		this.vahvistusservice = service;
	}
	
	@RequestMapping(value = "VahvistaKoulutus", method = RequestMethod.GET)
	public void VahvistaKoulutus(HttpServletRequest req) {
		vahvistusservice.VahvistaKoulutus(0);
	}
	
	@RequestMapping(value = "VahvistaKaikkiKoulutukset")
	public void VahvistaKaikkiKoulutukset() {
		vahvistusservice.VahvistaKaikkiKoulutukset();
	}
	
}
