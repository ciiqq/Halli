package fi.softala.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import fi.softala.bean.Aikatauluslotti;
import fi.softala.bean.Koulutustilaisuus;
// import fi.softala.bean.AikatauluslottiImpl;



import org.springframework.jdbc.core.RowMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AikatauluslottiRowMapper implements RowMapper<Aikatauluslotti> {

	public Aikatauluslotti mapRow(ResultSet rs, int rowNum) throws SQLException {
		Aikatauluslotti a = new Aikatauluslotti();
		Koulutustilaisuus k = new Koulutustilaisuus();
		SimpleDateFormat merkkijonostaDateen = new SimpleDateFormat("yyyy-DD-mm");
		
		try {
			merkkijonostaDateen.parse(rs.getString("pvm"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
		}
		a.setPvm(merkkijonostaDateen);
		a.setAlkukello(rs.getString("alkukello"));
		a.setLoppukello(rs.getString("loppukello"));
		a.setKoulutustila(rs.getString("koulutustila"));
		if(rs.getString("koulutus_id")!=null)
			k.setId(Integer.parseInt(rs.getString("koulutus_id")));
		else
			k.setId(0);
		a.setKoulutus(k);
		a.setId(rs.getInt("aika_id"));
		
		return a;
	}
}