import java.util.Date;

/**
 * Created by marcinkarmelita on 21/04/17.
 */

public class TransferCommand implements Command {
    private Transfer transfer;
    private boolean executed = false;

    public TransferCommand(Product from, Product to, Double amount) {
        transfer = new Transfer(from, to, amount);
    }

    @Override
    public void execute() throws RuntimeException {
        if (executed) {
            throw new RuntimeException("Transfer command was already executed.");
        }
        try {
            transfer.from.getCash(transfer.amount);
            transfer.to.addCash(transfer.amount);

//            History.getInstance().addRecord(new RecordForTransfer(transfer.id, transfer.date, BankingOperation.BankingOperationType.transfer, from.getBalance(), amount, from.getId(),  to.getId()));
        } catch (Exception e) {
//            History.getInstance().addRecord(new RecordForTransfer(transfer.id, transfer.date, BankingOperation.BankingOperationType.rejected_transfer, from.getBalance(), amount, from.getId(), to.getId()));
            throw e;
        }

        executed = true;
    }

    private class Transfer {
        private IProduct from;
        private IProduct to;
        private Double amount;
        private String id;
        private Date date;

        public Double getAmount() {
            return amount;
        }

        public void setAmount(Double amount) {
            this.amount = amount;
        }

        public Transfer(Product from, Product to, Double amount) {
            this.from = from;
            this.to = to;
            this.amount = amount;
            this.id = NumberFactory.getInstance().createNumberForBankingOperation();
            this.date = new Date();
        }
    }
}
