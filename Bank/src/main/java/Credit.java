/**
 * Created by krzysztof on 16/03/2017.
 */
public class Credit extends Product implements Cashable {
    private Interest interest;

    public Credit(String ownerId, Interest interest, double amount){
        super(ownerId,"Credit");
        this.interest = interest;
        addCash(amount);
    }

    private double calculate(int numberOfMonths){
        return  this.interest.InterestCalculation(numberOfMonths, this.balance);
    }

    public void addCash(double amount) {
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
    double close(int numberOfMonths) throws RuntimeException {
        if (this.balance >= 0) {
            return this.calculate(numberOfMonths);
        } else {
            throw new RuntimeException("Cannot close credit with negative balance");
        }

    }
}
