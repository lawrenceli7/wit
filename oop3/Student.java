import java.util.ArrayList;
import java.util.List;

/**
 * @author Lawrence Li
 *
 */
public class Student {

  /**
   * Semester names
   */
  public static final String[] SEMESTERS = { "Spring", "Summer", "Fall" };

  /**
   * Credits threshold for full-time classification
   */
  public static final int FT_CREDITS = 12;

  private static final ArrayList<Student> all = new ArrayList<Student>();
  private static int currentSemester;
  private static int currentYear;

  private static void init(int s, int y) {
    currentSemester = s;
    currentYear = y;
    all.clear();
  }

  /**
   * Sets the current semester to Fall 2017 and clears the database of students
   */
  public static void resetSemesterYear() {
    init(2, 2017);
  }

  /**
   * Sets to the semester following the current semester and clears the database
   * of students
   */
  public static void nextSemester() {
    final int s = (currentSemester + 1) % SEMESTERS.length;
    if (currentSemester == 2) {
      currentYear = currentYear + 1;
    }
    final int y = currentYear;

    init(s, y);
  }

  /**
   * Gets the current semester
   *
   * @return Summer/Fall/Spring
   */
  public static String getCurrentSemester() {
    return SEMESTERS[currentSemester];
  }

  /**
   * Gets the current year
   *
   * @return current year
   */
  public static int getCurrentYear() {
    return currentYear;
  }

  /**
   * Gets the current semester and year
   *
   * @return "semester year"
   */
  public static String getCurrentSemesterYear() {
    return String.format("%s %d", getCurrentSemester(), getCurrentYear());
  }

  /**
   * Searches all students in the current semester/year (in order of construction)
   * and returns a list that pass a supplied filter
   *
   * @param f filter to apply to each student
   * @return a list of students that satisfy the filter
   */
  public static List<Student> find(StudentFilter f) {
    final ArrayList<Student> matches = new ArrayList<>();

    for (Student s : all) {
      if (f.test(s)) {
        matches.add(s);
      }
    }

    return matches;
  }

  private final int myId;
  private final String myMajor;
  private final int mySemester;
  private final int myYear;

  private double myPoints;
  private int myCredits;

  /**
   * Creates a new student, in a supplied major, associated with the current
   * semester/year
   *
   * @param major student major
   */
  public Student(String major) {
    mySemester = currentSemester;
    myYear = currentYear;

    all.add(this);
    myId = all.size();

    myMajor = major;

    myPoints = 0.;
    myCredits = 0;
  }

  /**
   * String representation of the student. The "studentnum" portion refers to the
   * order in which the student was constructed in the current semester/year,
   * starting at #1, #2, ...
   *
   * @return "semester year #studentnum"
   */
  @Override
  public String toString() {
    return String.format("%s %d #%d", SEMESTERS[mySemester], myYear, myId);
  }

  /**
   * Gets the semester for this student (may be different than the current
   * semester)
   *
   * @return Summer/Fall/Spring
   */
  public String getSemester() {
    return SEMESTERS[mySemester];
  }

  /**
   * Gets the year for this student (may be different than the current year)
   *
   * @return year
   */
  public int getYear() {
    return myYear;
  }

  /**
   * Gets the major for this student
   *
   * @return student major
   */
  public String getMajor() {
    return myMajor;
  }

  /**
   * Adds a weighted course result
   *
   * @param credits course credits (assumed to be positive)
   * @param weight  numeric weight (e.g. A = 4; assumed to be positive)
   */
  public void addClass(int credits, double weight) {
    // hint: you can compute the GPA as a running GPA and so don't
    // need to store every credit/weight pair
    myPoints += (credits * weight);
    myCredits += credits;
  }

  /**
   * Returns true if the student is full time with respect to currently added
   * course credits
   *
   * @return true if credits is at least the threshold
   */
  public boolean isFullTime() {
    return myCredits >= FT_CREDITS;
  }

  /**
   * Computes the student's current GPA with respect to added course credits/
   * weights
   *
   * @return student GPA (0 if no credits)
   */
  public double getGPA() {
    if (myCredits > 0) {
      return myPoints / myCredits;
    } else {
      return 0;
    }
  }
}
