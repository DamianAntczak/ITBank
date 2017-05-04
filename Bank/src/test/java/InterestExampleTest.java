import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by krzysztof on 07/04/2017.
 */
public class InterestExampleTest {
    Interest interest;

    @Before
    public void setUp() throws Exception {
        interest = new InterestExample(InterestFrequency.yearly);
    }

    @After
    public void tearDown() throws Exception {
        interest = null;
    }

    @Test
    public void interestCalculation() throws Exception {
        assertEquals(500, interest.interestCalculation(12, 100000), 0.1);
    }

}