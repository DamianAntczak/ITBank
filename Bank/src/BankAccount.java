import java.rmi.server.UID;

/**
 * Created by student on 10.03.2017.
 */
public class BankAccount {
    private String ownerId;
    private double balance;
    private String number;


    public BankAccount(String ownerId){
        UID uid = new UID();
        this.balance = 0;
        this.number = uid.toString();
        this.ownerId = ownerId;
    }

    public String getNumber(){
        return this.number;
    }

}
