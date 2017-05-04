import java.util.Date;

/**
 * Created by student on 10.03.2017.
 */
public class BankAccount  implements  IProduct {

    protected String ownerId;
    protected double balance;
    protected String id;
    protected Date createdAt;
    protected String name;

    public BankAccount(String ownerId){
        this.ownerId = ownerId;
        this.balance = 0;
        this.createdAt = new Date();
    }

    public void addCash(double amount){
        this.balance += amount;
    }

    public double getCash(double amount) throws RuntimeException {
        if(this.balance >= amount) {
            this.balance -= amount;
            return amount;
        }
        else {
            throw new RuntimeException("Cannot get more cash than account balance");
        }
    }

    //Close the account
    double close(int numberOfMonths) throws RuntimeException{
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
        return id;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public Date getCreatedAt() {
        return null;
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


    @Override
    public IProduct accept(AllReports reports) {
        return reports.visit(this);
    }

    @Override
    public IProduct accept(ReportOver reports) {
        return reports.visit(this);
    }
}
