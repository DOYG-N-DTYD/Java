package com.testQuickStart.DesktopSwingApp.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnectionEngine extends JDBCconnectionEngine{

	private String driverTypeString = "jdbc";
	private String databaseTypeString = "mysql";
	private String hostString = "mn29.webd.pl";
	private String portString = "3306";
	private String databaseNameString = "mzdev_chat";
	// private String userNameString = "mzdev_moderator";
	// private String userPasswordString = "stone11051996";
	private String mysqlUrlForConnection = "jdbc:mysql://mn29.webd.pl:3306/mzdev_chat?user=mzdev_moderator&password=11051996";

	private Connection mysqlConnection = null;
	// private String mysqlUrlForConnection =
	// "jdbc:mysql://mn29.webd.pl:3306/mzdev_chat?user=mzdev_moderator&password=11051996";

	public MysqlConnectionEngine(String usernameString, String passwordString) {
		super(usernameString, passwordString);
		Runnable mysqlConnectionRunnable = () -> {
			connectToDB();
			mysqlGetAllData();
		};
		Thread mysqlConnectionThread = new Thread(mysqlConnectionRunnable);
		mysqlConnectionThread.start();
	}

	private String connectionUrl() {
		return driverTypeString + ":" + databaseTypeString + "://" + hostString + ":" + portString + "/"
				+ databaseNameString;
	}

	public void mysqlGetAllData() {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = mysqlConnection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM users");
			if (stmt.execute("SELECT * FROM users")) {
				rs = stmt.getResultSet();
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			if (rs != null) {
				try {
					while (rs.next()) {
						System.out.println(rs.getString("id"));
						System.out.println(rs.getString("email"));
						System.out.println(rs.getString("name"));
						System.out.println(rs.getString("password"));
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

	@Override
	protected void getDataForConnection() {
		// TODO Auto-generated method stub
		// super(usernameString,passwordString);
		// super.userPasswordString = passwordString;
	}

	@Override
	protected void connectToDB() {
		// TODO Auto-generated method stub
		try {
			// TODO loading screen
			// mysqlConnection =
			// DriverManager.getConnection("jdbc:mysql://mn29.webd.pl:3306/mzdev_chat","mzdev_moderator",
			// "stone11051996");
			System.out.println("connectionUrl() 		-> " + connectionUrl());
			System.out.println("super.getUserName()		-> " + super.getUserName());
			System.out.println("super.getUserPassword	-> " + super.getUserPassword());
			mysqlConnection = DriverManager.getConnection(connectionUrl(), super.getUserName(),
					super.getUserPassword());
			System.out.println("Succes, MysqlConnection OK");
			System.out.println("Thread stopped");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void create() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void delete() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void read() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub

	}
}
