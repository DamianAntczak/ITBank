package Command;

import Product.IProduct;
import Operation.Operation;

/**
 * Created by marcinkarmelita on 21/04/17.
 */


abstract public class CashCommand implements BankingOperationCommand {
    protected Operation operation;
    protected boolean executed;

    public CashCommand(Double amount, IProduct from) {
        operation = new Operation(amount, from);
        executed = false;
    }

    @Override
    public boolean isInternal() {
        return true;
    }

    @Override
    public void execute() throws RuntimeException {
        if (executed) {
            throw new RuntimeException("Command.Command cannot be executed twice.");
        }
        executed = true;
    }
}
