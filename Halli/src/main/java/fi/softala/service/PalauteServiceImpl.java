package fi.softala.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import fi.softala.bean.Palaute;
import fi.softala.dao.OsallistujaDAO;
import fi.softala.dao.PalauteDAO;

@Service
public class PalauteServiceImpl implements PalauteService {
	
	@Inject
	private PalauteDAO palautedao;
	
	@Inject
	private OsallistujaDAO osallistujadao;
	
	public PalauteDAO getDao() {
		return palautedao;
	}

	public void setOsallistujaDao(PalauteDAO palautedao) {
		this.palautedao = palautedao;
	}
	public OsallistujaDAO getOsallistujaDao() {
		return osallistujadao;
	}

	public void setDao(OsallistujaDAO osallistujadao) {
		this.osallistujadao = osallistujadao;
	}
	
	/* (non-Javadoc)
	 * @see fi.softala.service.PalauteService#tallenna(fi.softala.bean.Palaute)
	 */
	public void tallenna(Palaute palaute, int koulutus_id) {
		palautedao.talletaPalaute(palaute, koulutus_id);
	}
	
	public List<Palaute> haePalautteet() {
		return palautedao.haeKaikki();
	}
	
	public List<Palaute> haePalautteet(String opiskelijanro) {
		return palautedao.haePalautteet(opiskelijanro);
	}
	
	public List<Palaute> haeIdlla(int id) {
		return palautedao.haeIdlla(id);
	}
	
	public static void printList(List<Palaute> palautteet) {
		System.out.println(">>>>>>>>> debug palautteet (SERVICE)");
		for (Palaute palaute : palautteet) {
			System.out.println(palaute.toString());
		}
		System.out.println(">>>>>>>>");
	}

}
