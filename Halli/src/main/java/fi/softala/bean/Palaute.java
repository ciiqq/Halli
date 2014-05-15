package fi.softala.bean;

public class Palaute {

	private int palaute_id;
	private int arvosana;
	private String palauteteksti;
	private String opiskelijanro;
	private String aihe;
	private String kuvaus;

	public String getKoulutuksenAihe() {
		return aihe;
	}

	public String getAihe() {
		return aihe;
	}

	public void setAihe(String aihe) {
		this.aihe = aihe;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
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
				+ opiskelijanro + ", aihe=" + aihe + ", kuvaus=" + kuvaus + "]";
	}

	public String getOpiskelijanro() {
		return opiskelijanro;
	}

	public void setOpiskelijanro(String opiskelijanro) {
		this.opiskelijanro = opiskelijanro;
	}

}
