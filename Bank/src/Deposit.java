/**
 * Created by Damian on 16.03.2017.
 */
public class Deposit extends Product {
    private Interest interest;

    public Deposit(double interest, double amount){
        addCash(amount);
    }

    @Override
    void addCash(double value) {


    }

    @Override
    boolean getCash(double value) {
        return false;
    }
}
