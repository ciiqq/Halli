package fi.softala.dao;

import fi.softala.bean.Aikatauluslotti;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HaeAjatRowMapper implements RowMapper<Aikatauluslotti> {

	public Aikatauluslotti mapRow(ResultSet rs, int rowNum) {
		
		Aikatauluslotti a = new Aikatauluslotti();
		try {
			//a.setPvm(rs.getString("pvm"));
			a.setAlkukello(rs.getString("alkukello"));
			a.setLoppukello(rs.getString("loppukello"));
			a.setKoulutustila(rs.getString("koulutustila"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		return a;
	}
	
}
