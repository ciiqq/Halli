package fi.softala.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;

public class TietokantaTesti {
	
	private Connection jdbcConnection;
	private IDataSet testidata;
	
	public Connection haeJdbcConnection() throws Exception {
		this.jdbcConnection = DriverManager.getConnection(
			"jdbc:mariadb://localhost/team2", "projekti", "maXUGp62c");
		this.jdbcConnection.setAutoCommit(false);
		this.jdbcConnection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		return jdbcConnection;
	}
	
	public IDataSet haeTestidata() throws Exception {
		this.testidata = new FlatXmlDataSetBuilder()
		.build(new File("./src/test/resources/testidata.xml"));
		return testidata;
	}
}