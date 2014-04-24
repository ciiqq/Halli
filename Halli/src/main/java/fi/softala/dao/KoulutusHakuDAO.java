package fi.softala.dao;

import java.util.List;

import fi.softala.bean.Koulutustilaisuus;

public interface KoulutusHakuDAO {
	
	List<Koulutustilaisuus> haeMenneet();
	List<Koulutustilaisuus> haeTulevat();
	List<Koulutustilaisuus> haeValitut(String ehto);
	List<Koulutustilaisuus> haeAvainsana(String ehto);

}
