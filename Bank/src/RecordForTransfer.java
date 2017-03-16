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
        string += "Amount: " + this.amount.toString() + "\n";
        string += "From: " + this.fromProductNo + "\n";
        string += "To: " + this.toProductNo + "\n";
        return string;
    }
}
