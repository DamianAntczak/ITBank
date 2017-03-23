import java.rmi.server.UID;
import java.util.Date;
import java.util.UUID;

/**
 * Created by krzysztof on 16/03/2017.
 */
public class Credit extends Product {
    private Interest interest;

    public Credit(String ownerId, Interest interest, double amount){
        super(ownerId,"Kredyt");
        this.interest = interest;
        addCash(amount);
    }

    private double calculate(int numberOfMonths){
        return  this.balance * this.interest.InterestCalculation(numberOfMonths);
    }

    @Override
    void addCash(double amount) {
        this.balance += amount;
    }

    @Override
    boolean getCash(double amount) {
        return false;
    }

    @Override
    double close(int numberOfMonths) {
        return this.calculate(numberOfMonths);
    }


}
