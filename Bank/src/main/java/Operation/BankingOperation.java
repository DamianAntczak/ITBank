package Operation; /**
 * Created by marcinkarmelita on 10/03/17.
 */

import Record.RecordForAction;
import Utils.NumberFactory;
import History.History;
import java.util.Date;

public class BankingOperation {
    public enum BankingOperationType {
        transfer("transfer"),
        rejected_transfer("transfer rejected"),

        incoming_cash("incoming cash"),
        outcoming_cash("outcoming cash"),
        rejected_cash("rejected cash"),

        product_removed("product removed"),
        product_added("product added"),
        product_denied_to_remove("product denied to remove");

        // Member to hold the name
        private String string;

        // constructor to set the string
        BankingOperationType(String name) {
            string = name;
        }
    }

    protected String id;
    protected Date date;

    public BankingOperation() {
        this.id = NumberFactory.getInstance().createNumberForBankingOperation();
        this.date = new Date();
    }

    public String getId() {
        return id;
    }

    public void removingOperation(String productId, boolean succeeded) {
        History.getInstance().addRecord(new RecordForAction(this.id, this.date, succeeded ? BankingOperation.BankingOperationType.product_removed : BankingOperation.BankingOperationType.product_denied_to_remove, 0.0, productId));
    }

    public void addingOperation(String productId, Double balance) {
        History.getInstance().addRecord(new RecordForAction(this.id, this.date, BankingOperationType.product_added, balance, productId));
    }

}



