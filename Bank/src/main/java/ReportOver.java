/**
 * Created by krzysztof on 04/05/2017.
 */
public class ReportOver implements Visitor {
    private double balance;

    public ReportOver(double balance) {
        this.balance = balance;
    }


    @Override
    public IProduct visit(BankAccount account) {
        if (account.getBalance() > balance)
            return account;
        return null;
    }

    @Override
    public IProduct visit(Deposit deposit) {
        if (deposit.getBalance() > balance)
            return deposit;
        return null;
    }

    @Override
    public IProduct visit(Credit credit) {
        if (credit.getBalance() > balance)
            return credit;
        return null;
    }
}
