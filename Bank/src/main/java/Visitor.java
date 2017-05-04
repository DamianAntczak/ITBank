/**
 * Created by krzysztof on 28/04/2017.
 */
public interface Visitor {
    public IProduct visit(BankAccount account);
    public IProduct visit(Deposit deposit);
    public IProduct visit(Credit credit);
}
