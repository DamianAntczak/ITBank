/**
 * Created by marcinkarmelita on 10/03/17.
 */

import java.util.Date;

public class BankingOperation {

    public enum BankingOperationType {
        INCOMINGTRANSFER,
        OUTCOMINGTRANSFER,
        REJECTEDTRANSFER,

        INCOMINGCASH,
        OUTCOMINGCASH,
        REJECTEDCASH,

        PRODUCTREMOVED,
        PRODUCTADDED,
        PRODUCTDENIEDTOREMOVE,

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
            History.getInstance().addRecord(new RecordForTransfer(this.id, this.date, BankingOperationType.INCOMINGTRANSFER, amount, from.getId(),  to.getId()));
            History.getInstance().addRecord(new RecordForTransfer(this.id, this.date, BankingOperationType.OUTCOMINGTRANSFER, amount, to.getId(),  from.getId()));
        } catch (Exception e) {
            History.getInstance().addRecord(new RecordForTransfer(this.id, this.date, BankingOperationType.REJECTEDTRANSFER, amount, from.getId(), to.getId()));
            throw e;
        }
    }

    public void incomingCashOperation(Integer amount, Cashable toProduct) {
        toProduct.addCash(amount);
        History.getInstance().addRecord(new RecordForCash(this.id, this.date, BankingOperationType.INCOMINGCASH, amount, "", ((Product)toProduct).getId()));
    }

    public void outcomingCashOperation(Integer amount, Cashable fromProduct) throws RuntimeException {
        try{
            fromProduct.getCash(amount);
            History.getInstance().addRecord(new RecordForCash(this.id, this.date, BankingOperationType.OUTCOMINGCASH, amount, ((Product )fromProduct).getId(), ""));
        } catch (Exception e){
            History.getInstance().addRecord(new RecordForCash(this.id, this.date, BankingOperationType.REJECTEDCASH, amount, ((Product) fromProduct).getId(), ""));
            throw e;
        }
    }

    public void removingOperation(String productId, boolean succeeded){
        History.getInstance().addRecord(new RecordForAction(this.id, this.date, succeeded ? BankingOperation.BankingOperationType.PRODUCTREMOVED : BankingOperation.BankingOperationType.PRODUCTDENIEDTOREMOVE, productId));
    }

}



