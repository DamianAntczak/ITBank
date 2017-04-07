//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.awt.geom.Arc2D;
//
//import static org.junit.Assert.*;
//
///**
// * Created by marcinkarmelita on 17/03/17.
// */
//public class CreditTest {
//
//    Credit credit = null;
//
//    @Before
//    public void setUp() throws Exception {
//        credit = new Credit("1234", new InterestExample(InterestFrequency.halfYearly), 1000);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        credit = null;
//    }
//
//
//
//    @Test
//    public void addCash() throws Exception {
//        credit.addCash(123.0);
//        assertEquals(1123.0, credit.getBalance(), 0.01);
//    }
//
//    @Test
//    public void close() throws Exception {
//        assertEquals(1050.0, credit.close(12), 0.01);
//    }
//
//}