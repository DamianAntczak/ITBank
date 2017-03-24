import java.util.ArrayList;
import java.util.List;

import java.util.UUID;
import java.util.function.Predicate;

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

    public String addProductForClient(Product product) {
        products.add(product);

        return product.getId();
    }

    private Product getProduct(String productId) {
        Predicate<Product> predicate = c-> c.getId().equals(productId);
        Product  obj = products.stream().filter(predicate).findFirst().get();
        return obj;
    }

    public void transferOperation(Integer amount, String fromProductId, String toProductId) throws RuntimeException {
        Product fromProduct = getProduct(fromProductId);
        Product toProduct = getProduct(toProductId);
        try {
            new BankingOperation().transferOperation(amount, (Cashable) fromProduct, (Cashable) toProduct);
        } catch (Exception e) {

        }
    }

    public void incomingCashOperation(Integer amount, String toProductId) {
        Product toProduct = getProduct(toProductId);
        new BankingOperation().incomingCashOperation(amount, (Cashable) toProduct);
    }

    public void outcomingCashOperation(Integer amount, String fromProductId) throws Exception {
        Product fromProduct = getProduct(fromProductId);
        try {
            new BankingOperation().outcomingCashOperation(amount, (Cashable) fromProduct);
        } catch (Exception e) {

        }
    }

    private boolean removeProduct (String productId) {
        for (Product product : products) {
            Product prodToDel = null;
            if (product.id == productId){
                prodToDel = product;
                products.remove(prodToDel);
                return true;
            }

        }
        return false;
    }

    public void removeProduct(Client client, String productId) {
        if (this.removeProduct(productId)) {
            client.removeProductForId(productId);
            History.getInstance().addRecord(new RecordForAction(BankingOperation.BankingOperationType.PRODUCTREMOVED, productId));
            return;
        }
        History.getInstance().addRecord(new RecordForAction(BankingOperation.BankingOperationType.PRODUCTDENIEDTOREMOVE, productId));
    }

}
