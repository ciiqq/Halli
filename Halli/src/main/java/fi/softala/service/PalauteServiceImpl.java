package fi.softala.service;

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
	public void tallenna(Palaute palaute) {
		palautedao.talletaPalaute(palaute);
	}
	/* (non-Javadoc)
	 * @see fi.softala.service.PalauteService#tarkistaOpiskelijanumero(java.lang.String)
	 */
	public boolean tarkistaOpiskelijanumero(String opiskelijanumero) {
		return opiskelijanumero.equals(palautedao.haePalautteenOpiskelianumero(opiskelijanumero).getOpiskelijanumero());
	}
	public boolean tarkistaOsallistuja(String opiskelijanumero, String koulutus_id) {
		return opiskelijanumero.equals(osallistujadao.haeOsallistuja(opiskelijanumero, koulutus_id).getOpiskelijanro());		
	}
}
