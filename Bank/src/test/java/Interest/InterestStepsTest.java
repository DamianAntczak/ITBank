package Interest;

import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

/**
 * Created by marcinkarmelita on 07/04/17.
 */
public class InterestStepsTest {
    InterestSteps fixture;

    @Before
    public void setUp() throws Exception {
        fixture = new InterestSteps(InterestFrequency.halfYearly);

    }

    @Test
    public void interestCalculationLow() throws Exception {
        double real = fixture.interestCalculation(6, 10);
        double expected = 1.5 * 6 * 10 / 100;
        Assert.assertEquals(expected, real, 0.001);
    }

    @Test
    public void interestCalculationMedium() throws Exception {
        double real = fixture.interestCalculation(6, 5000);
        double expected = 1.0 * 6 * 5000 / 100;
        Assert.assertEquals(expected, real, 0.001);
    }

    @Test
    public void interestCalculationHigh() throws Exception {
        double real = fixture.interestCalculation(6, 20000);
        double expected = .5 * 6 * 20000 / 100;
        Assert.assertEquals(expected, real, 0.001);
    }
}