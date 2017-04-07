/**
 * Created by Damian on 16.03.2017.
 */
public abstract  class Interest {
    private InterestFrequency interestFrequency;

    public Interest(InterestFrequency interestFrequency){
        this.interestFrequency = interestFrequency;
    }

    protected abstract  double InterestCalculation(int numberOfMonths, double balance);
}
