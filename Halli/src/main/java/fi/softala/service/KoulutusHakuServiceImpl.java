package fi.softala.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import fi.softala.bean.Koulutustilaisuus;
import fi.softala.dao.KoulutusHakuDAO;

/**
 * 
 * @author Timo Kottonen
 * @author ...
 *
 */

@Service
public class KoulutusHakuServiceImpl implements KoulutusHakuService {
	
	@Inject
	private KoulutusHakuDAO dao;
	

	public KoulutusHakuDAO getDao() {
		return dao;
	}

	public void setDao(KoulutusHakuDAO dao) {
		this.dao = dao;
	}

	public List<Koulutustilaisuus> haeMenneet() {
		List<Koulutustilaisuus> koulutukset = dao.haeMenneet();
		return koulutukset;
	}
	public List<Koulutustilaisuus> haePalauteKelpoiset(String opiskelijanumero) {
		List<Koulutustilaisuus> koulutukset = dao.haePalauteKelpoiset(opiskelijanumero);
		return koulutukset;
	}
	
	public List<Koulutustilaisuus> haeTulevat() {
		List<Koulutustilaisuus> koulutukset = dao.haeTulevat();
		return koulutukset;
	}
	
	public List<Koulutustilaisuus> haeHakusanalla(String ehto) {
		List<Koulutustilaisuus> koulutukset = dao.haeHakusanalla(ehto);
		return koulutukset;
	}
	
	public List<Koulutustilaisuus> haeAvainsanalla(String ehto) {
		List<Koulutustilaisuus> koulutukset = dao.haeAvainsanalla(ehto);
		return koulutukset;
	}
}
