/**
 * Created by marcinkarmelita on 21/04/17.
 */
public interface Command {
    void execute() throws RuntimeException;
    boolean isInternal();
}
