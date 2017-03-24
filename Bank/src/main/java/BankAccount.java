import java.util.Date;

/**
 * Created by student on 10.03.2017.
 */
public class BankAccount extends Product implements Debit, Cashable{

    public BankAccount(String ownerId){
        super(ownerId,"Konto osobiste");
        this.balance = 0;
        this.createdAt = new Date();
    }

    public void addCash(double amount){
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

    @Override
    //Get cash and close the account
    double close(int numberOfMonths) {
        double balance = this.balance;
        this.balance = 0;
        return balance;
    }

    @Override
    public void setDebit(double amount) {
        this.debit = amount;
    }

    @Override
    boolean canClose() {
        return this.balance >= 0;
    }
}
