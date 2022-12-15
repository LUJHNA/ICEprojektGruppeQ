public class User {
    String name;
    String password;
    TravelCard travelcard;
    boolean checkInState;

    String transportChoice;

    public User(String name, String password, TravelCard travelcard, boolean checkInState, String transportChoice) {
        this.name = name;
        this.password = password;
        this.travelcard = travelcard;
        this.checkInState = checkInState;
        this.transportChoice = transportChoice;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TravelCard getTravelcard() {
        return travelcard;
    }

    public void setTravelcard(TravelCard travelcard) {
        this.travelcard = travelcard;
    }

    public boolean isCheckInState() {
        return checkInState;
    }

    public void setCheckInState(boolean checkInState) {
        this.checkInState = checkInState;
    }

    public String getTransportChoice() {
        return transportChoice;
    }

    public void setTransportChoice(String transportChoice) {
        this.transportChoice = transportChoice;
    }

    @Override
    public String toString() {
        return "name: " + name + ", Balance: " + travelcard.getBalance() + " kr.";
    }
}
