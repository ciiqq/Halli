package fi.softala.bean;

import javax.validation.constraints.*;

import fi.softala.funktiot.FormatoiNimi;

public class Kouluttaja {
	
	@Pattern(regexp = "\\d{7}")
	private String opiskelijanro;
	
	@Size(min = 2, max = 50)
	private String etunimi;
	
	@Size(min = 2, max = 50)
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
		this.etunimi = FormatoiNimi.isoAlkukirjain(etunimi);
		this.sukunimi = FormatoiNimi.isoAlkukirjain(sukunimi);
		this.opiskelijanro = opiskelijanro;
		this.salasana = null;
		this.suola = null;
	}

	public Kouluttaja(String onro, String enimi, String snimi, String ssana, String suola) {
		this.opiskelijanro = onro;
		this.etunimi = FormatoiNimi.isoAlkukirjain(enimi);
		this.sukunimi = FormatoiNimi.isoAlkukirjain(snimi);;
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
		this.etunimi = FormatoiNimi.isoAlkukirjain(etunimi);;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = FormatoiNimi.isoAlkukirjain(sukunimi);;
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
