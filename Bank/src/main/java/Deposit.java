/**
 * Created by Damian on 16.03.2017.
 */
public class Deposit extends Product {
    private Interest interest;

    public Deposit(String ownerId, Interest interest, double amount) {
        super(ownerId, "Deposit");
        this.interest = interest;
        this.balance = amount;
    }

    private double calculate(int numberOfMonths) {
        return  this.balance + this.interest.interestCalculation(numberOfMonths, balance);
    }

    @Override
    double close(int numberOfMonths) {
        double amount = this.calculate(numberOfMonths);
        this.balance = 0;
        return amount;
    }

    double terminate() {
        double amount = this.balance;
        this.balance = 0;
        return amount;
    }

    @Override
    public void addCash(double amount) {
        throw new RuntimeException("Not allowed");
    }

    @Override
    public double getCash(double amount) throws RuntimeException {
        throw new RuntimeException("Not allowed");
    }

    @Override
    public IProduct accept(AllReports reports) {
        return reports.visit(this);
    }

    @Override
    public IProduct accept(ReportOver reports) {
        return reports.visit(this);
    }

//    @Override
//    public Product accept(AllReports reports) {
//        return reports.visit(this);
//    }


}
