import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by Damian on 23.03.2017.
 */
public class DepositTest {

    public Deposit deposit;

    @Before
    public void setUp(){
        Client owner = new Client(UUID.randomUUID().toString(),"Jan","Nowak","Nowa");
        deposit = new Deposit(owner.getId(),new Interest(InterestFrequency.yearly,5),5000);
    }

    @Test
    public void addCash() throws Exception{
        deposit.addCash(2000);
        Assert.assertEquals(deposit.getBalance(),7000,0.000001);
    }

    @Test
    public void getCash() throws Exception{
        Assert.assertEquals(deposit.getCash(2000),false);
    }

    @Test
    public void close() throws Exception{
        double amount = deposit.close(12);
        Assert.assertEquals(amount,5250,0.00001);

    }

    @Test
    public void terminate() throws Exception{
        deposit.terminate();
        Assert.assertEquals(deposit.getBalance(),0,0.00001);
    }
}