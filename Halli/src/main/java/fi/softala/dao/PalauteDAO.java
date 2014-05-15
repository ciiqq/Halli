package fi.softala.dao;

import java.util.List;

import fi.softala.bean.Palaute;

public interface PalauteDAO {

	public abstract List<Palaute> haeKaikki();
	
	public abstract List<Palaute> haeIdlla();
	
	public abstract void talletaPalaute(Palaute palaute, int koulutus_id);
	
	public abstract Palaute haePalautteenOpiskelianumero(String opiskelijanumero);

}
