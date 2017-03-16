import java.util.Date;

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
    protected String number;
    protected Date createdAt;


    public String getNumber(){
        return this.number;
    }

    public double getBalance(){
        return this.balance;
    }

    public Date getCreatedAt(){
        return this.createdAt;
    }

    abstract void addCash(double value);
    abstract boolean getCash(double value);
}
