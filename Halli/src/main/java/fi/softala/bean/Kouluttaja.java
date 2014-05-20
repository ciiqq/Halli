package fi.softala.bean;

import javax.validation.constraints.*;


public class Kouluttaja {
	
	@Pattern(regexp = "\\d{7}", message="Opiskelijanumeron tulee koostua seitsemästä numerosta.")
	private String opiskelijanro;
	
	@Size(min = 2, max = 50, message="Etunimen tulee olla 2-50 merkkiä pitkä.")
	private String etunimi;
	
	@Size(min = 2, max = 50, message="Sukunimen tulee olla 2-50 merkkiä pitkä.")
	private String sukunimi;
	
	private String salasana;
	private String suola;
	
	public Kouluttaja() {
		opiskelijanro = null;
		etunimi = null;
		sukunimi = null;
		salasana = null;
		suola = null;
	}
	
	public Kouluttaja(String etunimi, String sukunimi, String opiskelijanro) {
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.opiskelijanro = opiskelijanro;
		this.salasana = null;
		this.suola = null;
	}

	public Kouluttaja(String onro, String enimi, String snimi, String ssana, String suola) {
		this.opiskelijanro = onro;
		this.etunimi = enimi;
		this.sukunimi = snimi;
		this.salasana = ssana;
		this.suola = suola;
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
		this.sukunimi = sukunimi;;
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
		return "KouluttajaImpl [opiskelijanro=" + opiskelijanro + ", etunimi="
				+ etunimi + ", sukunimi=" + sukunimi + ", salasana=" + salasana
				+ ", suola=" + suola + "]";
	}

}

