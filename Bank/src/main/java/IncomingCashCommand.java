/**
 * Created by marcinkarmelita on 21/04/17.
 */
public class IncomingCashCommand extends CashCommand {
    public IncomingCashCommand(Double amount, IProduct from) {
        super(amount, from);
    }

    @Override
    public void execute() throws RuntimeException {
        operation.getProduct().addCash(operation.getAmount());
    }
}
