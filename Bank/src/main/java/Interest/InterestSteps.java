package Interest;

/**
 * Created by marcinkarmelita on 07/04/17.
 */
public class InterestSteps extends Interest {
    private double step;

    public InterestSteps(InterestFrequency interestFrequency) {
        super(interestFrequency);
        step = 0.5;
    }

    @Override
    public double interestCalculation(int numberOfMonths, double balance) {
        if (balance > 10000) {
            step = 0.5;
        } else if (balance > 1000) {
            step = 1.0;
        } else {
            step = 1.5;
        }
        return step * interestFrequency.getValue() * balance / 100;
    }
}
