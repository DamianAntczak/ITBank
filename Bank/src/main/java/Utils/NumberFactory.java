package Utils;

import java.util.Random;

/**
 * Created by marcinkarmelita on 31/03/17.
 */
public class NumberFactory {

    private static String swift = "PL09-0000-0001-1090-";
    private Integer lastClientNumber;
    private Integer lastProductNumber;
    private Integer lastBankingOperation;

    private static NumberFactory shared;

    private NumberFactory() {
        // (MK): Initial state
        lastClientNumber = 7969;
        lastProductNumber = 6781;
        lastBankingOperation = 5493;
    }

    public static NumberFactory getInstance() {
        if (shared == null) {
            shared = new NumberFactory();
        }
        return shared;
    }

    public String createNumberForClient() {
        return String.format("%012d", ++lastClientNumber);
    }

    public String createNumberForProduct() {
        StringBuilder str = new StringBuilder(String.format("%012d", ++lastProductNumber));
        int idx = str.length() - 4;

        while (idx > 0) {
            str.insert(idx, "-");
            idx -= 4;
        }
        return swift + str;
    }

    public String createNumberForBank(String bankCode) {
        Random generator = new Random();
        StringBuilder str = new StringBuilder(String.format("%s%d", bankCode, generator.nextInt(9000) + 1000));
        return str.toString();
    }

    public String createNumberForBankingOperation() {
        return String.format("%020d", ++lastBankingOperation);
    }

}
