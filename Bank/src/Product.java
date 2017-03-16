import java.util.Date;
import java.util.UUID;

/**
 * Created by student on 10.03.2017.
 */
public abstract class Product {

    public enum ProductType {
        ACCOUNT,
        DEPOSIT
    }

    protected String ownerId;
    protected double balance;
    protected String id;
    protected Date createdAt;

    public Product(){
        createdAt = new Date();
        id = UUID.randomUUID().toString();
    }


    public String getId(){
        return this.id;
    }

    public double getBalance(){
        return this.balance;
    }

    public Date getCreatedAt(){
        return this.createdAt;
    }

    public boolean canClose(){
        return balance > 0;
    }

    abstract void addCash(double amount);
    abstract boolean getCash(double amount);
    abstract double close(int numberOfMonths);
}
