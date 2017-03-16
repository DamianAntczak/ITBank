import java.util.ArrayList;
import java.util.List;

import java.util.UUID;

/**
 * Created by student on 10.03.2017.
 */
public class Bank {
    //TODO: Add fields
    private List<Client> clients = new ArrayList<Client>();
    private List<Product> products = new ArrayList<Product>();

    public Bank() {
    }

    public Client createClient(String name, String surname, String address) {
        return new Client(UUID.randomUUID().toString(), name, surname, address);
    }

    public Product addProductForClient(String clientId, Product.ProductType type) {
        Product bankProduct;

        switch (type) {
            case ACCOUNT:
                bankProduct = new BankAccount(clientId);
                break;
            case LOAN:
                bankProduct = null;
                break;
            default:
                bankProduct = null;
                break;
        }

        return bankProduct;

    }

    public void performOperation() {

    }
}
