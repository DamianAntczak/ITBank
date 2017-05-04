/**
 * Created by krzysztof on 28/04/2017.
 */
public interface Visitable {
    public IProduct accept(AllReports reports);
    public IProduct accept(ReportOver reports);
}