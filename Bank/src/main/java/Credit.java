import java.util.Date;

/**
 * Created by krzysztof on 16/03/2017.
 */
public class Credit implements IProduct {
    private Interest interest;
    protected String ownerId;
    protected double balance;
    protected double debit;
    protected String id;
    protected Date createdAt;

    public Credit(String ownerId, Interest interest, double amount){
        this.interest = interest;
        addCash(amount);
    }

    private double calculate(int numberOfMonths){
        return  this.balance - this.interest.interestCalculation(numberOfMonths, balance);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    public void addCash(double amount) {
        this.balance += amount;
    }

    public double getCash(double amount) throws RuntimeException {
        if(this.balance + this.debit >= amount){
            this.balance -= amount;
            return amount;
        }
        else{
            throw new RuntimeException("Cannot get cash from bank account.");
        }
    }

    public double close(int numberOfMonths) throws RuntimeException {
        if (this.balance >= 0) {
            return this.calculate(numberOfMonths);
        } else {
            throw new RuntimeException("Cannot close credit with negative balance");
        }

    }
}
