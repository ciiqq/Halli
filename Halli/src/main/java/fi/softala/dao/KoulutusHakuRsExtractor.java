package fi.softala.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import fi.softala.bean.Kouluttaja;
import fi.softala.bean.Koulutustilaisuus;

/**
 * 
 * @author Timo Kottonen
 *
 */

public class KoulutusHakuRsExtractor implements
		ResultSetExtractor<List<Koulutustilaisuus>> {

	public List<Koulutustilaisuus> extractData(ResultSet rs)
			throws SQLException, DataAccessException {

		RowMapper<Koulutustilaisuus> koulutusMapper = new KoulutusHakuRowMapper();
		RowMapper<Kouluttaja> kouluttajaMapper = new KouluttajaRowMapper();
		Map<Integer, Koulutustilaisuus> koulutukset = new LinkedHashMap<Integer, Koulutustilaisuus>();

		while (rs.next()) {
			int id = rs.getInt("koulutus_id");
			Koulutustilaisuus koulutus = koulutukset.get(id);
			if (koulutus == null) {
				koulutus = koulutusMapper.mapRow(rs, id);
				koulutukset.put(id, koulutus);
			}
			int kouluttaja_true = rs.getInt("kouluttaja_true");
			if (kouluttaja_true == 1) {
				List<Kouluttaja> kouluttajat = koulutus.getKouluttajat();
				Kouluttaja kouluttaja = kouluttajaMapper.mapRow(rs, id);
				kouluttajat.add(kouluttaja);

			} else if (kouluttaja_true == 0) {
				List<String> avainsanat = koulutus.getAvainsanat();
				String avainsana = rs.getString("avainsana");
				avainsanat.add(avainsana);
				Collections.sort(avainsanat);
			}
		}

		return new ArrayList<Koulutustilaisuus>(koulutukset.values());
	}

}
