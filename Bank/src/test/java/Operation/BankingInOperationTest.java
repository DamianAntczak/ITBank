package Operation;

import Operation.BankingOperation;
import org.junit.After;
import org.junit.Before;

/**
 * Created by marcinkarmelita on 23/03/17.
 */
public class BankingInOperationTest {

    BankingOperation fixture;

    @Before
    public void setUp() throws Exception {
        fixture = new BankingOperation();
    }

    @After
    public void tearDown() throws Exception {

    }

//    @Test(expected = RuntimeException.class)
//    public void transferOperationException() throws Exception {
//        // (MK): Balance at newly created account equals 0
//        Product.IProduct fromProduct = new Product.BankAccount("765984327574385");
//        Product.IProduct toProduct = new Product.BankAccount("45378783429");
//        Operation.BankingOperation bankingOperation = new Operation.BankingOperation();
//        bankingOperation.transferOperation(200, fromProduct, toProduct);
//    }
//
//    @Test
//    public void transferOperationSuccess() throws Exception {
//        // (MK): Balance at newly created account equals 0
//        Product.IProduct fromProduct = new Product.BankAccount("765984327574385");
//        Product.IProduct toProduct = new Product.BankAccount("45378783429");
//        ((Cashable) fromProduct).addCash(500);
//        Operation.BankingOperation bankingOperation = new Operation.BankingOperation();
//        bankingOperation.transferOperation(200, (Cashable) fromProduct, (Cashable) toProduct);
//    }
//
//    @Test
//    public void incomingCashOperation() throws Exception {
//        Product.IProduct toProduct = new Product.BankAccount("45378783429");
//        Operation.BankingOperation bankingOperation = new Operation.BankingOperation();
//        bankingOperation.incomingCashOperation(500, (Cashable) toProduct);
//        assertEquals(toProduct.getBalance(), 500, 0.1);
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void outcomingCashOperationException() throws Exception {
//        Product.IProduct fromProduct = new Product.BankAccount("45378783429");
//        Operation.BankingOperation bankingOperation = new Operation.BankingOperation();
//        bankingOperation.outcomingCashOperation(200, (Cashable) fromProduct);
//    }
//
//    @Test
//    public void outcomingCashOperationSuccess() throws Exception {
//        Product.BankAccount fromProduct = new Product.BankAccount("45378783429");
//        fromProduct.addCash(500);
//        Operation.BankingOperation bankingOperation = new Operation.BankingOperation();
//        bankingOperation.outcomingCashOperation(200, fromProduct);
//    }

}