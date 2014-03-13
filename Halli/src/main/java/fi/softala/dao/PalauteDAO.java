package fi.softala.dao;

import java.util.List;


import fi.softala.bean.Palaute;

public interface PalauteDAO {

	public abstract List<Palaute> haeKaikki();
	
	public abstract List<Palaute> haeIdlla();

}
