package fi.softala.koulutuslistaus;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fi.softala.bean.Aikatauluslotti;
import fi.softala.dao.KoulutusDAO;
import fi.softala.dao.KoulutusRowMapper;

public class KoulutuslistausTest {
	
	@Inject
	private KoulutusDAO dao;
	
	public KoulutusDAO getDao() {
		return dao;
	}

	public void setDao(KoulutusDAO dao) {
		this.dao = dao;
	}

	@Test
	public void koulutusListausTest(){

		//List<Aikatauluslotti> koulutuslista = dao.haeKoulutukset();
		
		List<Aikatauluslotti> testilista = new ArrayList<Aikatauluslotti>();
		
		String lol = "moi";
		
		assertNotNull(lol);
	}
	
	
	@Test
	public void testaaKoulutustenHaku(){
		KoulutusDAO test = new MockKoulutus();
		Aikatauluslotti koulutusTest = test.haeKoulutus(1);
		assertNotNull(koulutusTest);
		
		
	}

}
