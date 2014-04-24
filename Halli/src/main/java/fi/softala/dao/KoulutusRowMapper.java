package fi.softala.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.bean.Aikatauluslotti;
import fi.softala.bean.Koulutustilaisuus;

public class KoulutusRowMapper implements RowMapper<Aikatauluslotti> {

	public Aikatauluslotti mapRow(ResultSet rs, int rowNum) throws SQLException {
		Aikatauluslotti at = new Aikatauluslotti();
		
		
		at.setId(rs.getInt("asl.aika_id"));
	
		String alkukello = rs.getString("asl.alkukello");
		String loppukello = rs.getString("asl.loppukello");
		
		at.setAlkukello(alkukello.substring(0,5));
		at.setLoppukello(loppukello.substring(0, 5));
		at.setKoulutustila(rs.getString("asl.koulutustila"));
		
		String pvm = rs.getString("asl.pvm");
		
		String[] suomiPvm = pvm.split("-");
		
		at.setPvm(suomiPvm[2] + "." + suomiPvm[1] + "." + suomiPvm[0]);
		
		Koulutustilaisuus kt = new Koulutustilaisuus();
		
		kt.setAihe(rs.getString("kt.aihe"));
		kt.setKuvaus(rs.getString("kt.kuvaus"));
		kt.setLahtotaso(rs.getString("kt.lahtotaso"));
		kt.setNakyvyys(rs.getBoolean("kt.nakyvyys"));
		
		at.setKoulutus(kt);
		
		return at;
	}

}
