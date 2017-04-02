/**
 * Created by Damian on 16.03.2017.
 */
public class Deposit extends Product {
    private Interest interest;

    public Deposit(String ownerId, Interest interest, double amount) {
        super(ownerId, "Deposit");
        this.interest = interest;
        this.balance = amount;
    }

    private double calculate(int numberOfMonths) {
        return  this.balance * this.interest.InterestCalculation(numberOfMonths);
    }

    @Override
    double close(int numberOfMonths) {
        double amount = this.calculate(numberOfMonths);
        this.balance = 0;
        return amount;
    }

    double terminate() {
        double amount = this.balance;
        this.balance = 0;
        return amount;
    }
}
