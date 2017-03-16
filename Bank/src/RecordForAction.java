import java.util.Date;

/**
 * Created by marcinkarmelita on 16/03/17.
 */
public class RecordForAction extends Record {
    private String productNo;


    public RecordForAction(String id, Date date, BankingOperation.BankingOperationType type, String productNo) {
        super(id, date, type);
        this.productNo = productNo;
    }
}