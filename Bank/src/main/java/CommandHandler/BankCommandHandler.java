package CommandHandler;

import Command.BankingOperationCommand;
import Command.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcinkarmelita on 21/04/17.
 */
public class BankCommandHandler implements CommandHandler<BankingOperationCommand> {
    private List<BankingOperationCommand> commands;

    public BankCommandHandler() {
        commands = new ArrayList<>();
    }

    public List<BankingOperationCommand> getExternalCommands() {
        return commands;
    }

    @Override
    public void handle(BankingOperationCommand command) {
        // TODO (MK): Add command only if the command is not an internal banking operation.
        if (command.isInternal()) {
            command.execute();
        } else {
            commands.add(command);
        }
    }
}
