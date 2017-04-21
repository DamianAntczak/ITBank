/**
 * Created by marcinkarmelita on 21/04/17.
 */
public interface Mediator {
    void queueTransferOperation(Command command) throws RuntimeException;
    void queueReturnTransferOperation(Command command) throws RuntimeException;

//    void transferOperation(BankAccount.Command command) throws RuntimeException;
//    void returnTransferOperation(BankAccount.Command command) throws RuntimeException;
}
