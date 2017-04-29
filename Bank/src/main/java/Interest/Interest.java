package Interest;

/**
 * Created by Damian on 16.03.2017.
 */
public abstract class Interest {
    public InterestFrequency interestFrequency;

    public Interest(InterestFrequency interestFrequency) {
        this.interestFrequency = interestFrequency;
    }

    public abstract double interestCalculation(int numberOfMonths, double balance);
}
