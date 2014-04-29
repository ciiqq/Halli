package fi.softala.dao;

public interface KoulutusVahvistusDAO {

	public abstract void VahvistaKoulutus(String[] vahvistettavat);
	
	public abstract void VahvistaKaikkiKoulutukset();
	
}
