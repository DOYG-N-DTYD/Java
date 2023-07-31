package mysqlDBconnector.DBconnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	JDBCconnector JDBCCOONNECTOR = new JDBCconnector();
    	JDBCCOONNECTOR.connectToDB();
    	JDBCCOONNECTOR.showConnectorData();
    	JDBCCOONNECTOR.getUserName();
    	JDBCCOONNECTOR.getUserPassword();
    	JDBCCOONNECTOR.getUrlConnection();
    	JDBCCOONNECTOR.printResultSetData();
    }
}