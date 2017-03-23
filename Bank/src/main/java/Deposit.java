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
    double getCash(double amount) {
        new RuntimeException("Cannot get cash from deposite. Only terminate");
        return 0;
    }

    @Override
    double close(int numberOfMonths) {
        double amount = this.calculate(numberOfMonths);
        this.balance = 0;
        return amount;
    }

    @Override
    boolean canClose() {
        if(this.balance > 0){
            return true;
        }
        else {
            return false;
        }
    }

    double terminate(){
        double amount = this.balance;
        this.balance = 0;
        return amount;
    }

}
