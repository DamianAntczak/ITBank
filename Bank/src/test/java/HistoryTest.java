import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertNotNull;
import static org.powermock.api.easymock.PowerMock.replay;
import static org.powermock.api.easymock.PowerMock.verify;

/**
 * Created by krzysztof on 23/03/2017.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(History.class)
public class HistoryTest {

    @Before
    public void setUp() throws Exception {
        replay(History.class);
        verify(History.class);
    }

    @Test
    public void filterByID() throws Exception {
        Record record1 = new RecordForAction("123", new Date(), BankingOperation.BankingOperationType.incoming_cash,0.0, "123122");
        Record record2 = new RecordForAction("124", new Date(), BankingOperation.BankingOperationType.incoming_cash, 0.0, "123122");
        Record record3 = new RecordForAction("125", new Date(), BankingOperation.BankingOperationType.incoming_cash, 0.0, "123124");

        History.getInstance().addRecord(record1);
        History.getInstance().addRecord(record2);
        History.getInstance().addRecord(record3);

        Predicate<Record> predicate = (p) -> p.getId().equals("123");
        final List<Record> filterRecordList = History.getInstance().filter(predicate);

        Assert.assertEquals(1,filterRecordList.size());
    }

    @Test
    public void filterByType() throws Exception {
        Record r1 = new RecordForAction("1", new Date(), BankingOperation.BankingOperationType.incoming_cash,0.0, "1234");
        Record r2 = new RecordForTransfer("2", new Date(), BankingOperation.BankingOperationType.transfer,0.0,200,"125","1234");
        Record r3 = new RecordForTransfer("3", new Date(), BankingOperation.BankingOperationType.transfer, 0.0,400,"545","4856");

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
        Record r1 = new RecordForAction("1", c.getTime(), BankingOperation.BankingOperationType.incoming_cash, 0.0, "123");
        c.set(2017,Calendar.MARCH, 18);
        Record r2 = new RecordForAction("2", c.getTime(), BankingOperation.BankingOperationType.transfer, 0.0, "345");
        c.set(2017,Calendar.JANUARY, 18);
        Record r3 = new RecordForAction("3", c.getTime(), BankingOperation.BankingOperationType.transfer, 0.0, "345");

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


    @After
    public void tearDown() throws Exception {

    }
    
}


