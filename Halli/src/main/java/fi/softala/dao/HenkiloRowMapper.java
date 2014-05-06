package fi.softala.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.bean.Kouluttaja;

public class HenkiloRowMapper implements RowMapper<Kouluttaja>{

	public Kouluttaja mapRow(ResultSet rs, int rowNum) throws SQLException {
		Kouluttaja k = new Kouluttaja();
		k.setEtunimi(rs.getString("h.etunimi"));
		k.setSukunimi(rs.getString("h.sukunimi"));
		
		return k;
	}

}
