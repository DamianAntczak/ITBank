import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcinkarmelita on 21/04/17.
 */
public class KIRMediator implements Mediator {
    private List<Command> commands;

    public KIRMediator() {
        commands = new ArrayList<Command>();
    }

    @Override
    public void queueTransferOperation(Command command) throws RuntimeException {
        commands.add(command);
    }

    @Override
    public void queueReturnTransferOperation(Command command) throws RuntimeException {

    }
}
