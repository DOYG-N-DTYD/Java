package com.testQuickStart.DesktopSwingApp.Database;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnectionEngine {
	private String mysqlJdbcDriverString = "com.mysql.cj.jdbc.Driver";
	private Connection mysqlConnection = null;
	private String mysqlUrlForConnection = "jdbc:mysql://mn29.webd.pl:3306/mzdev_chat?user=mzdev_moderator&password=11051996";

	public MysqlConnectionEngine() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(mysqlJdbcDriverString).getDeclaredConstructor().newInstance();
			mysqlConnection = DriverManager.getConnection("jdbc:mysql://mn29.webd.pl:3306/mzdev_chat",
					"mzdev_moderator", "stone11051996");
			System.out.println("Succes, MysqlConnection OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mysqlGetAllData() {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = mysqlConnection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM users");

			// or alternatively, if you don't know ahead of time that
			// the query will be a SELECT...

			if (stmt.execute("SELECT * FROM users")) {
				rs = stmt.getResultSet();
			}

			// Now do something with the ResultSet ....
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			// it is a good idea to release
			// resources in a finally{} block
			// in reverse-order of their creation
			// if they are no-longer needed

			if (rs != null) {
				try {
					System.out.println("RS not null");
					
					while (rs.next()) {
						// Now that `rs` points to a valid row (rs.next() is true), we can use the `getString`
						// and `getLong` methods to return each column value of the row as a string and long
						// respectively, and print it to the console
						System.out.println(rs.getString("id"));
						System.out.println(rs.getString("email"));
						System.out.println(rs.getString("name"));
						System.out.println(rs.getString("password"));
						//System.out.printf("id:%d email:%s name:%s password:%s,"
						//		+ rs.getLong("id"),rs.getString("email"),rs.getString("name"),rs.getString("password"));
					}
					
					rs.close();
				} catch (SQLException sqlEx) {
				} // ignore

				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				} // ignore

				stmt = null;
			}
		}
	}
}
