package fi.softala.funktiot;


public abstract class FormatoiNimi {

	public static String isoAlkukirjain(String nimi){
		nimi = nimi.substring(0,1).toUpperCase() + nimi.substring(1);
		return nimi;
	}
}
