import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.ExpectedExceptions;

import static org.junit.Assert.*;

/**
 * Created by marcinkarmelita on 28/04/17.
 */
public class IncomingCashCommandTest {

    IncomingCashCommand fixture;
    IProduct product;

    @Before
    public void setUp() throws Exception {
        product = new BankAccount("");
        fixture = new IncomingCashCommand(200.0, product);
    }

    @Test
    public void execute() throws Exception {
        Assert.assertEquals(product.getBalance(), 0.0, 0.001);
        fixture.execute();
        Assert.assertEquals(product.getBalance(), 200.0, 0.001);
    }


    @Test(expected = RuntimeException.class)
    public void executeTwice() throws Exception {
        fixture.execute();
        fixture.execute();
    }

    @After
    public void tearDown() throws Exception {

    }

}