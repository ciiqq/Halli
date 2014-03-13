package fi.softala.bean;

public class Opettaja {
	
	private int id;
	private String etunimi;
	private String sukunimi;
	private String salasana;
	private String suola;
	
	public Opettaja() {
		super();
	}

	public Opettaja(int id, String etunimi, String sukunimi,
			String salasana, String suola) {
		super();
		this.id = id;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.salasana = salasana;
		this.suola = suola;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSalasana() {
		return salasana;
	}

	public void setSalasana(String salasana) {
		this.salasana = salasana;
	}

	public String getSuola() {
		return suola;
	}

	public void setSuola(String suola) {
		this.suola = suola;
	}

	@Override
	public String toString() {
		return "OpettajaImpl [id=" + id + ", etunimi=" + etunimi
				+ ", sukunimi=" + sukunimi + ", salasana=" + salasana
				+ ", suola=" + suola + "]";
	}
}