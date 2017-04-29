package Product;

import java.util.Date;

/**
 * Created by student on 10.03.2017.
 */
public class BankAccount implements IProduct {

    protected String ownerId;
    protected double balance;
    protected String id;
    protected Date createdAt;

    public BankAccount(String ownerId) {
        this.ownerId = ownerId;
        this.balance = 0;
        this.createdAt = new Date();
    }

    public void addCash(double amount) {
        this.balance += amount;
    }

    public double getCash(double amount) throws RuntimeException {
        if (this.balance >= amount) {
            this.balance -= amount;
            return amount;
        } else {
            throw new RuntimeException("Cannot get more cash than account balance");
        }
    }

    //Close the account
    public double close(int numberOfMonths) throws RuntimeException {
        if (this.balance >= 0) {
            double balance = this.balance;
            this.balance = 0;
            return balance;
        } else {
            throw new RuntimeException("Cannot close bank account with negative balance.");
        }
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
        return null;
    }
}
