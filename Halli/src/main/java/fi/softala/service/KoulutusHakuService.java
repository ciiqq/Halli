package fi.softala.service;

import java.util.List;

import fi.softala.bean.Koulutustilaisuus;

public interface KoulutusHakuService {
	
	List<Koulutustilaisuus> haeKaikki();
	List<Koulutustilaisuus> haeVahvistamattomat();

}
