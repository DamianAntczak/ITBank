import java.util.Date;

/**
 * Created by Damian on 21.04.2017.
 */
public interface IProduct {
    String getId();
    double getBalance();
    Date getCreatedAt();
    void addCash(double amount);
    double getCash(double amount) throws RuntimeException;
    double close(int numberOfMonths) throws RuntimeException;
}
