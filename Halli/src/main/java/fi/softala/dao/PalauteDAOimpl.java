package fi.softala.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.softala.bean.Palaute;

@Repository
public class PalauteDAOimpl implements PalauteDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Tallettaa parametrina annetun henkil�n tietokantaan. Tietokannan
	 * generoima id asetetaan parametrina annettuun olioon.
	 */
	/*
	 * public void talleta(Palaute p) { final String sql =
	 * "insert into henkilo(etunimi, sukunimi) values(?,?)";
	 * 
	 * // anonyymi sis�luokka tarvitsee vakioina v�litett�v�t arvot, //
	 * jotta roskien keruu onnistuu t�m�n metodin suorituksen p��ttyess�.
	 * final int arvosana = p.getArvosana(); final String palauteteksti =
	 * p.getPalauteteksti();
	 * 
	 * // jdbc pist�� generoidun id:n t�nne talteen KeyHolder idHolder = new
	 * GeneratedKeyHolder();
	 * 
	 * // suoritetaan p�ivitys itse m��ritellyll�
	 * PreparedStatementCreatorilla // ja KeyHolderilla jdbcTemplate.update(new
	 * PreparedStatementCreator() { public PreparedStatement
	 * createPreparedStatement( Connection connection) throws SQLException {
	 * PreparedStatement ps = connection.prepareStatement(sql, new String[] {
	 * "palaute_id" }); ps.setInt(1, arvosana); ps.setString(2, palauteteksti);
	 * return ps; } }, idHolder);
	 * 
	 * // tallennetaan id takaisin beaniin, koska // kutsujalla pit�isi olla
	 * viittaus samaiseen olioon p.setId(idHolder.getKey().intValue());
	 * 
	 * }
	 */
	/*
	 * public Palaute etsi(int id) { String sql =
	 * "select id, arvosana, palauteteksti from palaute where id = ?"; Object[]
	 * parametrit = new Object[] { id }; RowMapper<Palaute> mapper = new
	 * PalauteRowMapper();
	 * 
	 * Palaute p; try { p = jdbcTemplate.queryForObject(sql, parametrit,
	 * mapper); } catch (IncorrectResultSizeDataAccessException e) { throw new
	 * exception(e); } return h;
	 * 
	 * }
	 */

	public List<Palaute> haeKaikki() {

		String sql = "select palaute_id, arvosana, palauteteksti from palaute";
		RowMapper<Palaute> mapper = new PalauteRowMapper();
		List<Palaute> palautteet = jdbcTemplate.query(sql, mapper);

		return palautteet;
	}

	public List<Palaute> haeIdlla() {	

		String sql = "SELECT i.koulutus_id, p.palaute_id, p.palauteteksti, p.arvosana FROM ilmoittautuminen i "
				+ "JOIN palaute p ON p.palaute_id = i.palaute_id WHERE i.koulutus_id = 3;";
		RowMapper<Palaute> mapper = new PalauteRowMapper();
		List<Palaute> palautteet = jdbcTemplate.query(sql, mapper);

		return palautteet;
	}

	public List<Palaute> haeKaikkiPalautteet() {

		String sql = "select * from palaute";
		RowMapper<Palaute> mapper = new PalauteRowMapper();
		List<Palaute> palautteet = jdbcTemplate.query(sql, mapper);

		return palautteet;
	}
	
	public List<Palaute> haeKouluttajaIdlla() {

		String sql = "SELECT kk.kouluttajatunnus, i.koulutus_id, p.palaute_id, p.palauteteksti, p.arvosana, kk.koulutus_id FROM ilmoittautuminen i JOIN koulutuksenkouluttaja kk ON i.koulutus_id = kk.koulutus_id"
				+ " JOIN palaute p ON i.palaute_id = p.palaute_id " + " WHERE kk.kouluttajatunnus = 3335556;";
		RowMapper<Palaute> mapper = new PalauteRowMapper();
		List<Palaute> palautteet = jdbcTemplate.query(sql, mapper);

		return palautteet;
	}}

