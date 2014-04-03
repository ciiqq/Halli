package fi.softala.DAO;

import java.util.List;
import fi.softala.bean.Aikatauluslotti;

public interface AikatauluslottiDAO {

	public abstract void talleta(Aikatauluslotti henkilo);

	public abstract Aikatauluslotti etsi(int id);

	public abstract List<Aikatauluslotti> haeKaikki();

}
