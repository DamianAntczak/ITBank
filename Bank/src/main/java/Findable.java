import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Created by marcinkarmelita on 29/04/17.
 */
public interface Findable<T> {
    Optional<T> findFirst(Collection<T> collection, Predicate<T> predicate);
    Collection<T> findAny(Collection<T> collection, Predicate<T> predicate);
    boolean contains(Collection<T> collection, Predicate<T> predicate);
}
