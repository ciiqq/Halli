package fi.softala.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.bean.Koulutustilaisuus;

public class KoulutusHakuRowMapper implements RowMapper<Koulutustilaisuus> {

	public Koulutustilaisuus mapRow(ResultSet rs, int rowNum) throws SQLException {
		Koulutustilaisuus k = new Koulutustilaisuus();
		k.setId(rs.getInt("koulutus_id"));
		k.setAihe(rs.getString("aihe"));
		k.setKuvaus(rs.getString("kuvaus"));
		k.setLahtotaso(rs.getString("lahtotaso"));
		k.setPaikka(rs.getString("koulutustila"));
		k.setSuomiPvm(Date.valueOf(rs.getString("pvm")));
		k.setSuomiKlo(Time.valueOf(rs.getString("alkukello")));
		k.setSuomiLoppuKlo(Time.valueOf(rs.getString("loppukello")));
		k.setKoulutusmenetelmat(rs.getString("koulutusmenetelmat"));
		
		return k;
	}
}
