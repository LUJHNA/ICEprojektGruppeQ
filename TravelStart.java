import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
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
                    System.out.println("Your current balance is " + currentUser.travelcard.getBalance() + " kr.");
                    travel(currentUser);

                   


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

    public static void travel(User currentUser) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1) Travel\n2) Change your balance");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            System.out.println("Choose 1) bus or 2) train");
            String transport = scanner.nextLine();

            if (transport.equals("1")) {
                System.out.println("You have bus, Line 40E is supported by this card");
                System.out.println("Choose a start destination");
                String startDestination = scanner.nextLine();
                System.out.println("Choose an end destination");
                String endDestination = scanner.nextLine();

                FileIO fileio = new FileIO();
                List y = fileio.makeRoute40E(startDestination, endDestination);
                System.out.println("Your route is: " + y);
                CheckIn checkin = new CheckIn();
                checkin.checkIn(currentUser, startDestination, endDestination);


            }

            if (transport.equals("2")) {




            }


        } else if (choice.equals("2")) {
            System.out.println("Enter how much you want to add");
            double m = scanner.nextDouble();
            currentUser.travelcard.addToBalance(m);
            System.out.println("You added " + m + " kr. ");
            travel(currentUser);
        }

        else {
            System.out.println("not valid input");
            travel(currentUser);
        }

    }
}








