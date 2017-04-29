package Command;

import Command.*;
import Product.BankAccount;
import Product.IProduct;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by marcinkarmelita on 28/04/17.
 */
public class TransferCommandTest {
    private Double delta = 0.001;
    Command fixture;
    IProduct from;
    IProduct to;

    @Before
    public void setUp() throws Exception {
        from = new BankAccount("owner");
        to = new BankAccount("owner");
        fixture = new TransferCommand(from, to, 200.0);
    }

    @Test
    public void isInternal() throws Exception {
        // TODO (MK): Implement
    }

    @Test(expected = RuntimeException.class)
    public void executeNotOK() throws Exception {
        fixture.execute();
    }

    @Test
    public void executeOK() throws Exception {
        from.addCash(500);
        fixture.execute();
        Assert.assertEquals(to.getBalance(), 200.0, delta);
    }

    @Test(expected = RuntimeException.class)
    public void executeTwice() throws Exception {
        from.addCash(500);
        fixture.execute();
        fixture.execute();
    }
}