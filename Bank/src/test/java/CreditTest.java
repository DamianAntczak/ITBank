import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.Assert;

import java.awt.geom.Arc2D;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by marcinkarmelita on 17/03/17.
 */

@RunWith(Parameterized.class)
public class CreditTest {

    Credit credit = null;

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
                { new InterestSteps(InterestFrequency.halfYearly), 910} });
    }

    private Interest interest;
    private double expected;

    public CreditTest(Interest interest, double expected){
        this.interest = interest;
        this.expected = expected;
    }

    @Before
    public void setUp() throws Exception {
        credit = new Credit("1234", this.interest, 1000);
    }

    @After
    public void tearDown() throws Exception {
        credit = null;
    }

    @Test
    public void addCash() throws Exception {
        credit.addCash(123.0);
        assertEquals(1123.0, credit.getBalance(), 0.01);
    }

    @Test
    public void close() throws Exception {
        assertEquals(this.expected, credit.close(12), 0.01);
    }
}
