/**
 * @author Lawrence Li
 *
 */
public class partA {

  /**
   * Error if incorrect command-line arguments are supplied
   */
  public static final String ERR_USAGE =
    "Please supply correct inputs: <encrypted string> <substring>";

  /**
   * Error if shift could not be found
   */
  public static final String ERR_NONE = "No valid shifts found.";

  /**
   * Outputs all shifts of the encrypted string that contain the supplied
   * substring
   *
   * @param args command-line arguments: <encrypted string> <substring>
   */
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println(ERR_USAGE);
      System.exit(0);
    }

    final Shifter s = new Shifter(args[0]);
    final int[] shifts = s.findShift(args[1]);
    if (shifts.length == 0) {
      System.out.println(ERR_NONE);
      System.exit(0);
    } else {
      for (int n : shifts) {
        System.out.printf("%02d: %s%n", n, s.shift(n));
      }
    }
  }
}
