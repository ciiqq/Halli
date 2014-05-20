package fi.softala.dao;

import fi.softala.bean.Osallistuja;

public interface OsallistujaDAO {
	
	public abstract void talleta(Osallistuja osallistuja, String[] osallistumiset);
	
	public Osallistuja haeOsallistuja(String opiskelijanumero, String koulutus_id);

}