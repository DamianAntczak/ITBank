package CommandHandler;

import Command.Command;

/**
 * Created by marcinkarmelita on 28/04/17.
 */
public interface CommandHandler <T extends Command> {
    void handle(T command);
}
