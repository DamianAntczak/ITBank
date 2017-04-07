import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Damian on 07.04.2017.
 */

@RunWith(Parameterized.class)
public class InterestExponentialTest {



    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
                { 1000, 30}, { 2000, 120},{4000,480}
        });
    }

    public InterestExponentialTest( double balance, double expected){
        this.expected = expected;
        this.balance = balance;
    }

    InterestExponential fixture;
    private double expected;
    private double balance;

    @Before
    public void setUp() throws Exception {
        fixture = new InterestExponential(InterestFrequency.monthly);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void interestCalculation() throws Exception {
        double result = fixture.interestCalculation(5,this.balance);
        Assert.assertEquals(this.expected, result, 0.001);

    }

}