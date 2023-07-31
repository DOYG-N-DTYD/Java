package mysqlDBconnector.DBconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.spi.AbstractResourceBundleProvider;

import com.mysql.cj.exceptions.RSAException;

public class JDBCconnector {

	// TODO: username, pass -> encrypt -> send in database
	// TODO: check username and pass from entered data in console
	// TODO: phone number ? send sms, check last few digits
	// TODO: email -> send verification, password recovery
	// TODO: token email verification (only while registration)
	// TODO: use database from dropdown (maybe fron end + choise in drop down menu)
	private String userName;
	private String userPassword;
	private String urlConnection;
	private ResultSet resultSetAfterQueryExecution;

	public String getUserName() {
		System.out.println("USERNAME :" + userName);
		return userName;
	}

	private void setUserName(String userName) {
		System.out.println("NEW USERNAME SETTED :" + userName);
		this.userName = userName;
	}

	public String getUserPassword() {
		System.out.println("PASSWORD :" + userPassword);
		return userPassword;
	}

	private void setUserPassword(String userPassword) {
		System.out.println("NEW USER PASSWORD SETTED :" + userPassword);
		this.userPassword = userPassword;
	}

	public String getUrlConnection() {
		System.out.println("URL CONNECTION :" + urlConnection);
		return urlConnection;
	}

	private void setUrlConnection(String urlConnection) {
		System.out.println("NEW URL CONNECTION SETTED: " + urlConnection);
		this.urlConnection = urlConnection;
	}

	public ResultSet getResultSetAfterQueryExecution() {
		System.out.println("QUERY RESULT AFTER EXECUTION " + resultSetAfterQueryExecution);
		return resultSetAfterQueryExecution;
	}

	JDBCconnector() {
		this.userName = "mzdev_moderator";
		this.userPassword = "stone11051996#A";
		this.urlConnection = "jdbc:mysql://mn29.webd.pl:3306/mzdev_filmstore";
	}

	private JDBCconnector(String userName, String userPassword) {
		// TODO: Check credentials (regexp ?)
		this.userName = userName;
		this.userPassword = userPassword;
		this.urlConnection = "jdbc:mysql://mn29.webd.pl:3306/mzdev_filmstore";
	}

	public void showConnectorData() {
		System.out.println("USERNAME :" + userName + "\n" + "USERPASSWORD :" + userPassword + "\n" + " urlConnection :"
				+ urlConnection);
	}
	
	public void connectToDB() {
		try {
			Connection connection = DriverManager.getConnection(urlConnection, userName, userPassword);
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from film");
			this.resultSetAfterQueryExecution = resultSet;
			connection.close();
		} catch (Exception e) {
			System.out.println("ERROR: "+e);
		}
		System.out.println("END AFTER TRY OK !!!");
	}
	
	public void printResultSetData() {
		try {
			while (this.resultSetAfterQueryExecution.next()) {
				//System.out.println(this.resultSetAfterQueryExecution.getRowId(1)+ "  " +this.resultSetAfterQueryExecution.getRowId(1));
              String title = this.resultSetAfterQueryExecution.getString("title");
              int id = this.resultSetAfterQueryExecution.getInt("film_id");
              System.out.println(id +" " + title);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
}
