/**
 * Created by marcinkarmelita on 10/03/17.
 */

import java.util.Date;
import java.util.DoubleSummaryStatistics;

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
        BankingOperationType(String name) {string = name;}

        // the toString just returns the given name
        @Override
        public String toString() {
            return string.replace("_", " ");
        }

    }

    private String id;
    private Date date;

    public BankingOperation() {
        this.id = NumberFactory.getInstance().createNumberForBankingOperation();
        this.date = new Date();
    }

    public String getId() {
        return id;
    }

    public void transferOperation(Integer amount, Cashable fromProduct, Cashable toProduct) throws RuntimeException {
        Product from = (Product) fromProduct;
        Product to = (Product) toProduct;
        try {
            fromProduct.getCash(amount);
            toProduct.addCash(amount);
            History.getInstance().addRecord(new RecordForTransfer(this.id, this.date, BankingOperationType.transfer, from.getBalance(), amount, from.getId(),  to.getId()));
        } catch (Exception e) {
            History.getInstance().addRecord(new RecordForTransfer(this.id, this.date, BankingOperationType.rejected_transfer, from.getBalance(), amount, from.getId(), to.getId()));
            throw e;
        }
    }

    public void incomingCashOperation(Integer amount, Cashable toProduct) {
        toProduct.addCash(amount);
        History.getInstance().addRecord(new RecordForTransfer(this.id, this.date, BankingOperationType.incoming_cash, ((Product)toProduct).getBalance(), amount, "", ((Product)toProduct).getId()));
    }

    public void outcomingCashOperation(Integer amount, Cashable fromProduct) throws RuntimeException {
        try{
            fromProduct.getCash(amount);
            History.getInstance().addRecord(new RecordForTransfer(this.id, this.date, BankingOperationType.outcoming_cash, ((Product)fromProduct).getBalance(), amount, ((Product )fromProduct).getId(), ""));
        } catch (Exception e){
            History.getInstance().addRecord(new RecordForTransfer(this.id, this.date, BankingOperationType.rejected_cash, ((Product)fromProduct).getBalance(), amount, ((Product) fromProduct).getId(), ""));
            throw e;
        }
    }

    public void removingOperation(String productId, boolean succeeded){
        History.getInstance().addRecord(new RecordForAction(this.id, this.date, succeeded ? BankingOperation.BankingOperationType.product_removed : BankingOperation.BankingOperationType.product_denied_to_remove, 0.0, productId));
    }

    public void addingOperation(String productId, Double balance) {
        History.getInstance().addRecord(new RecordForAction(this.id, this.date, BankingOperationType.product_added, balance, productId));
    }

}



