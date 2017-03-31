import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

//    Predicate<Product> predicate = c -> c.getId().equals(productId);
//    Product obj = products.stream().filter(predicate).findFirst().get();
//        return obj;
//

    public List<Record> filter(Predicate<Record> predicate){
        return  History.getInstance().records.stream().filter(predicate).collect(Collectors.toList());
    }

}
