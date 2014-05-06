package fi.softala.dao;

import java.util.List;

import fi.softala.bean.Koulutustilaisuus;

public interface KoulutusDAO {
	
	public List<Koulutustilaisuus> haeKoulutukset();

	public Koulutustilaisuus haeKoulutus(int id);
	
	public void paivitaKoulutus(Koulutustilaisuus koulutus);
	
	public void peruutaKoulutus(int id);

	public void siirraKoulutus(int koulutusId, int aikaId);
}
