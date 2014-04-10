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
	
		at.setAlkukello(rs.getString("asl.alkukello"));
		at.setLoppukello(rs.getString("asl.loppukello"));
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
