import java.util.Date;

/**
 * Created by Damian on 21.04.2017.
 */
public class DebitAccount implements IProduct{
    private BankAccount bankAccount;
    private  double debit;

    public DebitAccount(String ownerID, double debit){
        bankAccount = new BankAccount(ownerID);
        this.debit = debit;
    }

    @Override
    public String getId() {
        return bankAccount.getId();
    }

    @Override
    public double getBalance() {
        return bankAccount.getBalance();
    }

    @Override
    public Date getCreatedAt() {
        return bankAccount.getCreatedAt();
    }

    @Override
    public void addCash(double amount) {
        bankAccount.addCash(amount);
    }

    @Override
    public double getCash(double amount) throws RuntimeException {
        if(bankAccount.getBalance() >= amount){
            return bankAccount.getCash(amount);
        }
        else if(bankAccount.getBalance() + this.debit >= amount){
            double toDebit = amount - bankAccount.getCash(bankAccount.balance);
            return getFromDebit(toDebit) + (amount - toDebit);
        }
        else {
            throw new RuntimeException("Too small balance or debit to get cash");
        }
    }

    @Override
    public double close(int numberOfMonths) throws RuntimeException {
        return bankAccount.close(numberOfMonths);
    }

    private double getFromDebit(double amount){
        debit -= amount;
        return amount;
    }

    public double getDebit() {
        return debit;
    }
}
