/**
 * Created by Damian on 16.03.2017.
 */
public abstract  class Interest {
    private InterestFrequency interestFrequency;
    private Product product;

    public Interest(InterestFrequency interestFrequency, Product product){
        this.interestFrequency = interestFrequency;
        this.product = product;
    }

    protected abstract  double InterestCalculation(int numberOfMonths);
}
