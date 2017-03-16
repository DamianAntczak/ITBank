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
    }

    private String id;
    private Date date;

    public BankingOperation(BankingOperationType type) {
        new BankingOperation(new UID().toString(), new Date());
    }

    private BankingOperation(String id, Date date) {
        this.id = id;
        this.date = date;
    }

    public boolean transferOperation(Integer amount, Product fromProduct, Product toProduct) {
        if (fromProduct.getCash(amount)) {
            toProduct.addCash(amount);
            History.getInstance().addRecord(new RecordForTransfer(this.id, this.date, BankingOperationType.INCOMINGTRANSFER, amount, fromProduct.getNumber().toString(), toProduct.getNumber().toString()));
            History.getInstance().addRecord(new RecordForTransfer(this.id, this.date, BankingOperationType.OUTCOMINGTRANSFER, amount, toProduct.getNumber().toString(), fromProduct.getNumber().toString()));
            return true;
        } else {
            History.getInstance().addRecord(new RecordForTransfer(this.id, this.date, BankingOperationType.REJECTEDTRANSFER, amount, toProduct.getNumber().toString(), fromProduct.getNumber().toString()));
            return false;
        }

    }

    public void incomingCashOperation(Integer amount, Product toProduct) {
        toProduct.addCash(amount);
        History.getInstance().addRecord(new RecordForCash(this.id, this.date, BankingOperationType.INCOMINGCASH, amount, "", toProduct.getNumber().toString()));
    }

    public void outcomingCashOperation(Integer amount, Product fromProduct) {
        if (fromProduct.getCash(amount)) {
            History.getInstance().addRecord(new RecordForCash(this.id, this.date, BankingOperationType.OUTCOMINGCASH, amount, fromProduct.getNumber().toString(), ""));
        } else {
            History.getInstance().addRecord(new RecordForCash(this.id, this.date, BankingOperationType.REJECTEDCASH, amount, fromProduct.getNumber().toString(), ""));
        }
    }



}



