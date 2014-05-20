package fi.softala.dao;

import java.util.List;

import fi.softala.bean.Aikatauluslotti;
import fi.softala.bean.Avainsana;
import fi.softala.bean.Henkilo;
import fi.softala.bean.Koulutustilaisuus;

public interface KoulutusDAO {
	
	public List<Koulutustilaisuus> haeKoulutukset(boolean julkaistu);

	public Koulutustilaisuus haeKoulutus(int id);
	
	public void paivitaKoulutus(Koulutustilaisuus koulutus);
	
	public void peruutaKoulutus(int id);

	public void siirraKoulutus(int koulutusId, int aikaId);
	
	public void julkaiseKoulutus(int id);
	
	public List<Henkilo> haeHenkilot(int id, String rooli);
	
	public List<Avainsana> haeAvainsanat(int id);
	
	public List<Aikatauluslotti> haeVapaatSlotit();
}
