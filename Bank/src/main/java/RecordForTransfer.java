import java.util.Date;

public class RecordForTransfer extends Record {
    private Double amount;
    private String fromProductNo;
    private String toProductNo;


    public RecordForTransfer(String id, Date date, BankingOperation.BankingOperationType type, Double actualBalance, Double amount, String fromProductNo, String toProductNo) {
        super(id, date, type, actualBalance);
        this.amount = amount;
        this.fromProductNo = fromProductNo;
        this.toProductNo = toProductNo;
    }

    public String getFromProductNo() {
        return fromProductNo;
    }

    public String getToProductNo() {
        return toProductNo;
    }

    @Override
    public String toString() {
        String string = "REKORD:" + System.lineSeparator();
        string += "ID: " + this.id + System.lineSeparator();
        string += "Date: " + this.date.toString() + System.lineSeparator();
        string += "Type: " + this.type.toString() + System.lineSeparator();
        string += "Balance: " + this.actualBalance.toString() + System.lineSeparator();
        string += "Amount: " + this.amount.toString() + System.lineSeparator();
        string += "From: " + this.fromProductNo + System.lineSeparator();
        string += "To: " + this.toProductNo + System.lineSeparator();
        return string;
    }
}
