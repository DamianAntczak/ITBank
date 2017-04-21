import java.util.Date;

/**
 * Created by marcinkarmelita on 21/04/17.
 */

public class Operation implements Cloneable, IOperation {
    private Double amount;
    private IProduct product;
    private String id;
    private Date date;

    public Operation(Double amount, IProduct product) {
        this.amount = amount;
        this.product = product;
        this.id = NumberFactory.getInstance().createNumberForBankingOperation();
        this.date = new Date();
    }

    @Override
    public Double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public IProduct getProduct() {
        return product;
    }

    @Override
    public void setProduct(IProduct product) {
        this.product = product;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}