//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//
//import java.util.Arrays;
//import java.util.Collection;
//
///**
// * Created by Damian on 17.03.2017.
// */
//@RunWith(Parameterized.class)
//public class InterestTest {
//
//    Interest.Interest interest = null;
//
//    @Parameterized.Parameters
//    public static Collection<Object[]> data(){
//        return Arrays.asList(new Object[][] {
//                { Interest.InterestFrequency.yearly, 5, 1.05}, {Interest.InterestFrequency.quarterly, 5, 1.05094},{Interest.InterestFrequency.monthly,2,1.02019}
//        });
//    }
//
//    private Interest.InterestFrequency interestFrequency;
//    private int percent;
//    private double expected;
//
//    public InterestTest(Interest.InterestFrequency interestFrequency, int percent, double expected){
//        this.interestFrequency = interestFrequency;
//        this.percent = percent;
//        this.expected = expected;
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        interest = new Interest.Interest(this.interestFrequency,this.percent);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        interest = null;
//    }
//
//    @Test
//    public void interestCalculationYearly() throws Exception {
//        double calculatedInterest = interest.interestCalculation(12);
//        Assert.assertEquals(this.expected,calculatedInterest,0.0001);
//    }
//
//
//}