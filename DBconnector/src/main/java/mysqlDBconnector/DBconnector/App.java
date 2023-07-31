package mysqlDBconnector.DBconnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println("START OK");
        try{
        // Class.forName("com.mysql.jdbc.Driver");  
        //Class.forName("oracle.jdbc.driver.OracleDriver");  
        String userName = "mzdev_moderator";
        String userPassword = "stone11051996#A";
        String connectionURL = "jdbc:mysql://mn29.webd.pl:3306/mzdev_filmstore";
        Connection connection=DriverManager.getConnection(connectionURL,userName,userPassword);  
        System.out.println("CONNECTION OK !!!");
        Statement stmt=connection.createStatement();  
        ResultSet resultSet=stmt.executeQuery("select * from staff");  
        int counter = 0;
        while(resultSet.next()) {
            try {
                
                while (true) {
                    System.out.println(resultSet.getString(13));
                    counter++;
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
            
         }
        System.out.println("CONNECTION CLOSED OK");     
        connection.close();  
         }catch(Exception e){ System.out.println(e);}  
        System.out.println("END AFTER TRY OK !!!");
    }
}