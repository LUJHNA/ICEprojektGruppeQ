import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TravelStart {

    public static void main(String[] args) {
       
        User currentUser = new User();
        loginAndRegister(currentUser);


    }

    public static void loginAndRegister(User currentUser) {
        Scanner login = new Scanner(System.in);
        System.out.println("Enter corresponding number for:\n1) Login\n2) Register");
        String loginInfo = login.nextLine();

        if (loginInfo.equals("1")) {

            TransportDB tDB = new TransportDB();
            System.out.println("Enter User name");
            String userName2 = login.nextLine();

            System.out.println("Enter password");
            String password2 = login.nextLine();
            tDB.establishConnection();

            String query3 = "SELECT * FROM usernames WHERE userName = ? AND password = ?";

            try {

                PreparedStatement query2 = tDB.connection.prepareStatement(query3);
                query2.setString(1, userName2);
                query2.setString(2, password2);
                ResultSet resultSet = query2.executeQuery();

                if (resultSet.next()) {
                    System.out.println("Login successful");
                    double balance = tDB.findBalanceinDB(userName2, password2);

                    currentUser = new User(userName2, password2, new TravelCard(balance), false);
                    System.out.println("your current Balance is " + currentUser.travelcard.getBalance() + " kr.");




                } else if (!resultSet.next()) {
                    System.out.println("login not successful, restart the program");


                }


            } catch (SQLException e) {
                e.printStackTrace();


            }

        } else if (loginInfo.equals("2")) {


            System.out.println("Enter new User Name");
            String userName = login.nextLine();
            System.out.println("Enter new password");
            String password = login.nextLine();
            System.out.println("Enter your starting balance");
            double balance = login.nextDouble();
            TransportDB transportDB = new TransportDB();
            transportDB.establishConnection();

            String query = "INSERT INTO usernames (username, password, balance) VALUES (?,?,?)";
            try {
                PreparedStatement query2 = transportDB.connection.prepareStatement(query);
                query2.setString(1, userName);
                query2.setString(2, password);
                query2.setDouble(3, balance);
                query2.execute();
                loginAndRegister(currentUser);

            } catch (SQLException e) {
                e.printStackTrace();

            }

        } else {
            System.out.println("not valid input");
            loginAndRegister(currentUser);

        }

    }

}








