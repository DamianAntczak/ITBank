package CommandHandler;

import Command.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcinkarmelita on 21/04/17.
 */
public class BankCommandHandler implements CommandHandler {
    private List<Command> commands;

    public BankCommandHandler() {
        commands = new ArrayList<>();
    }

    public List<Command> getExternalCommands() {
        return commands;
    }

    @Override
    public void handle(Command command) {
        // TODO (MK): Add command only if the command is not an internal banking operation.
        if (command.isInternal()) {
            command.execute();
        } else {
            commands.add(command);
        }
    }
}
