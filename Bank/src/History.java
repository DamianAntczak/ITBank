import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcinkarmelita on 10/03/17.
 */
public class History {
    private static History ourInstance = new History();

    public static History getInstance() {
        return ourInstance;
    }

    private History() {}

    private List<Record> records = new ArrayList<>();

    public void addRecord(Record record) {
        this.records.add(record);
    }

    public void printRecords() {
        for (Record record : records) {
            record.print();
        }
    }

}
