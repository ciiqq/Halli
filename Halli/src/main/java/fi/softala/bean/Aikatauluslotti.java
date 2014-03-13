package fi.softala.bean;
import java.text.SimpleDateFormat;

public class Aikatauluslotti {
	
	// nmoi
	private int id;
	private SimpleDateFormat pvm;
	private String alkukello;
	private String loppukello;
	private String koulutustila;
	private Koulutustilaisuus koulutus;
	
	public Aikatauluslotti() {
		super();
	}

	public Aikatauluslotti(int id, SimpleDateFormat pvm, String alkukello,
			String loppukello, String koulutustila, Koulutustilaisuus koulutus) {
		super();
		this.id = id;
		this.pvm = pvm;
		this.alkukello = alkukello;
		this.loppukello = loppukello;
		this.koulutustila = koulutustila;
		this.koulutus = koulutus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SimpleDateFormat getPvm() {
		return pvm;
	}

	public void setPvm(SimpleDateFormat pvm) {
		this.pvm = pvm;
	}

	public String getAlkukello() {
		return alkukello;
	}

	public void setAlkukello(String alkukello) {
		this.alkukello = alkukello;
	}

	public String getLoppukello() {
		return loppukello;
	}

	public void setLoppukello(String loppukello) {
		this.loppukello = loppukello;
	}

	public String getKoulutustila() {
		return koulutustila;
	}

	public void setKoulutustila(String koulutustila) {
		this.koulutustila = koulutustila;
	}

	public Koulutustilaisuus getKoulutus() {
		return koulutus;
	}

	public void setKoulutus(Koulutustilaisuus koulutus) {
		this.koulutus = koulutus;
	}

	@Override
	public String toString() {
		return "Aikatauluslotti [id=" + id + ", pvm=" + pvm + ", alkukello="
				+ alkukello + ", loppukello=" + loppukello + ", koulutustila="
				+ koulutustila + ", koulutus=" + koulutus + "]";
	}
}