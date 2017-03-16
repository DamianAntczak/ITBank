import java.security.acl.Owner;
import java.util.Date;
import java.util.UUID;

/**
 * Created by student on 10.03.2017.
 */
public abstract class Product {

    public enum ProductType {
        ACCOUNT,
        DEPOSIT,
        CREDIT
    }

    protected String ownerId;
    protected double balance;
    protected String id;
    protected Date createdAt;
    protected String OwnerID;

    public Product(String OwnerID){
        createdAt = new Date();
        this.ownerId = ownerId;
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
