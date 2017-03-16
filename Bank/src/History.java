import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcinkarmelita on 10/03/17.
 */
public class History {
    private static History ourInstance = new History();

    public static History getInstance() {
        return ourInstance;
    }

    private History() {}

    private List<BankingOperation> bankingOperations = new ArrayList<BankingOperation>();

    public void addRecord(BankingOperation bankingOperation) {
        bankingOperations.add(bankingOperation);
    }

    public List<BankingOperation> getBankingOperationsForProduct(Product product) {
        //TODO for product
        return  bankingOperations;
    }





}
