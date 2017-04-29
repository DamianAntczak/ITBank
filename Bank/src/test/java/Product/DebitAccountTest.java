package Product;

import Client.Client;
import Product.DebitAccount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Damian on 21.04.2017.
 */
public class DebitAccountTest {

    private DebitAccount fixture;

    @Before
    public void setUp() throws Exception {
        fixture = new DebitAccount(new Client("1234", "Jan", "Kowalski", "Nowa 22").getId(), 200.00);
        fixture.addCash(100);
    }

    @Test
    public void getCash() throws Exception {
        fixture.getCash(200.0);
        Assert.assertEquals(100.0, fixture.getDebit(), 0.0001);
    }

    @Test
    public void getCash2() throws Exception {
        System.out.println(fixture.getBalance());
        fixture.getCash(50);
        Assert.assertEquals(50.0, fixture.getBalance(), 0.0001);
    }

}