package Mediator;

import Bank.Bank;
import Command.*;
import Utils.Findable;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by marcinkarmelita on 21/04/17.
 */
public class KIRMediator implements Mediator, Command, Findable {
    private List<Bank> banks;
//    private List<BankingOperationCommand> commands;
    private Map<Bank, List<BankingOperationCommand>> map;
    public KIRMediator() {
        banks = new ArrayList<Bank>();
//        commands = new ArrayList<BankingOperationCommand>();
        map = new HashMap<Bank, List<BankingOperationCommand>>();
    }

    public void addBank(Bank bank) {
        map.put(bank, bank.getTransactions());
    }

    private void combineTransfers() {

    }

    private void rearrangeTransfers() {

    }

    @Override
    public void execute() {
        combineTransfers();
    }

    @Override
    public Optional findFirst(Collection collection, Predicate predicate) {
        return null;
    }

    @Override
    public Collection findAny(Collection collection, Predicate predicate) {
        return null;
    }

    @Override
    public boolean contains(Collection collection, Predicate predicate) {
        return false;
    }
}
