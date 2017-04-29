package Operation;

import Product.IProduct;

import java.util.Date;

/**
 * Created by marcinkarmelita on 21/04/17.
 */
public interface IOperation {
    Double getAmount();

    void setAmount(Double amount);

    IProduct getProduct();

    void setProduct(IProduct product);

    String getId();

    void setId(String id);

    Date getDate();

    void setDate(Date date);
}
