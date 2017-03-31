import org.junit.Assert;
import org.junit.Test;

/**
 * Created by marcinkarmelita on 31/03/17.
 */
public class NumberFactoryTest {
    NumberFactory fixture;

    @Test
    public void createNumberForClient() throws Exception {
        Integer firstValue = Integer.valueOf(fixture.getInstance().createNumberForClient());
        Integer secondValue = Integer.valueOf(fixture.getInstance().createNumberForClient());

        Assert.assertTrue(firstValue + 1 == secondValue);
    }

    @Test
    public void createNumberForProduct() throws Exception {

        String productNumber1 = fixture.getInstance().createNumberForProduct();
        String productNumber2 = fixture.getInstance().createNumberForProduct();

        Integer firstValue = Integer.valueOf(productNumber1.substring(productNumber1.length()-4, productNumber1.length()));
        Integer secondValue = Integer.valueOf(productNumber2.substring(productNumber2.length()-4, productNumber2.length()));

        Assert.assertTrue(firstValue + 1 == secondValue);
    }

}