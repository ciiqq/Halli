package fi.softala.DAO;

import java.util.List;

import fi.softala.bean.Kouluttaja;


public interface KouluttajienLisaysDAO {
	
	public abstract List<Kouluttaja> kouluttajienHaku();

	public abstract Kouluttaja kouluttajanHaku(String opiskelijanro);
	
	public abstract void kouluttajanLisays(Kouluttaja kouluttaja);
	
}
