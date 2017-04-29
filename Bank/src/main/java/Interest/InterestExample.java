package Interest;

/**
 * Created by krzysztof on 07/04/2017.
 */
public class InterestExample extends Interest {

    public InterestExample(InterestFrequency interestFrequency) {
        super(interestFrequency);
    }

    @Override
    public double interestCalculation(int numberOfMonths, double balance) {
        return (balance * 0.5 / 100);
    }
}
