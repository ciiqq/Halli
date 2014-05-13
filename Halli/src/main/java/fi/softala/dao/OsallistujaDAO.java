package fi.softala.dao;

import org.mariadb.jdbc.internal.common.QueryException;

import fi.softala.bean.Osallistuja;

public interface OsallistujaDAO {
	
	public abstract void talleta(Osallistuja osallistuja, String[] osallistumiset);
	
	public Osallistuja haeOsallistuja(String opiskelijanumero, String koulutus_id);

}