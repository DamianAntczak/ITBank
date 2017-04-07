/**
 * Created by Damian on 16.03.2017.
 */
public abstract  class Interest {
    protected InterestFrequency interestFrequency;

    public Interest(InterestFrequency interestFrequency){
        this.interestFrequency = interestFrequency;
    }

    protected abstract  double interestCalculation(int numberOfMonths, double balance);
}
