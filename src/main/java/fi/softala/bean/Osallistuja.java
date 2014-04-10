package fi.softala.bean;

public class Osallistuja {
	
	private int id;
	private String opiskelijanro;
	private String etunimi;
	private String sukunimi;
	
	public Osallistuja() {
		id = 0;
		opiskelijanro = null;
		etunimi = null;
		sukunimi = null;
	}
	
	public Osallistuja(int id, String onro, String enimi, String snimi) {
		this.id = id;
		this.opiskelijanro = onro;
		this.etunimi = enimi;
		this.sukunimi = snimi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOpiskelijanro() {
		return opiskelijanro;
	}

	public void setOpiskelijanro(String opiskelijanro) {
		this.opiskelijanro = opiskelijanro;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	@Override
	public String toString() {
		return "OsallistujaImpl [id=" + id + ", opiskelijanro=" + opiskelijanro
				+ ", etunimi=" + etunimi + ", sukunimi=" + sukunimi + "]";
	}
}
