import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 10.03.2017.
 */
public class Client {
    private String id;
    private String name;
    private String surname;
    private String address;
    private List<BankAccount> ownedAccounts = new ArrayList<BankAccount>();

    public Client(String id, String name, String surname, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public void addAccount(BankAccount account) {
        ownedAccounts.add(account);
    }

    public void removeAccount(BankAccount account) {
        ownedAccounts.remove(account);
    }

    private void requestProduct(String clientId) { //TODO: arg as product type

    }
}
