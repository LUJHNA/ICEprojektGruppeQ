import java.sql.SQLOutput;
import java.util.Random;

public class Conductor {


    public double conductorChance(User us) {
        Random chance = new Random();
        int conductorChance = chance.nextInt(1); //1/6 chance for Conductor to enter.

        if (!us.checkInState && conductorChance == 0) {
            System.out.println("You've been caught crime riding!(Traveling without TravelCard)");
            System.out.println("You've received a fine of 750KR.");
            int fine = 750;
            return us.travelcard.getBalance() - fine;
        } else if (us.checkInState && conductorChance == 0) {
            System.out.println("A conductor enters and checks your ticket. All is okay");
        }

        return us.travelcard.getBalance();
    }
}
