import java.util.ArrayList;
import java.util.List;

/**
 * Created by krzysztof on 31/03/2017.
 */
public class Report implements Printable {

    private List<Record> records = new ArrayList<>();

    public Report(List<Record> records) {
        this.records = records;
    }

    @Override
    public void print() {
        System.out.println("===============REPORT===============");
        for (Record record : records) {
            record.print();
        }
        System.out.println("====================================");
    }
}
