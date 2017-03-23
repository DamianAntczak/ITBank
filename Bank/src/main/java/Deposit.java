/**
 * Created by Damian on 16.03.2017.
 */
public class Deposit extends Product {
    private Interest interest;

    public Deposit(String ownerId, Interest interest, double amount){
        super(ownerId, "Lokata");
        this.interest = interest;
        addCash(amount);
    }

    private double calculate(int numberOfMonths){
        return  this.balance * this.interest.InterestCalculation(numberOfMonths);
    }

    @Override
    void addCash(double amount) {
        this.balance += amount;
    }

    @Override
    boolean getCash(double amount) {
        return false;
    }

    @Override
    double close(int numberOfMonths) {
        return this.calculate(numberOfMonths);
    }


}
