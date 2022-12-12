public class User {
    String name;
    String password;
    TravelCard travelcard;
    boolean checkInState;

    public User(String name, String password, TravelCard travelcard, boolean checkInState) {
        this.name = name;
        this.password = password;
        this.travelcard = travelcard;
        this.checkInState = checkInState;
    }

    public User() {
    }

    @Override
    public String toString() {
        return name;
    }
}
