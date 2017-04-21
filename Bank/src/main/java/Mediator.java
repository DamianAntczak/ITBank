/**
 * Created by marcinkarmelita on 21/04/17.
 */
public interface Mediator {
    public void transferOperation(Integer amount, IProduct from, IProduct to) throws RuntimeException;
}
