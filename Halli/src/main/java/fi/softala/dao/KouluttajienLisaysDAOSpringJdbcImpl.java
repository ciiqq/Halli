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

import fi.softala.bean.Kouluttaja;
import fi.softala.funktiot.FormatoiNimi;


@Repository
public class KouluttajienLisaysDAOSpringJdbcImpl implements KouluttajienLisaysDAO{
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	public List<Kouluttaja> kouluttajienHaku(){
		String sql = "select * from henkilo WHERE rooli = 'kouluttaja' ORDER BY sukunimi ASC, etunimi ASC";
		
		RowMapper<Kouluttaja> mapper = new KouluttajienLisaysRowMapper();
		
		List<Kouluttaja> kouluttajat = jdbcTemplate.query(sql,mapper);
		
		return kouluttajat;
	}
	
	public Kouluttaja kouluttajanHaku(String opiskelijanro) {
		String sql = "select * from henkilo where rooli = 'kouluttaja' AND henkilotunnus = ? ";
		
		Object[] parametrit = new Object[] { opiskelijanro };
		RowMapper<Kouluttaja> mapper = new KouluttajienLisaysRowMapper();

		Kouluttaja k;
		try {
			k = jdbcTemplate.queryForObject(sql, parametrit, mapper);
			System.out.println(k);
			System.out.println("Löyty");
		} catch (IncorrectResultSizeDataAccessException e) {
			k = null;
		}

		return k;
	}

	public void kouluttajanLisays(Kouluttaja k) {
		final String sql = "insert into henkilo(henkilotunnus, rooli, etunimi, sukunimi, salasana, suola) values(?,?,?,?,?,?)";
		
		//helpottaa editoimista
		final String opiskelijanro = k.getOpiskelijanro();
		final String rooli = "kouluttaja";
		final String etunimi = FormatoiNimi.isoAlkukirjain(k.getEtunimi());
		final String sukunimi = FormatoiNimi.isoAlkukirjain(k.getSukunimi());
		final String salasana = k.getSalasana();
		final String suola = "suola!";
		
		Object[] parametrit = new Object[] {opiskelijanro,rooli,etunimi,sukunimi,salasana,suola};
		
		jdbcTemplate.update(sql , parametrit);
				
				
	}
	
}
