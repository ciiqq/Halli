package fi.softala.dao;

import java.util.List;

import fi.softala.bean.Koulutustilaisuus;

public interface KoulutusHakuDAO {
	
	List<Koulutustilaisuus> haeMenneet();
	List<Koulutustilaisuus> haeTulevat();
	List<Koulutustilaisuus> haeHakusanalla(String ehto);
	List<Koulutustilaisuus> haeAvainsanalla(String ehto);
	List<Koulutustilaisuus> haePalauteKelpoiset(String opiskelijanro);
}
