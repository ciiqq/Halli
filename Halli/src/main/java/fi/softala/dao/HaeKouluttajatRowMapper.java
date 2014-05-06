package fi.softala.dao;

import fi.softala.bean.Kouluttaja;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HaeKouluttajatRowMapper implements RowMapper<Kouluttaja> {

	public Kouluttaja mapRow(ResultSet rs, int rowNum) {
		
		Kouluttaja k = new Kouluttaja();
		try {
			k.setOpiskelijanro(rs.getString("opiskelijanro"));
			k.setEtunimi(rs.getString("etunimi"));
			k.setSukunimi(rs.getString("sukunimi"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		return k;
	}
	
}
