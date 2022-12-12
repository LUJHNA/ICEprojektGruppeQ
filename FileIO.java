import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {

    public void loginAndRegister2() {
        System.out.println("Enter corresponding number for:\n1) Login\n2) Register\n3) Travel");
        Scanner scanner = new Scanner(System.in);
        File file = new File("UserNames");
        String k = scanner.nextLine();

        if (k.equals("2")) {

            System.out.println("Enter new username");
            String username = scanner.nextLine();

            System.out.println("Enter new password");
            String password = scanner.nextLine();



            try {
                FileWriter filewriter = new FileWriter(file, true);
                filewriter.write("\r\n");
                filewriter.write(username);
                filewriter.write(",");
                filewriter.write(password);
                filewriter.close();
                loginAndRegister2();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }


        else if (k.equals("1")) {


            System.out.println("Enter your username");
            String username = scanner.nextLine();

            System.out.println("Enter your password");
            String password = scanner.nextLine();

            try {
                Scanner reader = new Scanner(file);
                while (reader.hasNextLine()) {
                    String s = reader.nextLine();
                    String [] m = s.trim().split(",");



                    for (int i = 0; i < m.length- 1 ; i++) {

                        if (m[i].equals(username) && m[i + 1].equals(password)) {
                            System.out.println("login successful");

                        } else {
                            



                        }

                    }

                }
                reader.close();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }


        }



    }




    public List<String> makeRoute(String startDestination, String endDestination) {
        File file = new File("40E");
        ArrayList<String> route = new ArrayList<>();
        List<String> finalRoute = new ArrayList<>();
        String [] routeHelper;
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {

                routeHelper = scanner.nextLine().trim().split(",");
                route.add(routeHelper[0]);

                for (int i = 0; i < route.size(); i++) {
                    for (int j = 0; j < route.size(); j++) {
                        if (startDestination.equalsIgnoreCase(route.get(i)) && endDestination.equalsIgnoreCase(route.get(j))) {

                            finalRoute = route.subList(i, j + 1);

                        }


                    }

                }


            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return finalRoute;
    }

}
