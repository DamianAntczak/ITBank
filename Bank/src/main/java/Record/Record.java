package Record;

import Operation.BankingOperation;

import java.util.Date;

/**
 * Created by marcinkarmelita on 16/03/17.
 */
public abstract class Record {
    String id;
    Date date;
    BankingOperation.BankingOperationType type;
    Double actualBalance;

    public Record(String id, Date date, BankingOperation.BankingOperationType type, Double actualBalance) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.actualBalance = actualBalance;
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public BankingOperation.BankingOperationType getType() {
        return type;
    }
}
