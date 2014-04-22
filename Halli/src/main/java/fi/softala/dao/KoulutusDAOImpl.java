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
import fi.softala.bean.Koulutustilaisuus;


@Repository
public class KoulutusDAOImpl implements KoulutusDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void tallennaVaraus(Koulutustilaisuus koulutus) {
		
	}

	public Koulutustilaisuus etsi(int id) {
		return null;
	}

	public List<Koulutustilaisuus> haeKaikki() {
		return null;
	}

	public void tallennaKoulussuunnitelma(Koulutustilaisuus koulutustilaisuus) { //TODO Testaamatta!
		final String sql = "insert into koulutustilaisuus(aihe, kuvaus, lahtotaso, nakyvyys, oppimistavoitteet, oppimismenetelmat) values(?,?,?,?,?,?)";

		// anonyymi sisäluokka tarvitsee vakioina välitettävät arvot,
		// jotta roskien keruu onnistuu tämän metodin suorituksen päättyessä.
		final String aihe = koulutustilaisuus.getAihe();
		final String kuvaus = koulutustilaisuus.getKuvaus();
		final String lahtotaso = koulutustilaisuus.getLahtotaso();
		final boolean nakyvyys = false;
		final String oppimistavoitteet = koulutustilaisuus.getOppimistavoitteet();
		final String oppimismentetelmat = koulutustilaisuus.getOppimismenetelmat();

		// jdbc pistää generoidun id:n tänne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();

		// suoritetaan päivitys itse määritellyllä PreparedStatementCreatorilla
		// ja KeyHolderilla
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				ps.setString(1, aihe);
				ps.setString(2, kuvaus);
				ps.setString(3, lahtotaso);
				ps.setBoolean(4, nakyvyys);
				ps.setString(5, oppimistavoitteet);
				ps.setString(6, oppimismentetelmat);
				return ps;
			}
		}, idHolder);

		// tallennetaan id takaisin beaniin, koska
		// kutsujalla pitäisi olla viittaus samaiseen olioon
		koulutustilaisuus.setId(idHolder.getKey().intValue());
	}
	
	


}
