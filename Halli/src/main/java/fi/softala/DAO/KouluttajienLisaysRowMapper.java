package fi.softala.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.bean.Kouluttaja;

public class KouluttajienLisaysRowMapper implements RowMapper<Kouluttaja> {

	public Kouluttaja mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Kouluttaja k = new Kouluttaja();
		
		k.setOpiskelijanro(rs.getString("opiskelijanro"));
		k.setEtunimi(rs.getString("etunimi"));
		k.setSukunimi(rs.getString("sukunimi"));
		k.setSalasana(rs.getString("salasana"));
		k.setSuola(rs.getString("suola"));
		
		return k;
	}

}
