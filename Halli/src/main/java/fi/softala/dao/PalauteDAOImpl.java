package fi.softala.dao;

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

import fi.softala.bean.Palaute;

@Repository
public class PalauteDAOImpl implements PalauteDAO {

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
	/*public void talleta(Palaute p) {
		final String sql = "insert into henkilo(etunimi, sukunimi) values(?,?)";

		// anonyymi sisäluokka tarvitsee vakioina välitettävät arvot,
		// jotta roskien keruu onnistuu tämän metodin suorituksen päättyessä.
		final int arvosana = p.getArvosana();
		final String palauteteksti = p.getPalauteteksti();

		// jdbc pistää generoidun id:n tänne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();

		// suoritetaan päivitys itse määritellyllä PreparedStatementCreatorilla
		// ja KeyHolderilla
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "palaute_id" });
				ps.setInt(1, arvosana);
				ps.setString(2, palauteteksti);
				return ps;
			}
		}, idHolder);

		// tallennetaan id takaisin beaniin, koska
		// kutsujalla pitäisi olla viittaus samaiseen olioon
		p.setId(idHolder.getKey().intValue());

	}
*/
	/*public Palaute etsi(int id) {
		String sql = "select id, arvosana, palauteteksti from palaute where id = ?";
		Object[] parametrit = new Object[] { id };
		RowMapper<Palaute> mapper = new PalauteRowMapper();

		Palaute p;
		try {
			p = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new exception(e);
		}
		return h;

	}*/

	public List<Palaute> haeKaikki() {

		String sql = "select palaute_id, arvosana, palauteteksti from palaute";
		RowMapper<Palaute> mapper = new PalauteRowMapper();
		List<Palaute> palautteet = jdbcTemplate.query(sql, mapper);

		return palautteet;
	}

	
	public List<Palaute> haeIdlla() {

		String sql = "SELECT i.koulutus_id, p.palaute_id, p.palauteteksti, p.arvosana FROM ilmoittautuminen i, "
				+ "palaute p WHERE p.palaute_id = i.palaute_id AND i.koulutus_id = 1;";
		RowMapper<Palaute> mapper = new PalauteRowMapper();
		List<Palaute> palautteet = jdbcTemplate.query(sql, mapper);

		return palautteet;
	}
}