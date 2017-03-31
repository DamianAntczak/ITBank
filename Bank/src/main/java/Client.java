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
    private List<String> ownedProductsIds = new ArrayList<String>();

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
        ownedProductsIds.add(account);
    }


    public void printAccounts() {
        System.out.println(ownedProductsIds);
    }

    public List<String> getProductsIds() {
        return ownedProductsIds;
    }

    public String getProductId(Integer index) {
        return ownedProductsIds.get(index);
    }

    public void removeProductForId(String productIdtoRemove) {
        ownedProductsIds.remove(productIdtoRemove);
    }

    public void requestReport(Report report) {
        report.print();
    }
}
