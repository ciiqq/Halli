package fi.softala.bean;


public class Palaute {

	private int palaute_id;
	private int arvosana;
	private String palauteteksti;
	private int opiskelijanumero;
	
	public int getOpiskelijanumero() {
		return opiskelijanumero;
	}

	public void setOpiskelijanumero(int opiskelijanumero) {
		this.opiskelijanumero = opiskelijanumero;
	}

	public int getPalaute_id() {
		return palaute_id;
	}

	public void setPalaute_id(int palaute_id) {
		this.palaute_id = palaute_id;
	}

	public int getArvosana() {
		return arvosana;
	}

	public void setArvosana(int arvosana) {
		this.arvosana = arvosana;
	}

	public String getPalauteteksti() {
		return palauteteksti;
	}

	public void setPalauteteksti(String palauteteksti) {
		this.palauteteksti = palauteteksti;
	}
	
	@Override
	public String toString() {
		return "Palaute [palaute_id=" + palaute_id + ", arvosana=" + arvosana
				+ ", palauteteksti=" + palauteteksti + ", opiskelijanumero="
				+ opiskelijanumero + "]";
	}
	
	
}
