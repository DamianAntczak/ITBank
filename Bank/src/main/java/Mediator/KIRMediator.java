package Mediator;

import Bank.Bank;
import Command.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcinkarmelita on 21/04/17.
 */
public class KIRMediator implements Mediator, Command {
    private List<Bank> banks;

    public KIRMediator() {
        banks = new ArrayList<Bank>();
    }

    @Override
    public void execute() throws RuntimeException {

    }

}
