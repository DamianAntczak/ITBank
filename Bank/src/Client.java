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
    private List<Product> ownedProducts = new ArrayList<Product>();

    public String getId() {
        return id;
    }

    public Client(String id, String name, String surname, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public void addAccount(Product account) {
        ownedProducts.add(account);
    }

    public void removeAccount(String productId) {
        for (Product product : ownedProducts) {
            Product prodToDel = null;
            if (product.id == productId)
                prodToDel = product;
            ownedProducts.remove(prodToDel);
        }
    }

    /*public void transferOperation(Integer amount, String myProduct, String toProduct) {

    }*/

    public void printAccounts() {
        System.out.println(ownedProducts);
    }

}
