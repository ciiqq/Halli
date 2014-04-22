package fi.softala.dao;

import java.util.List;

import fi.softala.bean.Koulutustilaisuus;

public interface KoulutusHakuDAO {
	
	List<Koulutustilaisuus> haeKaikki();
	List<Koulutustilaisuus> haeValitut(String ehto);

}
