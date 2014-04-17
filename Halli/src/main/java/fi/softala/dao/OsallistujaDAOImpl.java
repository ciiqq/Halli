package fi.softala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.softala.bean.Osallistuja;

@Repository
public class OsallistujaDAOImpl implements OsallistujaDAO {
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void talleta(Osallistuja o) {
		final String sql = "insert into osallistuja(osallistujan_opiskelijanro, etunimi, sukunimi) values(?,?,?)";

		final String osallistujan_opiskelijanro = o.getOpiskelijanro();
		final String etunimi = o.getEtunimi();
		final String sukunimi = o.getSukunimi();

		//Keyholderi tietokannan ID:seen.
		KeyHolder idHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(
		    	    new PreparedStatementCreator() {
		    	        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		    	            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
		    	            ps.setString(1, osallistujan_opiskelijanro);
		    	            ps.setString(2, etunimi);
		    	            ps.setString(3, sukunimi);
		    	            return ps;
		    	        }
		    	    }, idHolder);

		o.setId(idHolder.getKey().intValue());

	}

}
