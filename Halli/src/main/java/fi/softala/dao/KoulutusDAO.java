package fi.softala.dao;

import java.util.List;

import fi.softala.bean.Koulutustilaisuus;;

public interface KoulutusDAO {
	
	public abstract void tallennaVaraus(Koulutustilaisuus koulutus);

	public abstract Koulutustilaisuus etsi(int id);

	public abstract List<Koulutustilaisuus> haeKaikki();
	
	public void tallennaKoulussuunnitelma(Koulutustilaisuus koulutustilaisuus);

}
