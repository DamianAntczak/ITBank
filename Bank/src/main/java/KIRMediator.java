/**
 * Created by marcinkarmelita on 21/04/17.
 */
public class KIRMediator implements Mediator {

    @Override
    public void transferOperation(Integer amount, IProduct from, IProduct to) throws RuntimeException {
        new BankingOperation().transferOperation(amount, (Cashable) from, (Cashable) to);
    }
}
