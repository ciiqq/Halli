package fi.softala.bean;

public class Palaute {

	private int palaute_id;
	private int arvosana;
	private String palauteteksti;
	private String opiskelijanro;
	
	public Palaute() {
		this.palaute_id = 0;
		this.palauteteksti = null;
		this.opiskelijanro = null;
		this.arvosana = 0;
	}
	
	public Palaute(String opiskelijanro) {
		this.opiskelijanro = opiskelijanro;
	}
	
	public String getOpiskelijanro() {
		if (opiskelijanro.length() == 8) {
			opiskelijanro = opiskelijanro.substring(1, 8);
			return opiskelijanro;
		}
		else {
			return opiskelijanro;
		}
	}

	public void setOpiskelijanro(String opiskelijanro) {
		this.opiskelijanro = opiskelijanro;
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
				+ ", palauteteksti=" + palauteteksti + ", opiskelijanro="
				+ opiskelijanro + "]";
	}	
}
