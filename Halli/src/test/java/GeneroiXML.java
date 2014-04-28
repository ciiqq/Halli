

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.DatabaseSequenceFilter;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.FilteredDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.filter.ITableFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;

public class GeneroiXML {

	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException, DatabaseUnitException {
		Connection jdbcConnection = DriverManager.getConnection
		("jdbc:mariadb://localhost/team4", "projekti", "maXUGp62c");
		IDatabaseConnection dbConnection = new DatabaseConnection(jdbcConnection);

		ITableFilter filter = new DatabaseSequenceFilter(dbConnection);
		IDataSet dataset = new FilteredDataSet(filter, dbConnection.createDataSet());
		       
		FlatXmlDataSet.write(dataset, new FileOutputStream("./src/test/resources/testidata.xml"));
	}
}