/**
 * Created by marcinkarmelita on 21/04/17.
 */
public interface Mediator {
    public void transferOperation(Integer amount, Product from, Product to) throws RuntimeException;
}
