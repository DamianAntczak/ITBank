import java.util.Date;
import java.util.UUID;

/**
 * Created by marcinkarmelita on 16/03/17.
 */
public class RecordForAction extends Record {
    private String productNo;


    public RecordForAction(String id, Date date, BankingOperation.BankingOperationType type, String productNo) {
        super(id, date, type);
        this.productNo = productNo;
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String string = "REKORD: \n";
        string += "ID: " + this.id + "\n";
        string += "Date: " + this.date.toString() + "\n";
        string += "Type: " + this.type.toString() + "\n";
        string += "Number: " + this.productNo + "\n";
        return string;
    }
}