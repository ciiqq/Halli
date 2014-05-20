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
	
	@Size(min=5, max=50, message="Aiheen täytyy olla vähintään 5 merkkiä pitkä")
	private String aihe;
	
	@Size(min=5)
	private String kuvaus;
	
	@Size(min=5)
	private String lahtotaso;
	
	private boolean nakyvyys;
	private String suomiPvm;
	private String suomiLoppuKlo;
	private String suomiKlo;
	private List<Henkilo> kouluttajat = new ArrayList<Henkilo>();
	private List<Henkilo> opettajat = new ArrayList<Henkilo>();
	private List<Avainsana> avainsanat = new ArrayList<Avainsana>();
	private Aikatauluslotti aikaslotti;
	private String koulutusmenetelmat;
	private String paikka;
	
	//Ryhmä 3 -versio
	private List<Kouluttaja> kouluttajat2 = new ArrayList<Kouluttaja>();
	private List<String> avainsanat2 = new ArrayList<String>();
	
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
	
	public String getSuomiLoppuKlo() {
		return suomiLoppuKlo;
	}

	// Käytetään SQL kellonajan muuttamisessa suomalaiseksi
	// Hyödyntämällä java.sql.Time -kirjastoa
	public void setSuomiLoppuKlo(Time suomiLoppuKlo) {
		this.suomiLoppuKlo = suomiKloMuotoilu.format(suomiLoppuKlo);
	}


	public List<Henkilo> getOpettajat() {
		return opettajat;
	}

	public void setOpettajat(List<Henkilo> opettajat) {
		this.opettajat = opettajat;
	}

	public List<Henkilo> getKouluttajat() {
		return kouluttajat;
	}

	public void setKouluttajat(List<Henkilo> kouluttajat) {
		this.kouluttajat = kouluttajat;
	}

	public List<Avainsana> getAvainsanat() {
		return avainsanat;
	}

	public void setAvainsanat(List<Avainsana> avainsanat) {
		this.avainsanat = avainsanat;
	}
	
	

	public List<Kouluttaja> getKouluttajat2() {
		return kouluttajat2;
	}

	public void setKouluttajat2(List<Kouluttaja> kouluttajat2) {
		this.kouluttajat2 = kouluttajat2;
	}
	
	

	public List<String> getAvainsanat2() {
		return avainsanat2;
	}

	public void setAvainsanat2(List<String> avainsanat2) {
		this.avainsanat2 = avainsanat2;
	}

	@Override
	public String toString() {
		return "Koulutustilaisuus [suomiPvmMuotoilu=" + suomiPvmMuotoilu
				+ ", suomiKloMuotoilu=" + suomiKloMuotoilu + ", id=" + id
				+ ", aihe=" + aihe + ", kuvaus=" + kuvaus + ", lahtotaso="
				+ lahtotaso + ", nakyvyys=" + nakyvyys + ", suomiPvm="
				+ suomiPvm + ", suomiKlo=" + suomiKlo + ", kouluttajat="
				+ kouluttajat + ", opettajat=" + opettajat + ", avainsanat="
				+ avainsanat + ", aikaslotti=" + aikaslotti + "]";
	}



	public String getKoulutusmenetelmat() {
		return koulutusmenetelmat;
	}

	public void setKoulutusmenetelmat(String koulutusmenetelmat) {
		this.koulutusmenetelmat = koulutusmenetelmat;
	}

	public String getPaikka() {
		return paikka;
	}

	public void setPaikka(String paikka) {
		this.paikka = paikka;
	}
	
	
	
	
}