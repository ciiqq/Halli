package fi.softala.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.softala.bean.Aikatauluslotti;
import java.text.SimpleDateFormat;

@Repository
public class AikatauluslottiDAOSpringJdbcImpl implements AikatauluslottiDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Tallettaa parametrina annetun henkilˆn tietokantaan. Tietokannan
	 * generoima id asetetaan parametrina annettuun olioon.
	 */
	public void talleta(Aikatauluslotti a) {
		final String sql = "insert into aikatauluslotti(pvm, alkukello, loppukello, koulutustila, koulutus_id) values(?,?,?,?,?)";

		// anonyymi sis‰luokka tarvitsee vakioina v‰litett‰v‰t arvot,
		// jotta roskien keruu onnistuu t‰m‰n metodin suorituksen p‰‰ttyess‰.
//		final SimpleDateFormat pvm = a.getPvm();
		final String pvm = a.getPvm();
		final String alkukello = a.getAlkukello();
		final String loppukello = a.getLoppukello();
		final String koulutustila = a.getKoulutustila();
//		final int koulutusid = a.getKoulutus().getId();
		final int koulutusid = 1;
//		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd"); poistettu rivi 13.5.2014
//		final String date = DATE_FORMAT.format(pvm); poistettu rivi 13.5.2014
		// jdbc pist‰‰ generoidun id:n t‰nne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();

		// suoritetaan p‰ivitys itse m‰‰ritellyll‰ PreparedStatementCreatorilla
		// ja KeyHolderilla
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				System.out.println("talleta: pm: " + pvm + " alkukello: " + alkukello + " loppukello: " + loppukello);
//				ps.setString (1, date);
				ps.setString (1, pvm);
				ps.setString(2, alkukello);
				ps.setString(3, loppukello);
				ps.setString(4, koulutustila);
				ps.setInt(5, koulutusid);
				return ps;
			}
		}, idHolder);

		// tallennetaan id takaisin beaniin, koska
		// kutsujalla pit‰isi olla viittaus samaiseen olioon
		a.setId(idHolder.getKey().intValue());

	}

	public Aikatauluslotti etsi(int id) {
		String sql = "select pvm, alkukello, loppukello, koulutustila, koulutus_id from henkilo where id = ?";
		Object[] parametrit = new Object[] { id };
		RowMapper<Aikatauluslotti> mapper = new AikatauluslottiRowMapper();

		Aikatauluslotti a;
		try {
			a = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new AikatauluslottiaEiLoydyPoikkeus(e);
		}
		return a;

	}

	public List<Aikatauluslotti> haeKaikki() {

		String sql = "select aika_id, pvm, alkukello, loppukello, koulutustila, koulutus_id from aikatauluslotti";
		RowMapper<Aikatauluslotti> mapper = new AikatauluslottiRowMapper();
		List<Aikatauluslotti> aikatauluslotit = jdbcTemplate.query(sql, mapper);

		return aikatauluslotit;
	}
}
