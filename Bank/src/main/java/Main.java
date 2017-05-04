import java.util.ArrayList;
import java.util.List;

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

        testBanku();

//        BankAccount ba = new BankAccount("1234");
//        ba.balance = 20000;

        //testOdsetek();
//        testLokaty();
//        testHistory();
//        testReports();
    }

    public static  void testBanku() {
        Bank bank = new Bank();
        Client client1 = bank.createClient("Krzysztof", "Rozga", "Piotrowo");

        client1.addProduct(bank.addProductForClient(new BankAccount(client1.getId())));
        Deposit deposit = new Deposit(client1.getId(),new InterestExample(InterestFrequency.yearly),5000);
        client1.addProduct(bank.addProductForClient(deposit));

        Client client2 = bank.createClient("Jan", "Kowalski", "Piotrowo");
        client2.addProduct(bank.addProductForClient(new Credit(client2.getId(), new InterestExample(InterestFrequency.yearly), 1000)));


        bank.doAllProductsReport(new AllReports());
        bank.doReportForOver(new ReportOver(4000));

//        testOdsetek();
//        testLokaty();
    }

    public static void testOdsetek(){
        Interest interest = new InterestExample(InterestFrequency.halfYearly);
        System.out.println(interest.interestCalculation(12, 100000));
        System.out.println();
    }

//    public static void testLokaty(){
//        Bank bank = new Bank();
//        Client client1 = bank.createClient("Krzysztof", "Rozga", "Piotrowo");
//        client1.addProduct(bank.addProductForClient(new BankAccount(client1.getId())));
//        client1.print();
//        Deposit deposit = new Deposit(client1.getId(), new Interest(InterestFrequency.yearly,4),5000);
//        System.out.println(deposit);
//        System.out.println(deposit.close(12));
//
//    }
//
//    public static  void testHistory() {
//        Bank bank = new Bank();
//        Client client1 = bank.createClient("Krzysztof", "Rozga", "Piotrowo");
//        client1.addProduct(bank.addProductForClient(new BankAccount(client1.getId())));
//        client1.addProduct(bank.addProductForClient(new Credit(client1.getId(), new Interest(InterestFrequency.halfYearly, 4), 4000)));
//
//        Client client2 = bank.createClient("Jan", "Kowalski", "Piotrowo");
//        client2.addProduct(bank.addProductForClient(new BankAccount(client1.getId())));
//
//        client1.print();
//
//        bank.incomingCashOperation(500, client1.getProductId(0));
//        bank.transferOperation(200, client1.getProductId(0), client2.getProductId(0));
//
//       bank.removeProduct(client1, client1.getProductId(0));
//    }
//
//    public static void testReports() {
//        Bank bank = new Bank();
//        Client client1 = bank.createClient("Krzysztof", "Rozga", "Piotrowo");
//        client1.addProduct(bank.addProductForClient(new BankAccount(client1.getId())));
//        client1.addProduct(bank.addProductForClient(new Credit(client1.getId(), new Interest(InterestFrequency.halfYearly, 4), 4000)));
//
//        Client client2 = bank.createClient("Jan", "Kowalski", "Piotrowo");
//        client2.addProduct(bank.addProductForClient(new BankAccount(client1.getId())));
//
//        client1.print();
//
//        bank.incomingCashOperation(500, client1.getProductId(0));
//        bank.incomingCashOperation(666, client2.getProductId(0));
//        bank.outcomingCashOperation(123, client1.getProductId(0));
//        bank.outcomingCashOperation(66, client2.getProductId(0));
//        bank.outcomingCashOperation(1, client1.getProductId(0));
//        bank.transferOperation(300, client1.getProductId(0), client2.getProductId(0));
//        bank.transferOperation(300, client2.getProductId(0), client1.getProductId(0));
//
//        String testProductId = client1.getProductId(0);
//        bank.removeProduct(client1, client1.getProductId(0));
//        bank.removeProduct(client2, client2.getProductId(0));
//
//        List<BankingOperation.BankingOperationType> types = new ArrayList<>();
//        types.add(BankingOperation.BankingOperationType.transfer);
//        types.add(BankingOperation.BankingOperationType.incoming_cash);
//
//
//        client1.requestReport(bank.createReportFor(testProductId, types, null, null));
//    }
}
