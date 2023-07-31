package mysqlDBconnector.DBconnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App
{
    public static void main( String[] args ) throws IOException
    {

    String sqlSelectAllPersons = "SELECT * FROM store";
    String connectionUrl = "jdbc:mysql://mn29.webd.pl:3306/mzdev_filmstore"; //?serverTimezone=UTC
    String username = "mzdev_moderator";
    String password = "stone11051996#A";
    System.out.println("Init data for credentials");
    try (Connection conn = DriverManager.getConnection(connectionUrl, username, password);
           PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
           ResultSet rs = ps.executeQuery()) {

           while (rs.next()) {
               //long id = rs.getLong("ID");
//                String name = rs.getString("name");
//                int year = rs.getInt("year");
//                int price = rs.getInt("price");

               //System.out.println("DATA " + "  NAME "+ name + " YEAR " + year +  " PRICE" + price);
            System.out.print(rs + "\n");
           }
    } catch (SQLException e) {
    System.out.println(e);
    }
    }
}