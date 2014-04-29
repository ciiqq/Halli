package fi.softala.dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Miro Metsänheimo
 * @author ...
 *
 */
	
@Repository
public class KoulutusVahvistusDAOImpl implements KoulutusVahvistusDAO {

	@Inject
	private JdbcTemplate jt;

	public JdbcTemplate getJdbcTemplate() {
		return jt;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jt = jdbcTemplate;
	}

	public void VahvistaKoulutus(String[] vahvistettavat) {
		String sql = "";

		for (int i = 0; i < vahvistettavat.length; i++) {
			sql = "UPDATE koulutustilaisuus SET nakyvyys = 1 WHERE koulutus_id = "+vahvistettavat[i];
			jt.update(sql);
		}
	}

	public void VahvistaKaikkiKoulutukset() {
		String sql = "UPDATE koulutustilaisuus SET nakyvyys = 1";
		jt.update(sql);
	}
}
