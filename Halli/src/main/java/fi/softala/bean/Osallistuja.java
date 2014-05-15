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
			opiskelijanro = opiskelijanro.substring(1, 8);
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
		return muotoileNimi(etunimi);
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return muotoileNimi(sukunimi);
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
	
	public String muotoileNimi(String nimi){
		String muotoiltuNimi=nimi.substring(0,1).toUpperCase();
		for(int i = 1; i < nimi.length();i++){
			if(nimi.substring(i, i+1).equals("-")){
				muotoiltuNimi+=nimi.substring(i, i+1);
				muotoiltuNimi+=nimi.substring(i+1, i+2).toUpperCase();
				i++;
			}else{
				muotoiltuNimi+=nimi.substring(i, i+1).toLowerCase();
			}
		}
		return muotoiltuNimi;
	}

	@Override
	public String toString() {
		return "OsallistujaImpl [id=" + id + ", opiskelijanro=" + opiskelijanro
				+ ", etunimi=" + etunimi + ", sukunimi=" + sukunimi + "]";
	}
}
