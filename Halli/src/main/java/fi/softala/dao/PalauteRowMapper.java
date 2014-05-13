package fi.softala.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.bean.Palaute;

public class PalauteRowMapper implements RowMapper<Palaute> {

	public Palaute mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Palaute p = new Palaute();
		p.setArvosana(rs.getInt("arvosana"));
		p.setPalauteteksti(rs.getString("palauteteksti"));
		p.setPalaute_id(rs.getInt("palaute_id"));
		p.setOpiskelijanro(rs.getString("osallistujan_opiskelijanro"));
		return p;
	}
	
	

}
