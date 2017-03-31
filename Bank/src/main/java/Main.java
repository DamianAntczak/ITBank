import java.util.function.Predicate;

/**
 * Created by student on 10.03.2017.
 */
public class Main {
    public static void main(String [] args){
        /*BankAccount  firstAccount = new BankAccount("12345");
        System.out.println(firstAccount.getNumber());
        firstAccount.addCash(200);
        System.out.println(firstAccount.getBalance());
        firstAccount.getCash(20);
        System.out.println(firstAccount.getBalance());
        System.out.println(firstAccount.getCreatedAt());*/

        BankAccount ba = new BankAccount("1234");
        ba.balance = 20000;

        testOdsetek();
        testLokaty();
        testHistory();
        testReports();
    }

    public static  void testBanku() {
        Bank bank = new Bank();
        Client client1 = bank.createClient("Krzysztof", "Rozga", "Piotrowo");
        client1.addProduct(bank.addProductForClient(new BankAccount(client1.getId())));
        client1.addProduct(bank.addProductForClient(new Credit(client1.getId(), new Interest(InterestFrequency.halfYearly, 4), 4000)));

        Client client2 = bank.createClient("Jan", "Kowalski", "Piotrowo");
        client2.addProduct(bank.addProductForClient(new BankAccount(client1.getId())));

        client1.printAccounts();

        //testOdsetek();
        testLokaty();
    }

    public static void testOdsetek(){
        Interest interest = new Interest(InterestFrequency.monthly, 5);
        System.out.println(interest.InterestCalculation(6));
        System.out.println();
    }

    public static void testLokaty(){
        Bank bank = new Bank();
        Client client1 = bank.createClient("Krzysztof", "Rozga", "Piotrowo");
        client1.addProduct(bank.addProductForClient(new BankAccount(client1.getId())));
        client1.printAccounts();
        Deposit deposit = new Deposit(client1.getId(), new Interest(InterestFrequency.yearly,4),5000);
        System.out.println(deposit);
        System.out.println(deposit.close(12));

    }

    public static  void testHistory() {
        Bank bank = new Bank();
        Client client1 = bank.createClient("Krzysztof", "Rozga", "Piotrowo");
        client1.addProduct(bank.addProductForClient(new BankAccount(client1.getId())));
        client1.addProduct(bank.addProductForClient(new Credit(client1.getId(), new Interest(InterestFrequency.halfYearly, 4), 4000)));

        Client client2 = bank.createClient("Jan", "Kowalski", "Piotrowo");
        client2.addProduct(bank.addProductForClient(new BankAccount(client1.getId())));

        client1.printAccounts();

        bank.incomingCashOperation(500, client1.getProductId(0));
        bank.transferOperation(200, client1.getProductId(0), client2.getProductId(0));

       bank.removeProduct(client1, client1.getProductId(0));
    }

    public static void testReports() {
        Bank bank = new Bank();
        Client client1 = bank.createClient("Krzysztof", "Rozga", "Piotrowo");
        client1.addProduct(bank.addProductForClient(new BankAccount(client1.getId())));
        client1.addProduct(bank.addProductForClient(new Credit(client1.getId(), new Interest(InterestFrequency.halfYearly, 4), 4000)));

        Client client2 = bank.createClient("Jan", "Kowalski", "Piotrowo");
        client2.addProduct(bank.addProductForClient(new BankAccount(client1.getId())));

        client1.printAccounts();

        bank.incomingCashOperation(500, client1.getProductId(0));
        bank.incomingCashOperation(666, client2.getProductId(0));
        bank.transferOperation(300, client1.getProductId(0), client2.getProductId(0));

        //bank.removeProduct(client1, client1.getProductId(0));

        Predicate<Record> predicateForTransfer = (p) -> p.getType().equals(BankingOperation.BankingOperationType.transfer);
        Predicate<Record> predicateForIncomingCash = (p) -> p.getType().equals(BankingOperation.BankingOperationType.incoming_cash);

        client1.requestReport(bank.createReportFor(predicateForTransfer));
        client2.requestReport(bank.createReportFor(predicateForIncomingCash));
    }
}
