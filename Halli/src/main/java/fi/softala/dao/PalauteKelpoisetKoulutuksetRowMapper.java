package fi.softala.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.bean.Koulutustilaisuus;

public class PalauteKelpoisetKoulutuksetRowMapper implements RowMapper<Koulutustilaisuus> {
	public Koulutustilaisuus mapRow(ResultSet rs, int rowNum) throws SQLException {
		Koulutustilaisuus k = new Koulutustilaisuus();
		k.setId(rs.getInt("koulutus_id"));
		k.setAihe(rs.getString("aihe"));
		k.setSuomiPvm(Date.valueOf(rs.getString("pvm")));
		return k;
	}
}
