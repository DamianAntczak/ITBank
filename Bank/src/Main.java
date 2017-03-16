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

        Bank bank = new Bank();
        Client client1 = bank.createClient("Krzysztof", "Rozga", "Piotrowo");
        client1.addAccount(bank.addProductForClient(client1.id, Product.ProductType.ACCOUNT));
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
        Deposit deposit = new Deposit(new Interest(InterestFrequency.yearly,4),5000);
        System.out.println(deposit.close(12));

    }
}
