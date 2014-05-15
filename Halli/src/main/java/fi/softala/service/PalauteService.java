package fi.softala.service;

import java.util.List;

import fi.softala.bean.Palaute;

public interface PalauteService {

	public abstract void tallenna(Palaute palaute, int koulutus_id);
	
	public abstract List<Palaute> haePalautteet();
	
	public abstract List<Palaute> haePalautteet(String opiskelijanro);
	
	public abstract List<Palaute> haeIdlla(int id);

}