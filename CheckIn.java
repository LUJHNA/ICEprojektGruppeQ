import java.util.Scanner;

public class CheckIn {

    public void checkIn(User currentUser) {
        System.out.println("Do you wish to Check in?" + "\n" +
                "1) Yes" + "\n" +
                "2) No");
        Scanner scanner = new Scanner(System.in);
        String w = scanner.nextLine();
        if (w.equals("1")) {
            if (currentUser.travelcard.getBalance() < 50) {
                System.out.println("You have insufficient funds to check in. You need at least 50kr on your card.");
            TravelStart.travel(currentUser);
            }


             else if (currentUser.travelcard.getBalance() > 50) {
                System.out.println("you've been checked in");
                currentUser.checkInState = true;
                Conductor conductor = new Conductor();
                conductor.conductorChance(currentUser);


            }
        }
        if (w.equals("2")) {
            System.out.println("You have chosen to become a crime rider by not checking in. You've been thrown out the vehicle");
            Conductor conductor = new Conductor();
            double y = conductor.conductorChance(currentUser);
            currentUser.travelcard.setBalance(y);
            double x = currentUser.travelcard.getBalance();
            System.out.println("New balance:" + currentUser.travelcard.getBalance() + " kr.");




        }
    }

}