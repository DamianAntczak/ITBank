/**
 * Created by krzysztof on 28/04/2017.
 */
public class AllReports implements Visitor {

    @Override
    public IProduct visit(BankAccount account) {
        return account;
    }

    @Override
    public IProduct visit(Deposit deposit) {
        return deposit;
    }

    @Override
    public IProduct visit(Credit credit) {
        return credit;
    }
}
