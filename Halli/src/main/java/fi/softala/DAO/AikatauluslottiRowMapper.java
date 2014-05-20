package fi.softala.dao;

import fi.softala.bean.Aikatauluslotti;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class AikatauluslottiRowMapper implements RowMapper<Aikatauluslotti> {
	
	public Aikatauluslotti mapRow(ResultSet rs, int rowNum) throws SQLException {
		Aikatauluslotti vp = new Aikatauluslotti();
		
		//Muotoilut
		String alkukello = rs.getString("alkukello");
		String loppukello = rs.getString("loppukello");
		vp.setAlkukello(alkukello.substring(0, 5));
		vp.setLoppukello(loppukello.substring(0, 5));
		
		String pvm = rs.getString("pvm");
		String[] suomiPvm = pvm.split("-");
		vp.setPvm(suomiPvm[2] + "." + suomiPvm[1] + "." + suomiPvm[0]);	
		
		vp.setId(rs.getInt("aika_id"));
			
		vp.setKoulutustila(rs.getString("koulutustila"));	
		
	

		
		return vp;
	}
	
	
}
