import java.sql.*;
import java.util.ArrayList;


public class TransportDB {

    Connection connection;

    String url = "jdbc:mysql://localhost/transport?" + "autoReconnect=true&useSSL=false";
    String userName = "root";
    String password = "1234morten";

    public void establishConnection() {

        try {
            connection = DriverManager.getConnection(url, userName, password);


        } catch (SQLException e) {
            e.printStackTrace();


        }
    }

   public double findBalanceinDB(String userName2, String password2) {
    establishConnection();
    double balance;


    String query = "SELECT userName, balance FROM Usernames WHERE userName = ? AND password = ?";
        try {
        PreparedStatement query2 = connection.prepareStatement(query);
            query2.setString(1, userName2);
            query2.setString(2, password2);

        ResultSet resultSet = query2.executeQuery();
       if (resultSet.next())
           return balance = resultSet.getDouble("balance");





    } catch(
    SQLException e)

    {
        e.printStackTrace();
    }


  return -1;

}

public void updateBalance(User currentUser) {
        establishConnection();
        String query = "UPDATE Usernames SET balance = ? WHERE username = ? AND password = ?";

       try {
           PreparedStatement query2 = connection.prepareStatement(query);
           query2.setDouble(1, currentUser.getTravelcard().getBalance());
           query2.setString(2, currentUser.getName());
           query2.setString(3, currentUser.getPassword());
           query2.execute();
       } catch (SQLException e) {
           e.printStackTrace();

       }

 }



}
