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

import fi.softala.bean.Kouluttaja;


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
		String sql = "select * from kouluttaja ORDER BY sukunimi ASC, etunimi ASC";
		
		RowMapper<Kouluttaja> mapper = new KouluttajienLisaysRowMapper();
		
		List<Kouluttaja> kouluttajat = jdbcTemplate.query(sql,mapper);
		
		return kouluttajat;
	}
	
	public Kouluttaja kouluttajanHaku(String opiskelijanro) {
		String sql = "select * from kouluttaja where opiskelijanro = ?";
		
		Object[] parametrit = new Object[] { opiskelijanro };
		RowMapper<Kouluttaja> mapper = new KouluttajienLisaysRowMapper();

		Kouluttaja k;
		try {
			k = jdbcTemplate.queryForObject(sql, parametrit, mapper);
			System.out.println(k);
			System.out.println("Lˆyty");
		} catch (IncorrectResultSizeDataAccessException e) {
			k = null;
		}

		return k;
	}

	public void kouluttajanLisays(Kouluttaja k) {
		final String sql = "insert into kouluttaja(opiskelijanro, etunimi, sukunimi, salasana, suola) values(?,?,?,?,?)";

		// anonyymi sis‰luokka tarvitsee vakioina v‰litett‰v‰t arvot,
		// jotta roskien keruu onnistuu t‰m‰n metodin suorituksen p‰‰ttyess‰.
		final int opiskelijanro = Integer.parseInt(k.getOpiskelijanro());
		final String etunimi = k.getEtunimi();
		final String sukunimi = k.getSukunimi();
		final String salasana = k.getSalasana();
		final String suola = "suola!";
		
		
		//jdbc pist‰‰ generoidun id:n t‰nne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();
			    
		//suoritetaan p‰ivitys itse m‰‰ritellyll‰ PreparedStatementCreatorilla ja KeyHolderilla
		jdbcTemplate.update(
    	    new PreparedStatementCreator() {
    	        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
    	            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
    	            ps.setInt(1, opiskelijanro);
    	            ps.setString(2, etunimi);
    	            ps.setString(3, sukunimi);
    	            ps.setString(4, salasana);
    	            ps.setString(5, suola);
    	            return ps;
    	        }
    	    }, idHolder);
				
				
	}
	
}
