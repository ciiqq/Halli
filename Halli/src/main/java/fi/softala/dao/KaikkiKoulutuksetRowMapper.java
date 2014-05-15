package fi.softala.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.bean.Palaute;

public class KaikkiKoulutuksetRowMapper implements RowMapper<Palaute> {

	public Palaute mapRow(ResultSet rs, int rowNum) throws SQLException {
		Palaute p = new Palaute();
		p.setAihe(rs.getString("aihe"));
		p.setKuvaus(rs.getString("kuvaus"));
		return p;
	}
}
