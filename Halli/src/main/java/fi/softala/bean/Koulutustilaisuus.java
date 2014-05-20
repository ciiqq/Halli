package fi.softala.bean;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Koulutustilaisuus {
	
	private SimpleDateFormat suomiPvmMuotoilu = new SimpleDateFormat("dd.MM.yyyy");
	private SimpleDateFormat suomiKloMuotoilu = new SimpleDateFormat("HH.mm");
	
	private int id;
	
	@Size(min=5, max=50, message="Aiheen t�ytyy olla v�hint��n 5 merkki� pitk�")
	private String aihe;
	
	@Size(min=5)
	private String kuvaus;
	
	@Size(min=5)
	private String lahtotaso;
	
	private boolean nakyvyys;
	private String suomiPvm;
	private String suomiLoppuKlo;
	private String suomiKlo;
	private String aikaPaiva;
	private String paikka;
	private Opettaja ope; // opettajabean t�h�n
	private List<Henkilo> opettajat;
	private List<Kouluttaja> kouluttajat1;
	private List<Henkilo> kouluttajat;
	private List<String> avainsanat1;
	private List<Avainsana> avainsanat;

	private Aikatauluslotti aikaslotti;
	private String koulutusmenetelmat;
	
	//Ryhm� 3 -versio
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

	// K�ytet��n SQL p�iv�m��r�n muuttamisessa suomalaiseksi
	// Hy�dynt�m�ll� java.sql.Date -kirjastoa
	public void setSuomiPvm(Date suomiPvm) {
		this.suomiPvm = suomiPvmMuotoilu.format(suomiPvm);
	}

	public String getSuomiKlo() {
		return suomiKlo;
	}

	// K�ytet��n SQL kellonajan muuttamisessa suomalaiseksi
	// Hy�dynt�m�ll� java.sql.Time -kirjastoa
	public void setSuomiKlo(Time suomiKlo) {
		this.suomiKlo = suomiKloMuotoilu.format(suomiKlo);
	}
	
	public String getSuomiLoppuKlo() {
		return suomiLoppuKlo;
	}

	// K�ytet��n SQL kellonajan muuttamisessa suomalaiseksi
	// Hy�dynt�m�ll� java.sql.Time -kirjastoa
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





	public String getPaikka() {
		return paikka;
	}

	public void setPaikka(String paikka) {
		this.paikka = paikka;
	}

	public SimpleDateFormat getSuomiPvmMuotoilu() {
		return suomiPvmMuotoilu;
	}

	public void setSuomiPvmMuotoilu(SimpleDateFormat suomiPvmMuotoilu) {
		this.suomiPvmMuotoilu = suomiPvmMuotoilu;
	}

	public SimpleDateFormat getSuomiKloMuotoilu() {
		return suomiKloMuotoilu;
	}

	public void setSuomiKloMuotoilu(SimpleDateFormat suomiKloMuotoilu) {
		this.suomiKloMuotoilu = suomiKloMuotoilu;
	}

	public String getAikaPaiva() {
		return aikaPaiva;
	}

	public void setAikaPaiva(String aikaPaiva) {
		this.aikaPaiva = aikaPaiva;
	}

	public String getKoulutusmenetelmat() {
		return koulutusmenetelmat;
	}

	public void setKoulutusmenetelmat(String koulutusmenetelmat) {
		this.koulutusmenetelmat = koulutusmenetelmat;
	}

	public void setSuomiPvm(String suomiPvm) {
		this.suomiPvm = suomiPvm;
	}

	public void setSuomiKlo(String suomiKlo) {
		this.suomiKlo = suomiKlo;
	}

	public List<Kouluttaja> getKouluttajat1() {
		return kouluttajat1;
	}

	public void setKouluttajat1(List<Kouluttaja> kouluttajat1) {
		this.kouluttajat1 = kouluttajat1;
	}

	public List<String> getAvainsanat1() {
		return avainsanat1;
	}

	public void setAvainsanat1(List<String> avainsanat1) {
		this.avainsanat1 = avainsanat1;
	}
	
	
	
	
}