import java.util.Date;

/**
 * Created by Damian on 16.03.2017.
 */
public class Deposit implements IProduct {
    private Interest interest;
    protected String ownerId;
    protected double balance;
    protected String id;
    protected Date createdAt;

    public Deposit(String ownerId, Interest interest, double amount) {
        this.interest = interest;
        this.ownerId = ownerId;
        this.createdAt = new Date();
    }

    private double calculate(int numberOfMonths) {
        return  interest.interestCalculation(numberOfMonths,this.balance);
    }

    public double close(int numberOfMonths) {
        if(numberOfMonths >= interest.interestFrequency.getValue()) {
            return this.calculate(numberOfMonths);
        }
        else
            return this.balance;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public Date getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public void addCash(double amount) {
        throw new RuntimeException("Cannot add cash to deposit. Only open new.");
    }

    @Override
    public double getCash(double amount) throws RuntimeException {
        throw new RuntimeException("Cannot get cash from deposit. Only close.");
    }
}
