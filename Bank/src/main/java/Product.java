import java.util.Date;

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
    protected String ownerID;
    protected String name;

    public Product(String ownerId, String name){
        createdAt = new Date();
        this.ownerId = ownerId;
        id = NumberFactory.getInstance().createNumberForProduct();
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

    abstract double close(int numberOfMonths);
    abstract boolean canClose();

    @Override
    public String toString() {
        String string = "PRODUCT:" + System.lineSeparator();
        string += "ID: " + this.id + System.lineSeparator();
        string += "Created at: " + this.createdAt.toString() + System.lineSeparator();
        //string += "Type: " + this.ProductType.toString() + System.lineSeparator();
        string += "Owner id: " + this.ownerId + System.lineSeparator();
        return string;
    }



}
