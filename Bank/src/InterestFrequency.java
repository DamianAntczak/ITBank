/**
 * Created by Damian on 16.03.2017.
 */
public enum InterestFrequency {
    monthly(1),
    quarterly(3),
    halfYearly(6),
    yearly(12);

    private int id;
    InterestFrequency(int id) { this.id = id; }
    public int getValue() { return id; }
}
