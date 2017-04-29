import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by student on 10.03.2017.
 */
public class Bank {
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
        Predicate<IProduct> predicate = c -> c.getId().equals(productId);
        IProduct obj = products.stream().filter(predicate).findFirst().get();
        return obj;
    }

    public void doOperation(Command command) {
        commandHandler.handle(command);
    }


//    public void transferOperation(Double amount, String fromProductId, String toProductId) throws RuntimeException {
//        Product fromProduct = getProduct(fromProductId);
//        Product toProduct = getProduct(toProductId);
//        mediator.queueTransferOperation(bankingOperation.transferOperation(amount, fromProduct, toProduct));
//    }

//    public void incomingCashOperation(Double amount, String toProductId) {
//        Product toProduct = getProduct(toProductId);
//        new BankingOperation().incomingCashOperation(amount, (Cashable) toProduct);
//    }

//    public void outcomingCashOperation(Double amount, String fromProductId) throws RuntimeException {
//        Product fromProduct = getProduct(fromProductId);
//        new BankingOperation().outcomingCashOperation(amount, (Cashable) fromProduct);
//    }

    private boolean removeProduct(String productId) {
        for (IProduct product : products) {
            IProduct prodToDel;
            if (product.getId() == productId) {
                prodToDel = product;
                products.remove(prodToDel);
                return true;
            }
        }
        return false;
    }

    public void removeProduct(Client client, String productId) {
        if (this.removeProduct(productId)) {
            client.removeProductForId(productId);
            new BankingOperation().removingOperation(productId, true);
            return;
        }
        new BankingOperation().removingOperation(productId, true);
    }


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

}
