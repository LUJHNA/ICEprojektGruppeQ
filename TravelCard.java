public class TravelCard {
    private double balance;

    public TravelCard(double balance) {
        this.balance = balance;
    }


    public void addToBalance(double money) {
        setBalance(balance + money);
    }

    public void subtractFromBalance(double cost) {
        setBalance(balance - cost);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
