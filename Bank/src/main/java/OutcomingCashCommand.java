/**
 * Created by marcinkarmelita on 21/04/17.
 */
public class OutcomingCashCommand extends CashCommand {
    public OutcomingCashCommand(Double amount, IProduct from) {
        super(amount, from);
    }

    @Override
    public void execute() throws RuntimeException {
        super.execute();
        operation.getProduct().getCash(operation.getAmount());
    }
}