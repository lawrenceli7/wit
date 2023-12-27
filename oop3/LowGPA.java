/**
 * @author Lawrence Li
 */
public class LowGPA implements StudentFilter {

  static final double LOW_GPA_THRESH = 1.5;

  /**
   * Filter for students that have a GPA lower than threshold
   *
   * @param s student to consider
   * @return true if student passes
   */
  @Override
  public boolean test(Student s) {
    return s.getGPA() < LOW_GPA_THRESH;
  }
}
