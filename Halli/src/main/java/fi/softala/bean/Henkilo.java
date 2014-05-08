package fi.softala.bean;

public class Henkilo {
	
	private String htunnus;
	private String rooli;
	private String etunimi;
	private String sukunimi;
	private String salasana;
	private String suola;
	
	public Henkilo() {
		htunnus = null;
		etunimi = null;
		sukunimi = null;
		salasana = null;
		suola = null;
	}
	
	public Henkilo(String onro, String enimi, String snimi, String ssana, String suola) {
		this.htunnus = onro;
		this.etunimi = enimi;
		this.sukunimi = snimi;
		this.salasana = ssana;
		this.suola = suola;
	}

	public String getHtunnus() {
		return htunnus;
	}

	public void setHtunnus(String htunnus) {
		this.htunnus = htunnus;
	}
	
	public String getRooli() {
		return rooli;
	}
	
	public void setRooli(String rooli) {
		this.rooli = rooli;
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
		return "KouluttajaImpl [htunnus=" + htunnus + ", rooli=" + rooli + ", etunimi="
				+ etunimi + ", sukunimi=" + sukunimi + ", salasana=" + salasana
				+ ", suola=" + suola + "]";
	}

}
