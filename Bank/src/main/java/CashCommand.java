/**
 * Created by marcinkarmelita on 21/04/17.
 */


abstract public class CashCommand implements Command {
    protected Operation operation;

    public CashCommand(Double amount, IProduct from) {
        operation = new Operation(amount, from);
    }

    @Override
    public boolean isInternal() {
        return true;
    }
}
