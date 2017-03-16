import java.util.Date;

public class RecordForTransfer extends Record {
    private Integer amount;
    private String fromProductNo;
    private String toProductNo;


    public RecordForTransfer(String id, Date date, BankingOperation.BankingOperationType type, Integer amount, String fromProductNo, String toProductNo) {
        super(id, date, type);
        this.amount = amount;
        this.fromProductNo = fromProductNo;
        this.toProductNo = toProductNo;
    }
}
