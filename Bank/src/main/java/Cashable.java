/**
 * Created by Damian on 24.03.2017.
 */
public interface Cashable {
    void addCash(double amount);
    double getCash(double amount) throws RuntimeException;
}
