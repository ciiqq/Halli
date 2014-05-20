package fi.softala.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.bean.Osallistuja;

public class OsallistujaRowMapper implements RowMapper<Osallistuja> {

    public Osallistuja mapRow(ResultSet rs, int rowNum) throws SQLException {

    Osallistuja o = new Osallistuja();
    o.setOpiskelijanro(rs.getString("opiskelijanumero"));
    String etunimi = rs.getString("etunimi");
    String sukunimi = rs.getString("sukunimi");
    
    o.setEtunimi(etunimi);
    o.setSukunimi(sukunimi);
    o.setSahkoposti(etunimi, sukunimi);
    o.setId(rs.getInt("id"));
    return o;
    }

}
