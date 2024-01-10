package DesktopSwingApp.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.postgresql.ds.PGSimpleDataSource;

public class PostgresqlConnectionEngine extends JDBCconnectionEngine{
	/*
	 * private String driverTypeString = "jdbc"; private String databaseTypeString =
	 * "mysql"; private String hostString = "mn29.webd.pl"; private String
	 * portString = "3306"; private String databaseNameString = "mzdev_chat";
	 * private String userNameString = "mzdev_moderator"; private String
	 * userPasswordString = "stone11051996"; private String mysqlUrlForConnection =
	 * "jdbc:mysql://mn29.webd.pl:3306/mzdev_chat?user=mzdev_moderator&password=11051996";
	 */

	public PostgresqlConnectionEngine(String usernameString, String passwordString) {
		super(usernameString, passwordString);
		// TODO Auto-generated constructor stub
	}

	private String driverTypeString;
	private String databaseTypeString;
	private String hostString;
	private String portString;
	private String databaseNameString;
	private String userNameString;
	private String userPasswordString;
	//private String mysqlUrlForConnection = "jdbc:mysql://mn29.webd.pl:3306/mzdev_chat?user=mzdev_moderator&password=11051996";
	
	private String dbUrlForConnection;
	private PGSimpleDataSource dataSource;

	public void ConnectionEngine(String dbType,String user, String password){
		createUrlForConnection(dbType,user,password);
		createDataSource();
		checkConnectionToDB();
	}
	
	private void createUrlForConnection(String dbType,String user, String password){
		// dbType: mysql, postgresql
		// dbName: database name
		String host = "mn29.webd.pl";
		String port = "3306";
		String dbName = "mzdev_chat";
//		dbUrlForConnection = 	"jdbc:"+dbType+
//								"://"+host+
//								":"+port+
//								"/"+dbName+
//								"?user="+user+
//								"&password="+password;
		//dbUrlForConnection = "jdbc:postgesql://mn29.webd.pl:3306/mzdev_chat?user=mzdev_moderator&password=11051996";
		dbUrlForConnection = "jdbc:mysql://mn29.webd.pl:3306/mzdev_chat,mzdev_moderator&password=11051996";
	}

	private DataSource createDataSource() {
		//final String url = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=11051996";
		dataSource = new PGSimpleDataSource();
		dataSource.setUrl(dbUrlForConnection);
		return dataSource;
	}
	
	private void checkConnectionToDB(){
		try {
			dataSource.getConnection();
			System.out.println("SUCCED CONNECTION");
		} catch (Exception e) {
			System.out.println("Error, connection lost " + e);
		}
	}

	public void allData() throws SQLException {
		System.out.println("allData()");
		
		DataSource dataSource = createDataSource();
		Connection conn = dataSource.getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users");
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			System.out.printf("user_id:%d username:%s email:%s password_hash:%s group_id:%s%n", rs.getLong("user_id"),
					rs.getString("username"), rs.getString("email"),rs.getString("password_hash"),rs.getString("group_id"));
		}		
	}
	
	void specialQuery() throws SQLException{
		System.out.println("specialQuery METHOD");
		DataSource dataSource = createDataSource();
		Connection conn = dataSource.getConnection();
		String queryString = "SELECT * FROM users WHERE username LIKE CONCAT (?,'%')";
		//String queryString = "SELECT * FROM users WHERE username = ?";
		PreparedStatement stmt = conn.prepareStatement(queryString);
		stmt.setString(1, "m");
		// Execute the query and read the results same as before
		ResultSet rs = stmt.executeQuery();
		
//		if (rs.next() == false) {
//			System.out.println("Empty result");
//			return;
//		}else {
			System.out.println("Ok result");
			while (rs.next()) {
				System.out.println(rs.getLong("user_id") + "  " +rs.getString("username"));
			}
		//}
	}
	
	public void insertQuery() throws SQLException {
		System.out.println("insertQuery METHOD");

		DataSource dataSource = createDataSource();

		Connection conn = dataSource.getConnection();
				
		PreparedStatement insertStmt =
		        conn.prepareStatement("INSERT INTO customers(firstname, lastname, email, age) VALUES (?, ?, ?, ?)");

		// Set the query params
		insertStmt.setString(1, "Jonson");
		insertStmt.setString(2, "Long");
		insertStmt.setString(3, "jl@yahoo.pl");
		insertStmt.setInt(4, 50);

		// Run the insert query using the `executeUpdate` method.
		// This returns the number of inserted rows
		int insertedRows = insertStmt.executeUpdate();
		// Print out the number of inserted rows
		System.out.printf("inserted %s customer(s)%n", insertedRows);
	}

	@Override
	public void getDataForConnection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connectToDB() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}

