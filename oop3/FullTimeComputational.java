/**
 * @author Lawrence Li
 */
public class FullTimeComputational implements StudentFilter {

  /**
   * Filter for students that are full time and in a computational major:
   * BCOS/BSCN/BSIS/BSCO
   *
   * @param s student to consider
   * @return true if student passes
   */
  @Override
  public boolean test(Student s) {
    return (
      s.isFullTime() &&
      (
        s.getMajor().equals("BCOS") ||
        s.getMajor().equals("BSCN") ||
        s.getMajor().equals("BSIS") ||
        s.getMajor().equals("BSCO")
      )
    );
  }
}
