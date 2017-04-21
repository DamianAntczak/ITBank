/**
 * Created by marcinkarmelita on 21/04/17.
 */


public class CashCommand implements Command {
    private Operation operation;

    public CashCommand(Double amount, IProduct from) {
        operation = new Operation(amount, from);
    }

    @Override
    public void execute() throws RuntimeException {
        //        operation.getProduct().addCash(operation.getAmount());
        //        History.getInstance().addRecord(new RecordForTransfer(operation.getId(), operation.getDate(), BankingOperation.BankingOperationType.incoming_cash, operation.getProduct().getBalance(), operation.getAmount(), "", ((Product)toProduct).getId()));
    }

    public class IncomingCashCommand extends CashCommand implements Command {
        public IncomingCashCommand(Double amount, IProduct from) {
            super(amount, from);
        }

        @Override
        public void execute() throws RuntimeException {
            operation.getProduct().addCash(operation.getAmount());
            super.execute();
        }
    }

    public class OutcomingCashCommand extends CashCommand implements Command {
        public OutcomingCashCommand(Double amount, IProduct from) {
            super(amount, from);
        }

        @Override
        public void execute() throws RuntimeException {
            operation.getProduct().getCash(operation.getAmount());
            super.execute();
        }
    }
}