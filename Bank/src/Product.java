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

    protected double debit;
    protected String ownerId;
    protected double balance;
    protected String id;
    protected Date createdAt;
    protected String OwnerID;
    protected String name;

    public Product(String ownerId, String name){
        createdAt = new Date();
        this.ownerId = ownerId;
        id = UUID.randomUUID().toString();
        this.debit = 0;
        this.name = name;
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

    public String toString(){
        return "Product - " + this.name + " numer - "+this.id+" dla użytkownika - "+this.ownerId+" : balans - "+this.balance + ", debet - "+this.debit;
    }

    abstract void addCash(double amount);
    abstract boolean getCash(double amount);
    abstract double close(int numberOfMonths);
}
