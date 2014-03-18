package softala;

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

import softala.Aikatauluslotti;

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
	 * Tallettaa parametrina annetun henkilön tietokantaan. Tietokannan
	 * generoima id asetetaan parametrina annettuun olioon.
	 */
	public void talleta(Aikatauluslotti h) {
		final String sql = "insert into aikatauluslotti(pvm, alkukello, loppukello, kouluttajaid, opettajaid) values(?,?,?,?,?)";

		// anonyymi sisäluokka tarvitsee vakioina välitettävät arvot,
		// jotta roskien keruu onnistuu tämän metodin suorituksen päättyessä.
		final String pvm = h.getPvm();
		final String alkukello = h.getAlkukello();
		final String loppukello = h.getLoppukello();
		final int kouluttajaid = h.getKouluttajaId();
		final int opettajaid = h.getOpettajaId();

		// jdbc pistää generoidun id:n tänne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();

		// suoritetaan päivitys itse määritellyllä PreparedStatementCreatorilla
		// ja KeyHolderilla
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				ps.setString(1, pvm);
				ps.setString(2, alkukello);
				ps.setString(3, loppukello);
				ps.setInt(4, kouluttajaid);
				ps.setInt(5, opettajaid);
				return ps;
			}
		}, idHolder);

		// tallennetaan id takaisin beaniin, koska
		// kutsujalla pitäisi olla viittaus samaiseen olioon
		h.setId(idHolder.getKey().intValue());

	}

	public Aikatauluslotti etsi(int id) {
		String sql = "select pvm, alkukello,loppukello,kouluttajaid,opettajaid from henkilo where id = ?";
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

		String sql = "select id, pvm, alkukello, loppukello, kouluttajaid, opettajaid from henkilo";
		RowMapper<Aikatauluslotti> mapper = new AikatauluslottiRowMapper();
		List<Aikatauluslotti> aikatauluslotit = jdbcTemplate.query(sql, mapper);

		return aikatauluslotit;
	}
}
