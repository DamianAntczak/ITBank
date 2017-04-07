/**
 * Created by Damian on 07.04.2017.
 */
public class InterestExponential extends Interest {

    public InterestExponential(InterestFrequency interestFrequency){
        super(interestFrequency);
    }

    @Override
    protected double interestCalculation(int numberOfMonths, double balance) {
        Double procent = 0.03 * balance/1000;
        return balance * procent;
    }
}
