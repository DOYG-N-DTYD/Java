package com.testQuickStart.DesktopSwingApp.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;

public class DBengine {
	
	private static DataSource createDataSource() {
		// The url specifies the address of our database along with username and password credentials
		// you should replace these with your own username and password
		final String url =
				"jdbc:postgresql://localhost:5432/postgres?user=postgres&password=11051996";
		//System.out.println("URL setted");
		final PGSimpleDataSource dataSource = new PGSimpleDataSource();
		//System.out.println("NEW DATA_SOURCE created");
		dataSource.setUrl(url);
		//System.out.println("DATA SOURCE URL SETTED");
	return dataSource;
	}
	
	void allData() throws SQLException {
		System.out.println("All DATA METHOD");
		// Use the method we defined earlier to create a datasource
		DataSource dataSource = createDataSource();

		// get a connection from the datasource
		Connection conn = dataSource.getConnection();

		// Create a new statement on the connection
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users");

		// Execute the query, and store the results in the ResultSet instance
		ResultSet rs = stmt.executeQuery();

		// We run a loop to process the results.
		// The rs.next() method moves the result pointer to the next result row, and returns
		// true if a row is present, and false otherwise
		// Note that initially the result pointer points before the first row, so we have to call
		// rs.next() the first time
		while (rs.next()) {
			// Now that `rs` points to a valid row (rs.next() is true), we can use the `getString`
			// and `getLong` methods to return each column value of the row as a string and long
			// respectively, and print it to the console
			System.out.printf("user_id:%d username:%s email:%s password_hash:%s group_id:%s%n", rs.getLong("user_id"),
					rs.getString("username"), rs.getString("email"),rs.getString("password_hash"),rs.getString("group_id"));
		}
		
		
	}
	
	void specialQuery() throws SQLException{
		System.out.println("specialQuery METHOD");
		// Use the method we defined earlier to create a datasource
		DataSource dataSource = createDataSource();

		// get a connection from the datasource
		Connection conn = dataSource.getConnection();

		// Create a new statement on the connection
		// Create a prepared statement with a query param denoted by "?"
	
		String queryString = "SELECT * FROM users WHERE username LIKE CONCAT (?,'%')";
		//String queryString = "SELECT * FROM users WHERE username = ?";
		PreparedStatement stmt = conn.prepareStatement(queryString);
		// Set the value of the param. Param indexes begin from 1
		// Since we want to set the value as a string, we use `setString`
		// with the param index and param value as arguments
		
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
		// Use the method we defined earlier to create a datasource
		DataSource dataSource = createDataSource();
		// Create a new insert statement with the bird and description values as query params
		// get a connection from the datasource
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
}
