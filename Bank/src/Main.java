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



        //testOdsetek();
        //testLokaty();
        testBanku();
    }

    public static  void testBanku() {
        Bank bank = new Bank();
        Client client1 = bank.createClient("Krzysztof", "Rozga", "Piotrowo");
        client1.addAccount(bank.addProductForClient(new BankAccount(client1.getId())));
        client1.addAccount(bank.addProductForClient(new Credit(client1.getId(), new Interest(InterestFrequency.halfYearly, 4), 4000)));

        Client client2 = bank.createClient("Jan", "Kowalski", "Piotrowo");
        client2.addAccount(bank.addProductForClient(new BankAccount(client1.getId())));

        client1.printAccounts();
    }

    public static void testOdsetek(){
        Interest interest = new Interest(InterestFrequency.monthly, 5);
        System.out.println(interest.InterestCalculation(6));
        System.out.println();
    }

    public static void testLokaty(){
        //Deposit deposit = new Deposit(new Interest(InterestFrequency.yearly,4),5000);
        //System.out.println(deposit.close(12));
    }
}
