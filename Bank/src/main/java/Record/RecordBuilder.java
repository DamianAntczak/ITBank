package Record;

import Operation.BankingOperation;

import java.util.Date;

/**
 * Created by marcinkarmelita on 29/04/17.
 */
public class RecordBuilder {
    // FIXME: 29/04/17 (MK): Not sure if this class is going to be used.
    
    private String id;
    private Date date;
    private BankingOperation.BankingOperationType type;
    private Double actualBalance;
    private Double amount;
    private String fromProductNo;
    private String toProductNo;
    
    private RecordBuilder(String id) {
        this.id = id;
    }
    
    static RecordBuilder id(String id) {
        return new RecordBuilder(id);
    }

    RecordBuilder date(Date date) {
        this.date = date;
        return this;
    }

    RecordBuilder type(BankingOperation.BankingOperationType amount) {
        this.type = type;
        return this;
    }

    RecordBuilder actualBalance(Double actualBalance) {
        this.actualBalance = actualBalance;
        return this;
    }

    RecordBuilder amount(Double amount) {
        this.amount = amount;
        return this;
    }

    RecordBuilder fromProductNo(String fromProductNo) {
        this.fromProductNo = fromProductNo;
        return this;
    }

    RecordBuilder toProductNo(String toProductNo) {
        this.toProductNo = toProductNo;
        return this;
    }
    
}
