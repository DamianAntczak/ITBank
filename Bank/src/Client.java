import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 10.03.2017.
 */
public class Client {
    public String id;
    private String name;
    private String surname;
    private String address;
    private List<Product> ownedAccounts = new ArrayList<Product>();

    public Client(String id, String name, String surname, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public void addAccount(Product account) {
        ownedAccounts.add(account);
    }

    public void removeAccount(BankAccount account) {
        ownedAccounts.remove(account);
    }

    public void printAccounts() {
        System.out.println(ownedAccounts);
    }
}
