import org.junit.Assert;
import org.junit.Test;

/**
 * Created by marcinkarmelita on 31/03/17.
 */
public class NumberFactoryTest {

    NumberFactory fixture;

    @Test
    public void createNumberForBank() throws Exception {
        String bankNumber1 = fixture.getInstance().createNumberForBank("TTC");
        String bankNumber2 = fixture.getInstance().createNumberForBank("TTC");

        Assert.assertNotNull(bankNumber1, bankNumber2);
    }

    @Test
    public void testClientNumberInc() throws Exception {
        Integer firstValue = Integer.valueOf(fixture.getInstance().createNumberForClient());
        Integer secondValue = Integer.valueOf(fixture.getInstance().createNumberForClient());

        Assert.assertTrue(firstValue + 1 == secondValue);
    }

    @Test
    public void testProductNumberInc() throws Exception {

        String productNumber1 = fixture.getInstance().createNumberForProduct();
        String productNumber2 = fixture.getInstance().createNumberForProduct();

        Integer firstValue = Integer.valueOf(productNumber1.substring(productNumber1.length()-4, productNumber1.length()));
        Integer secondValue = Integer.valueOf(productNumber2.substring(productNumber2.length()-4, productNumber2.length()));

        Assert.assertTrue(firstValue + 1 == secondValue);
    }

    @Test
    public void testBankingOperationInc() {
        String bankingOperationNumber1 = fixture.getInstance().createNumberForBankingOperation();
        String bankingOperationNumber2 = fixture.getInstance().createNumberForBankingOperation();

        Integer firstValue = Integer.valueOf(bankingOperationNumber1.substring(bankingOperationNumber1.length()-4, bankingOperationNumber1.length()));
        Integer secondValue = Integer.valueOf(bankingOperationNumber2.substring(bankingOperationNumber2.length()-4, bankingOperationNumber2.length()));

        Assert.assertTrue(firstValue + 1 == secondValue);
    }
}