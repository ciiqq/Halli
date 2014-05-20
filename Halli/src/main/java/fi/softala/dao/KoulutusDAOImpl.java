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

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fi.softala.bean.Aikatauluslotti;
import fi.softala.bean.Avainsana;
import fi.softala.bean.Henkilo;
	


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

	public void tallennaKoulussuunnitelma(Koulutustilaisuus koulutustilaisuus) {
		final String sql = "insert into koulutustilaisuus(aihe, kuvaus, lahtotaso, nakyvyys, koulutusmenetelmat) values(?,?,?,?,?)";

		// anonyymi sisäluokka tarvitsee vakioina välitettävät arvot,
		// jotta roskien keruu onnistuu tämän metodin suorituksen päättyessä.
		final String aihe = koulutustilaisuus.getAihe();
		final String kuvaus = koulutustilaisuus.getKuvaus();
		final String lahtotaso = koulutustilaisuus.getLahtotaso();
		final boolean nakyvyys = koulutustilaisuus.getNakyvyys();
		final String koulutusmentetelmat = koulutustilaisuus.getKoulutusmenetelmat();

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
				ps.setString(5, koulutusmentetelmat);
				return ps;
			}
		}, idHolder);

		// tallennetaan id takaisin beaniin, koska
		// kutsujalla pitäisi olla viittaus samaiseen olioon
		koulutustilaisuus.setId(idHolder.getKey().intValue());
	}
	
	public void tallennaAvainsana(final String avainsana, final int koulutustilaisuusId) {
		final String sqlLisaaSana = "insert into avainsana(avainsana) values (?);";
		final String sqlLiitaSanaKoulutukseen = "insert into koulutuksenavainsana(avainsana_id, koulutus_id) values (?,?)";
		
		final String sana = avainsana;
		

		KeyHolder idHolder = new GeneratedKeyHolder();
		
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sqlLisaaSana,
						new String[] { "id" });
				ps.setString(1, sana);
				return ps;
			}
		}, idHolder);
		
		
		
		if (idHolder.getKey() != null) {
			final int sanaId = idHolder.getKey().intValue();
			jdbcTemplate.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(
						Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(sqlLiitaSanaKoulutukseen);
					ps.setInt(1, sanaId);
					ps.setInt(2, koulutustilaisuusId);
					return ps;
				}
			});						
		}
		
		
		
	}
	
	public void tallennaKoulutuksenKouluttaja(int koulutusId, String opiskelijanumero) {
		
		final String sql = "insert into koulutuksentoimija(henkilotunnus, koulutus_id) values (?,?)";
		
		final int koulutus = koulutusId;
		final String opno = opiskelijanumero;
		
KeyHolder idHolder = new GeneratedKeyHolder();
		
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				ps.setString(1, opno);
				ps.setInt(2, koulutus);
				return ps;
			}
		}, idHolder);
		
	}
	


	public List<Koulutustilaisuus> haeKoulutukset(boolean julkaistu) {
		String sql = "SELECT kt.koulutus_id, asl.aika_id, asl.pvm, asl.alkukello, asl.loppukello, asl.koulutustila, kt.aihe, kt.kuvaus, kt.lahtotaso, kt.nakyvyys FROM koulutustilaisuus kt JOIN aikatauluslotti asl ON " +
							"asl.koulutus_id = kt.koulutus_id AND ";
		
		if(julkaistu){
			sql =  sql + "nakyvyys = 1";
		}else{
			sql =  sql + "nakyvyys = 0";
		}
		
		sql = sql + " ORDER BY asl.pvm";
		
		RowMapper<Koulutustilaisuus> rm = new KoulutusRowMapper();
		
		List<Koulutustilaisuus> koulutuslista = jdbcTemplate.query(sql, rm);
		
		return koulutuslista;
	}
	
	public Koulutustilaisuus haeKoulutus(int id) {
		final String sql = "SELECT kt.koulutus_id, asl.aika_id, asl.pvm, asl.alkukello, asl.loppukello, asl.koulutustila, kt.aihe, kt.kuvaus, kt.lahtotaso, kt.nakyvyys FROM koulutustilaisuus kt JOIN aikatauluslotti asl ON " +
				"asl.koulutus_id = kt.koulutus_id WHERE kt.koulutus_id = ?;";
		Object[] parametrit = new Object[] { id };
		
		RowMapper<Koulutustilaisuus> rm = new KoulutusRowMapper();
		
		Koulutustilaisuus koulutus = jdbcTemplate.queryForObject(sql, parametrit, rm);
		
		return koulutus;
	}



	public void paivitaKoulutus(Koulutustilaisuus kt) {
		final String sql = "UPDATE aikatauluslotti asl"
						+ " INNER JOIN koulutustilaisuus kt ON asl.koulutus_id = kt.koulutus_id SET kt.aihe = ?, kt.kuvaus = ?, kt.lahtotaso = ?"
						+ " WHERE kt.koulutus_id = ?;";
		
//		Muutetaan takaisin SQL-muotoon
//		String asConvert = kt.getAikaslotti().getPvm().replace(".", "-");
//		String[] suomiPvm = asConvert.split("-");
//		kt.getAikaslotti().setPvm(suomiPvm[2] + "-" + suomiPvm[1] + "-" + suomiPvm[0]);	
		
		Object[] parametrit = new Object[] { kt.getAihe(), kt.getKuvaus(), kt.getLahtotaso(), kt.getId()};
		
		jdbcTemplate.update(sql, parametrit);
		
	}



	public void peruutaKoulutus(int id) {
		final String sql = "UPDATE aikatauluslotti asl"
						+ " INNER JOIN koulutustilaisuus kt ON asl.koulutus_id = kt.koulutus_id"
						+ " SET asl.koulutus_id = null"
						+ " WHERE asl.koulutus_id = ?;";
		
		Object[] parametrit = new Object[] {id};
		jdbcTemplate.update(sql, parametrit);
		
		
	}
	
