package fi.softala.funktiot;

import org.apache.commons.lang3.RandomStringUtils;

public abstract class SalasanaGeneraattori {

	public static String generoiSalasana(int pituus){
		return RandomStringUtils.randomAlphanumeric(pituus);
	}
	
	public static String generoiSalasana(){
		return RandomStringUtils.randomAlphanumeric(8);
	}
}
