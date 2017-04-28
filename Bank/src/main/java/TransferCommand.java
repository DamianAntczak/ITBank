import java.util.Date;

/**
 * Created by marcinkarmelita on 21/04/17.
 */

public class TransferCommand implements Command {
    private boolean executed = false;
    private IncomingCashCommand incomingCashCommand;
    private OutcomingCashCommand outcomingCashCommand;
    private boolean internal;

    public TransferCommand(IProduct from, IProduct to, Double amount) {
        incomingCashCommand = new IncomingCashCommand(amount, to);
        outcomingCashCommand = new OutcomingCashCommand(amount, from);
        // TODO (MK): Check if the transfer is internal
        internal = true;
    }

    @Override
    public boolean isInternal() {
        return internal;
    }

    @Override
    public void execute() throws RuntimeException {
        if (executed) {
            throw new RuntimeException("Transfer command was already executed.");
        }
        try {
            outcomingCashCommand.execute();
            incomingCashCommand.execute();
        } catch (Exception e) {
            throw e;
        }

        executed = true;
    }
}
