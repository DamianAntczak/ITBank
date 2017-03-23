import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by krzysztof on 17/03/2017.
 */
public class ClientTest {


    Client client = null;

    @Before
    public void setUp() throws Exception {
        client = new Client("1#43xZ", "Jan", "Kowalski", "Piotrowo");
    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void addProduct() throws Exception {
        client.addProduct("111");
        assertEquals(1, client.getProductsIds().size());
    }

    @Test
    public void getProductId() throws Exception {
        client.addProduct("111");
        client.addProduct("222");
        client.addProduct("333");

        assertEquals("222", client.getProductId(1));
    }

    @Test
    public void getProductsIds() throws Exception {
        List<String> products = new ArrayList<>();
        products.add("111");
        products.add("222");
        products.add("333");

        for (String product : products)
            client.addProduct(product);

        assertEquals(products, client.getProductsIds());
    }

    @Test
    public void removeProductForId() throws Exception {
        List<String> products = new ArrayList<>();
        products.add("111");
        products.add("222");
        products.add("333");

        for (String product : products)
            client.addProduct(product);

        products.remove(1);
        client.removeProductForId("222");

        assertEquals(products, client.getProductsIds());
    }
}