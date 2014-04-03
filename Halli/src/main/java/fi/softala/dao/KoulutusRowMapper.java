package fi.softala.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.bean.Aikatauluslotti;
import fi.softala.bean.Koulutustilaisuus;

public class KoulutusRowMapper implements RowMapper<Aikatauluslotti> {

	public Aikatauluslotti mapRow(ResultSet rs, int rowNum) throws SQLException {
		Aikatauluslotti at = new Aikatauluslotti();
	
		at.setAlkukello(rs.getString("asl.alkukello"));
		at.setLoppukello(rs.getString("asl.loppukello"));
		at.setKoulutustila(rs.getString("asl.koulutustila"));
		at.setPvm(rs.getString("asl.pvm"));
		
		Koulutustilaisuus kt = new Koulutustilaisuus();
		
		kt.setAihe(rs.getString("kt.aihe"));
		kt.setKuvaus(rs.getString("kt.kuvaus"));
		kt.setLahtotaso(rs.getString("kt.lahtotaso"));
		kt.setNakyvyys(rs.getBoolean("kt.nakyvyys"));
		
		at.setKoulutus(kt);
		
		return at;
	}

}
