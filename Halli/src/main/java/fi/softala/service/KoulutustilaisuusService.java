package fi.softala.service;

import fi.softala.bean.Koulutustilaisuus;
import fi.softala.dao.KoulutusDAO;

public interface KoulutustilaisuusService {
	
	public void tallennaKoulutustilaisuus(Koulutustilaisuus koulutustilaisuus);	

}
