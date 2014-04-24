package fi.softala.DAO;

import fi.softala.bean.Kouluttaja;


public interface KouluttajienLisaysDAO {

	public abstract Kouluttaja kouluttajanHaku(String opiskelijanro);
	
	public abstract void kouluttajanLisays(Kouluttaja kouluttaja);
	
}
