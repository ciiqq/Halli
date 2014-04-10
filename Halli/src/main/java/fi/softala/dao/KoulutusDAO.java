package fi.softala.dao;

import java.util.List;

import fi.softala.bean.Aikatauluslotti;

public interface KoulutusDAO {
	
	public List<Aikatauluslotti> haeKoulutukset();

	public Aikatauluslotti haeKoulutus(int id);
}
