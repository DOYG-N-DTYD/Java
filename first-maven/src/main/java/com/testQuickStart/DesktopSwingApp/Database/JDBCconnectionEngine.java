package com.testQuickStart.DesktopSwingApp.Database;

public abstract class JDBCconnectionEngine extends Thread{
	private String driverTypeString;
	private String databaseTypeString;
	private String hostString;
	private String portString;
	private String databaseNameString;
	protected String userNameString;
	protected String userPasswordString;

	public JDBCconnectionEngine(String usernameString, String passwordString) {
		// TODO Auto-generated constructor stub
		this.userNameString = usernameString;
		this.userPasswordString = passwordString;
	}
	
	public String getUserName() { return userNameString;}
	public String getUserPassword() {return userPasswordString;}

	// Connection to DB
	protected abstract void getDataForConnection();

	protected abstract void connectToDB();

	// CRUD
	protected abstract void create();

	protected abstract void delete();

	protected abstract void read();

	protected abstract void update();
}
