package fi.softala.bean;

public class Henkilo {
	
	private String tunnus;
	private String etunimi;
	private String sukunimi;
	private String salasana;
	private String suola;
	
	public Henkilo() {
		tunnus = null;
		etunimi = null;
		sukunimi = null;
		salasana = null;
		suola = null;
	}
	
	public Henkilo(String tunnus, String enimi, String snimi, String ssana, String suola) {
		this.tunnus = tunnus;
		this.etunimi = enimi;
		this.sukunimi = snimi;
		this.salasana = ssana;
		this.suola = suola;
	}

	public String getTunnus() {
		return tunnus;
	}

	public void setTunnus(String tunnus) {
		this.tunnus = tunnus;
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
		return "Henkilo [tunnus=" + tunnus + ", etunimi=" + etunimi
				+ ", sukunimi=" + sukunimi + ", salasana=" + salasana
				+ ", suola=" + suola + "]";
	}


}
