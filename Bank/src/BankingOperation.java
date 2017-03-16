/**
 * Created by marcinkarmelita on 10/03/17.
 */

import java.rmi.server.UID;
import java.util.Date;

public class BankingOperation {

    enum BankingOperationType {
        incomingTransfer,
        outcomingTransfer,
        rejectedTransfer,
        incomingCash,
        outcomingCash
    }

    private String id;
    private Date date;
    private BankingOperationType bankingOperationType;
    private Integer value;
    private BankAccount fromBankAccount;
    private BankAccount toBankAccount;

    public BankingOperation(BankingOperationType type, Integer value, BankAccount fromBankAccount, BankAccount toBankAccount) {
        new BankingOperation(new UID().toString(), new Date(), type, value, fromBankAccount, toBankAccount);
    }

    private BankingOperation(String id, Date date, BankingOperationType type, Integer value, BankAccount fromBankAccount, BankAccount toBankAccount) {
        this.id = id;
        this.date = date;
        this.bankingOperationType = type;
        this.value = value;
        this.fromBankAccount = fromBankAccount;
        this.toBankAccount = toBankAccount;

        History.getInstance().addRecord(this);
    }
}



