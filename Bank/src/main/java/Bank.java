import java.util.*;

import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by student on 10.03.2017.
 */
public class Bank implements Findable<IProduct> {
    private List<IProduct> products = new ArrayList<IProduct>();
    private BankCommandHandler commandHandler;

    private String number = NumberFactory.getInstance().createNumberForBank("TTO");

    public Bank() {
        commandHandler = new BankCommandHandler();
    }

    public String getNumber() {
        return number;
    }

    public Client createClient(String name, String surname, String address) {
        return new Client(NumberFactory.getInstance().createNumberForClient(), name, surname, address);
    }

    public String addProductForClient(IProduct product) {
        products.add(product);
        new BankingOperation().addingOperation(product.getId(), product.getBalance());
        return product.getId();
    }

    private IProduct getProduct(String productId) {
        return findFirst(products, c -> c.getId().equals(productId))
                .orElseGet(null);
    }

    public void doOperation(Command command) {
        commandHandler.handle(command);
    }

    private boolean removeProduct(String productId) {

        Optional<IProduct> optional = findFirst(products, product -> product.getId() == productId);
        return optional.map(p -> products.remove(p)).orElse(false);
    }

    public void removeProduct(Client client, String productId) {
        if (this.removeProduct(productId)) {
            client.removeProductForId(productId);
            new BankingOperation().removingOperation(productId, true);
            return;
        }
        new BankingOperation().removingOperation(productId, false);
    }

    // TODO: 29/04/17 (MK): Needs to be refactored.
    public Report createReportFor(String productId, List<BankingOperation.BankingOperationType> operationTypes, Date startDate, Date endDate) {

        List<Record> records = new ArrayList<>();

        if (operationTypes == null) {
            operationTypes = new ArrayList<>();
            for (BankingOperation.BankingOperationType type : BankingOperation.BankingOperationType.values()) {
                operationTypes.add(type);
            }
        }

        for (BankingOperation.BankingOperationType type : operationTypes) {
            if (type == BankingOperation.BankingOperationType.product_removed ||
                    type == BankingOperation.BankingOperationType.product_denied_to_remove ||
                    type == BankingOperation.BankingOperationType.product_added) {

                Predicate<Record> typePredicate = (p) -> p.getType().equals(type);
                List<RecordForAction> actionRecords = (List<RecordForAction>)(List<?>) History.getInstance().filter(typePredicate);

                Predicate<RecordForAction> actionPredicate = (p) -> p.getProductNo().equals(productId);
                records.addAll(actionRecords.stream().filter(actionPredicate).collect(Collectors.toList()));

            } else {

                Predicate<Record> typePredicate = (p) -> p.getType().equals(type);
                List<RecordForTransfer> transferRecords = (List<RecordForTransfer>)(List<?>) History.getInstance().filter(typePredicate);

                Predicate<RecordForTransfer> predicate2 = (p) -> p.getToProductNo().equals(productId) || p.getFromProductNo().equals(productId);
                records.addAll(transferRecords.stream().filter(predicate2).collect(Collectors.toList()));

            }
        }

        if (startDate != null) {
            Predicate<Record> datePredicate = (p) -> p.getDate().compareTo(startDate) >= 0;
            records.removeAll(records.stream().filter(datePredicate).collect(Collectors.toList()));
        }

        if (endDate != null) {
            Predicate<Record> datePredicate = (p) -> p.getDate().compareTo(endDate) <= 0;
            records.removeAll(records.stream().filter(datePredicate).collect(Collectors.toList()));
        }


        return new Report(records);
    }

    @Override
    public Optional<IProduct> findFirst(Collection<IProduct> collection, Predicate<IProduct> predicate) {
        return collection.stream().filter(predicate).findFirst();
    }

    @Override
    public Collection<IProduct> findAny(Collection<IProduct> collection, Predicate<IProduct> predicate) {
        return collection.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public boolean contains(Collection<IProduct> collection, Predicate<IProduct> predicate) {
        return collection.stream().anyMatch(predicate);
    }
}
