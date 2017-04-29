package Mediator;

import Command.Command;

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
}
