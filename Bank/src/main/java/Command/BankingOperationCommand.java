package Command;

/**
 * Created by marcinkarmelita on 21/04/17.
 */
public interface BankingOperationCommand extends Command {
    boolean isInternal();
}
