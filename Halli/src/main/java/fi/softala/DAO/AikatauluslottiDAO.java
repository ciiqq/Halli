package softala;

import java.util.List;
import softala.Aikatauluslotti;

public interface AikatauluslottiDAO {

	public abstract void talleta(Aikatauluslotti henkilo);

	public abstract Aikatauluslotti etsi(int id);

	public abstract List<Aikatauluslotti> haeKaikki();

}
