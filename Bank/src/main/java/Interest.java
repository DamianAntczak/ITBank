/**
 * Created by Damian on 16.03.2017.
 */
public class Interest {
    private double percent;
    private InterestFrequency interestFrequency;

    public Interest(InterestFrequency interestFrequency, double percent){
        this.interestFrequency = interestFrequency;
        this.percent = percent;
    }

    public double InterestCalculation(int numberOfMonths){
        if(this.interestFrequency == InterestFrequency.yearly) {
            int numberOfCapitalization = numberOfMonths / interestFrequency.getValue();
            System.out.println(numberOfCapitalization);
            return Math.pow(1 + (percent / 100), Math.floor(numberOfCapitalization));
        }
        else{
            int numberOfCapitalization = numberOfMonths / interestFrequency.getValue();
            return Math.pow(1 + ((percent / 100)/numberOfCapitalization), Math.floor(numberOfCapitalization));
        }
    }
}
