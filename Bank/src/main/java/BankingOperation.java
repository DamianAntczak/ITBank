/**
 * Created by marcinkarmelita on 10/03/17.
 */

import java.rmi.server.UID;
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
        this.id = new UID().toString();
        this.date = new Date();
    }

    public void transferOperation(Integer amount, Product fromProduct, Product toProduct) throws Exception {
        try {
            fromProduct.getCash(amount);
            toProduct.addCash(amount);
            History.getInstance().addRecord(new RecordForTransfer(this.id, this.date, BankingOperationType.INCOMINGTRANSFER, amount, fromProduct.getId(), toProduct.getId()));
            History.getInstance().addRecord(new RecordForTransfer(this.id, this.date, BankingOperationType.OUTCOMINGTRANSFER, amount, toProduct.getId(), fromProduct.getId()));
        } catch (Exception e) {
            History.getInstance().addRecord(new RecordForTransfer(this.id, this.date, BankingOperationType.REJECTEDTRANSFER, amount, toProduct.getId(), fromProduct.getId()));
            throw e;
        }
    }

    public void incomingCashOperation(Integer amount, Product toProduct) {
        toProduct.addCash(amount);
        History.getInstance().addRecord(new RecordForCash(this.id, this.date, BankingOperationType.INCOMINGCASH, amount, "", toProduct.getId()));
    }

    public void outcomingCashOperation(Integer amount, Product fromProduct) throws Exception {
        try{
            fromProduct.getCash(amount);
            History.getInstance().addRecord(new RecordForCash(this.id, this.date, BankingOperationType.OUTCOMINGCASH, amount, fromProduct.getId(), ""));
        } catch (Exception e){
            History.getInstance().addRecord(new RecordForCash(this.id, this.date, BankingOperationType.REJECTEDCASH, amount, fromProduct.getId(), ""));
            throw e;
        }
    }



}



