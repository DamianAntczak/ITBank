import java.util.Date;

/**
 * Created by student on 10.03.2017.
 */
public class BankAccount extends Product implements Debit{

    public BankAccount(String ownerId){
        super(ownerId,"Konto osobiste");
        this.balance = 0;
        this.createdAt = new Date();
    }

    public void addCash(double amount){
        this.balance += amount;
    }

    public boolean getCash(double amount){
        if(this.balance + this.debit >= amount){
            this.balance -= amount;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    double close(int numberOfMonths) {
        return 0;
    }

    @Override
    public void setDebit(double amount) {
        this.debit = amount;
    }
}
