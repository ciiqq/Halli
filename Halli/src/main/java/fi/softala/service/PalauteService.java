package fi.softala.service;

import fi.softala.bean.Palaute;

public interface PalauteService {

	public abstract void tallenna(Palaute palaute, int koulutus_id);

	public abstract boolean tarkistaOpiskelijanumero(String opiskelijanumero);
	
	public abstract boolean tarkistaOsallistuja(String opiskelijanumero, String koulutus_id);

}