//	Koulutuksen siirto toiseen aikatauluslottiin
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.SERIALIZABLE, readOnly=false)
	public void siirraKoulutus(int koulutusId, int aikaId) {
		
		final String sql = "UPDATE aikatauluslotti asl"
				+ " INNER JOIN koulutustilaisuus kt ON asl.koulutus_id = kt.koulutus_id"
				+ " SET asl.koulutus_id = null"
				+ " WHERE asl.koulutus_id = ?;";

		Object[] parametrit = new Object[] {koulutusId};
		jdbcTemplate.update(sql, parametrit);
		
		
		final String sql2 = "UPDATE aikatauluslotti asl"
						+ " SET asl.koulutus_id = ?"
						+ " WHERE asl.aika_id = ?;";
		
		Object[] parametrit2 = new Object[] {koulutusId, aikaId};
		
		jdbcTemplate.update(sql2, parametrit2);
				
		

	}



	public List<Henkilo> haeHenkilot(int id, String rooli) {
		String sql = "SELECT h.etunimi, h.sukunimi FROM koulutustilaisuus kt JOIN koulutuksentoimija kk ON kt.koulutus_id = kk.koulutus_id " +
							"JOIN henkilo h ON kk.henkilotunnus = h.henkilotunnus WHERE kt.koulutus_id = ? AND h.rooli = ";
		if(rooli.equals("kouluttaja")){
			sql = sql + " 'kouluttaja';";
		}else if(rooli.equals("opettaja")){
			sql = sql + " 'opettaja';";
		}
		
		Object[] parametrit = new Object[] { id };
		
		RowMapper<Henkilo> rm = new HenkiloRowMapper();
		
		List<Henkilo> henkilot = jdbcTemplate.query(sql, parametrit, rm);
		
		return henkilot;
	}



	public List<Avainsana> haeAvainsanat(int id) {
		final String sql = "SELECT a.avainsana_id, a.avainsana FROM koulutustilaisuus kt JOIN koulutuksenavainsana ka ON kt.koulutus_id = ka.koulutus_id " + 
							"JOIN avainsana a ON ka.avainsana_id = a.avainsana_id WHERE kt.koulutus_id = ?;";
		Object[] parametrit = new Object[] { id };
		
		RowMapper<Avainsana> rm = new AvainsanaRowMapper();
		
		List<Avainsana> avainsanat = jdbcTemplate.query(sql, parametrit, rm);
		
		return avainsanat;
	}



	public void julkaiseKoulutus(int id) {
		final String sql = "UPDATE koulutustilaisuus SET nakyvyys = 1 WHERE koulutus_id = ?";
		
		Object[] parametrit = new Object[] { id };

		jdbcTemplate.update(sql, parametrit);
		
	}
	
	public List<Aikatauluslotti> haeVapaatSlotit(){
		final String sql = "SELECT aika_id, pvm, alkukello, loppukello, koulutustila FROM aikatauluslotti WHERE koulutus_id IS NULL;";
		
		RowMapper<Aikatauluslotti> rm = new AikatauluslottiRowMapper();
		
		List<Aikatauluslotti> slotit = jdbcTemplate.query(sql, rm);
				
		return slotit;
	}

}
