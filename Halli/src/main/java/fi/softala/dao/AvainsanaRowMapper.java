package fi.softala.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.bean.Avainsana;

public class AvainsanaRowMapper implements RowMapper<Avainsana>{

	public Avainsana mapRow(ResultSet rs, int rowNum) throws SQLException {
		Avainsana a = new Avainsana();
		
		a.setId(rs.getInt("a.avainsana_id"));
		a.setAvainsana(rs.getString("a.avainsana"));
		
		return a;
	}

}
