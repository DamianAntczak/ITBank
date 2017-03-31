import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.function.Predicate;

/**
 * Created by student on 10.03.2017.
 */
public class Bank {
    private List<Product> products = new ArrayList<Product>();

    public Bank() {
    }

    public Client createClient(String name, String surname, String address) {
        return new Client(NumberFactory.getInstance().createNumberForClient(), name, surname, address);
    }

    public String addProductForClient(Product product) {
        products.add(product);

        return product.getId();
    }

    private Product getProduct(String productId) {
        Predicate<Product> predicate = c -> c.getId().equals(productId);
        Product obj = products.stream().filter(predicate).findFirst().get();
        return obj;
    }

    public void transferOperation(Integer amount, String fromProductId, String toProductId) throws RuntimeException {
        Product fromProduct = getProduct(fromProductId);
        Product toProduct = getProduct(toProductId);
        new BankingOperation().transferOperation(amount, (Cashable) fromProduct, (Cashable) toProduct);
    }

    public void incomingCashOperation(Integer amount, String toProductId) {
        Product toProduct = getProduct(toProductId);
        new BankingOperation().incomingCashOperation(amount, (Cashable) toProduct);
    }

    public void outcomingCashOperation(Integer amount, String fromProductId) throws RuntimeException {
        Product fromProduct = getProduct(fromProductId);
        new BankingOperation().outcomingCashOperation(amount, (Cashable) fromProduct);
    }

    private boolean removeProduct(String productId) {
        for (Product product : products) {
            Product prodToDel;
            if (product.id == productId) {
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
            new BankingOperation().removingOperation(productId, true);
            return;
        }
        new BankingOperation().removingOperation(productId, true);
    }

    public Report createReportFor(Predicate<Record> predicate) {
        return (new Report(History.getInstance().filter(predicate)));
    }

}
