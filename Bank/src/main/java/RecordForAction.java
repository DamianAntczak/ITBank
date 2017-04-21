import java.util.Date;
import java.util.UUID;

/**
 * Created by marcinkarmelita on 16/03/17.
 */
public class RecordForAction extends Record {
    private String productNo;

    public RecordForAction(String id, Date date, BankingOperation.BankingOperationType type, Double actualBalance, String productNo) {
        super(id, date, type, actualBalance);
        this.productNo = productNo;
    }

    public String getProductNo() {
        return productNo;
    }

    @Override
    public String toString() {
        String string = "REKORD: " + System.lineSeparator();
        string += "ID: " + this.id + System.lineSeparator();
        string += "Date: " + this.date.toString() + System.lineSeparator();
        string += "Type: " + this.type.toString() + System.lineSeparator();
        string += "Balance: " + this.actualBalance.toString() + System.lineSeparator();
        string += "Number: " + this.productNo + System.lineSeparator();
        return string;
    }
}