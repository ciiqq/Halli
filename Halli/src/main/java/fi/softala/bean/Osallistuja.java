package fi.softala.bean;

public class Osallistuja {
	
	private int id;
	private String opiskelijanro;
	private String etunimi;
	private String sukunimi;
	private String sahkoposti;
	
	public Osallistuja() {
		id = 0;
		opiskelijanro = null;
		etunimi = null;
		sukunimi = null;
	}
	
	public Osallistuja(int id, String onro, String enimi, String snimi) {
		this.id = id;
		this.opiskelijanro = onro;
		this.etunimi = enimi;
		this.sukunimi = snimi;
	}
	
	public Osallistuja (String onro, String enimi, String snimi){
		this.opiskelijanro = onro;
		this.etunimi = enimi;
		this.sukunimi = snimi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOpiskelijanro() {
		if (opiskelijanro.length() == 8){
			opiskelijanro = opiskelijanro.substring(0, 7);
			return opiskelijanro;
		}
		else{
			return opiskelijanro;
		}
	}

	public void setOpiskelijanro(String opiskelijanro) {
		this.opiskelijanro = opiskelijanro;
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
	
	public void setSahkoposti(String etunimi, String sukunimi){
		 sahkoposti = etunimi + "." + sukunimi + "@myy.haaga-helia.fi";
	}
	
	public String getSahkoposti(){
		return sahkoposti;
	}

	@Override
	public String toString() {
		return "OsallistujaImpl [id=" + id + ", opiskelijanro=" + opiskelijanro
				+ ", etunimi=" + etunimi + ", sukunimi=" + sukunimi + "]";
	}
}
