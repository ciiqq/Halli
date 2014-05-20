package fi.softala.dao;

import fi.softala.bean.Aikatauluslotti;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class HaeAjatRowMapper implements RowMapper<Aikatauluslotti> {

	public Aikatauluslotti mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Aikatauluslotti a = new Aikatauluslotti();
		SimpleDateFormat merkkijonostaDateen = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			merkkijonostaDateen.parse(rs.getString("pvm"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
		}
		
		try {
			a.setId(rs.getInt("aika_id"));
			a.setPvm(rs.getString("pvm"));

			a.setAlkukello(rs.getString("alkukello"));
			a.setLoppukello(rs.getString("loppukello"));
			a.setKoulutustila(rs.getString("koulutustila"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		return a;
	}
	
}
