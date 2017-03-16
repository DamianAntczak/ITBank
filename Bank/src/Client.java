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
    private List<String> ownedProducts = new ArrayList<String>();

    public String getId() {
        return id;
    }

    public Client(String id, String name, String surname, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public void addProduct(String account) {
        ownedProducts.add(account);
    }


    /*public void transferOperation(Integer amount, String myProduct, String toProduct) {

    }*/

    public void printAccounts() {
        System.out.println(ownedProducts);
    }

}
