import java.rmi.server.UID;
import java.util.Date;

/**
 * Created by student on 10.03.2017.
 */
public class BankAccount extends Product {

    public BankAccount(String ownerId){
        UID uid = new UID();
        this.balance = 0;
        this.number = uid.toString();
        this.ownerId = ownerId;
        this.createdAt = new Date();
    }

    public void addCash(double amount){
        this.balance += amount;
    }

    public boolean getCash(double amount){
        if(this.balance >= amount){
            this.balance -= amount;
            return true;
        }
        else{
            return false;
        }
    }
}
