package fi.softala.bean;
import java.text.SimpleDateFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Aikatauluslotti {
	
	private int id;
	
	@NotNull
	@Pattern(regexp = "\\d{2}.\\d{2}.\\d{4}")
	private String pvm;
	
	@NotNull
	@Pattern(regexp = "\\d{2}:\\d{2}")
	private String alkukello;
	
	@NotNull
	@Pattern(regexp = "\\d{2}:\\d{2}")
	private String loppukello;
	
	@NotNull
	@Size(min=4, max=5)
	private String koulutustila;
	
	private Koulutustilaisuus koulutus;
	
	public Aikatauluslotti() {
		super();
	}
	

	public Aikatauluslotti(Koulutustilaisuus koulutus) {
		super();
		this.koulutus = koulutus;
	}



	public Aikatauluslotti(int id, String pvm, String alkukello,
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

	public String getPvm() {
		return pvm;
	}

	public void setPvm(String pvm) {
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