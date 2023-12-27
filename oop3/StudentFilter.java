import java.util.function.Predicate;

/**
 * Functional interface for testing a student
 *
 * @author Lawrence Li
 */
@FunctionalInterface
public interface StudentFilter extends Predicate<Student> {}
