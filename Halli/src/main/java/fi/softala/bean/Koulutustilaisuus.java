package fi.softala.bean;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Koulutustilaisuus {
	
	private SimpleDateFormat suomiPvmMuotoilu = new SimpleDateFormat("dd.MM.yyyy");
	private SimpleDateFormat suomiKloMuotoilu = new SimpleDateFormat("HH.mm");
	
	private int id;
	
	@Size(min=5, max=50)
	private String aihe;
	
	@Min(value=20)
	private String kuvaus;
	
	@Size()
	private String lahtotaso;
	private boolean nakyvyys;
	private String suomiPvm;
	private String suomiKlo;
	private Opettaja ope;
	private List<Kouluttaja> kouluttajat = new ArrayList<Kouluttaja>();
	private List<String> avainsanat = new ArrayList<String>();
	private Aikatauluslotti aikaslotti;
	
	
	
	public Aikatauluslotti getAikaslotti() {
		return aikaslotti;
	}

	public void setAikaslotti(Aikatauluslotti aikaslotti) {
		this.aikaslotti = aikaslotti;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	public String getLahtotaso() {
		return lahtotaso;
	}

	public void setLahtotaso(String lahtotaso) {
		this.lahtotaso = lahtotaso;
	}


	public boolean getNakyvyys() {
		return nakyvyys;
	}

	public void setNakyvyys(boolean nakyvyys) {
		this.nakyvyys = nakyvyys;
	}

	public String getSuomiPvm() {
		return suomiPvm;
	}

	// Käytetään SQL päivämäärän muuttamisessa suomalaiseksi
	// Hyödyntämällä java.sql.Date -kirjastoa
	public void setSuomiPvm(Date suomiPvm) {
		this.suomiPvm = suomiPvmMuotoilu.format(suomiPvm);
	}

	public String getSuomiKlo() {
		return suomiKlo;
	}

	// Käytetään SQL kellonajan muuttamisessa suomalaiseksi
	// Hyödyntämällä java.sql.Time -kirjastoa
	public void setSuomiKlo(Time suomiKlo) {
		this.suomiKlo = suomiKloMuotoilu.format(suomiKlo);
	}

	public Opettaja getOpe() {
		return ope;
	}

	public void setOpe(Opettaja ope) {
		this.ope = ope;
	}

	public List<Kouluttaja> getKouluttajat() {
		return kouluttajat;
	}

	public void setKouluttajat(List<Kouluttaja> kouluttajat) {
		this.kouluttajat = kouluttajat;
	}

	public List<String> getAvainsanat() {
		return avainsanat;
	}

	public void setAvainsanat(List<String> avainsanat) {
		this.avainsanat = avainsanat;
	}

	@Override
	public String toString() {
		return "Koulutustilaisuus [suomiPvmMuotoilu=" + suomiPvmMuotoilu
				+ ", suomiKloMuotoilu=" + suomiKloMuotoilu + ", id=" + id
				+ ", aihe=" + aihe + ", kuvaus=" + kuvaus + ", lahtotaso="
				+ lahtotaso + ", nakyvyys=" + nakyvyys + ", suomiPvm="
				+ suomiPvm + ", suomiKlo=" + suomiKlo + ", ope=" + ope
				+ ", kouluttajat=" + kouluttajat + ", avainsanat=" + avainsanat
				+ ", aikaslotti=" + aikaslotti + "]";
	}



}