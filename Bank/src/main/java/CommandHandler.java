import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcinkarmelita on 21/04/17.
 */
public class CommandHandler {
    private List<Command> commands;

    public CommandHandler() {
        commands = new ArrayList<>();
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void handleCommand(Command command) {
        // TODO (MK): Add command only if the command is not an internal banking operation.
        commands.add(command);
    }

    public void getExternalOperations() {

    }
}
