package fi.softala.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.bean.Kouluttaja;

public class KouluttajaRowMapper implements RowMapper<Kouluttaja> {

	public Kouluttaja mapRow(ResultSet rs, int rowNum) throws SQLException {
		Kouluttaja k = new Kouluttaja();
		k.setOpiskelijanro("a"+rs.getString("opiskelijanro"));
		k.setEtunimi(rs.getString("etunimi"));
		k.setSukunimi(rs.getString("sukunimi"));

		return k;
	}
}
