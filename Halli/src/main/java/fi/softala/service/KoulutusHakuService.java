package fi.softala.service;

import java.util.List;

import fi.softala.bean.Koulutustilaisuus;

public interface KoulutusHakuService {
	
	List<Koulutustilaisuus> haeMenneet();
	List<Koulutustilaisuus> haeTulevat();
	List<Koulutustilaisuus> haeHakusanalla(String ehto);
	List<Koulutustilaisuus> haeAvainsanalla(String ehto);

}
