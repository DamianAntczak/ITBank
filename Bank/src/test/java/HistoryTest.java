import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.*;

/**
 * Created by krzysztof on 23/03/2017.
 */
public class HistoryTest {
    @Test
    public void filterByID() throws Exception {
        Record record1 = new RecordForAction("123", new Date(), BankingOperation.BankingOperationType.incoming_cash, "123122");
        Record record2 = new RecordForAction("124", new Date(), BankingOperation.BankingOperationType.incoming_cash, "123122");
        Record record3 = new RecordForAction("125", new Date(), BankingOperation.BankingOperationType.incoming_cash, "123124");

        History.getInstance().addRecord(record1);
        History.getInstance().addRecord(record2);
        History.getInstance().addRecord(record3);

        Predicate<Record> predicate = (p) -> p.getId().equals("123");
        final List<Record> filterRecordList = History.getInstance().filter(predicate);

        Assert.assertEquals(1,filterRecordList.size());
    }

    @Test
    public void filterByType() throws Exception {
        Record r1 = new RecordForAction("1", new Date(), BankingOperation.BankingOperationType.incoming_cash, "1234");
        Record r2 = new RecordForTransfer("2", new Date(), BankingOperation.BankingOperationType.transfer,200,"125","1234");
        Record r3 = new RecordForTransfer("3", new Date(), BankingOperation.BankingOperationType.transfer,400,"545","4856");

        History.getInstance().addRecord(r1);
        History.getInstance().addRecord(r2);
        History.getInstance().addRecord(r3);

        Predicate<Record> predicate = (p) -> p.getType().equals(BankingOperation.BankingOperationType.transfer);
        final List<Record> filterRecordList = History.getInstance().filter(predicate);

        Assert.assertEquals(2,filterRecordList.size());
    }

    @Test
    public void filterByDate() throws Exception {
        Calendar c = Calendar.getInstance();
        c.set(2017,Calendar.MARCH, 24);
        Record r1 = new RecordForAction("1", c.getTime(), BankingOperation.BankingOperationType.INCOMINGCASH, "123");
        c.set(2017,Calendar.MARCH, 18);
        Record r2 = new RecordForAction("2", c.getTime(), BankingOperation.BankingOperationType.INCOMINGCASH, "345");
        c.set(2017,Calendar.JANUARY, 18);
        Record r3 = new RecordForAction("3", c.getTime(), BankingOperation.BankingOperationType.OUTCOMINGCASH, "345");

        History.getInstance().addRecord(r1);
        History.getInstance().addRecord(r2);
        History.getInstance().addRecord(r3);

        Predicate<Record> predicate = (p) -> p.getDate().getMonth() == Calendar.MARCH;
        final List<Record> filterRecordList = History.getInstance().filter(predicate);

        Assert.assertEquals(2, filterRecordList.size());
    }

    @Test
    public void getInstance() throws Exception {
        assertNotNull(History.getInstance());
    }

}