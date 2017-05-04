import java.util.Date;

/**
 * Created by student on 10.03.2017.
 */
public abstract class Product implements IProduct{

    protected double debit;
    protected String ownerId;
    protected double balance;
    protected String id;
    protected Date createdAt;
    protected String name;

    public Product(String ownerId, String name){
        createdAt = new Date();
        this.ownerId = ownerId;
        id = NumberFactory.getInstance().createNumberForProduct();
        this.debit = 0;
        this.name = name;
    }


    @Override
    public String getId(){
        return this.id;
    }
    @Override
    public double getBalance(){
        return this.balance;
    }

    abstract double close(int numberOfMonths) throws RuntimeException;

    @Override
    public Date getCreatedAt(){
        return this.createdAt;
    }

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
