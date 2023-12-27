/**
 * @author Lawrence Li
 *
 */
public class partB {

  /**
   * Error to display if the command-line arguments are invalid
   */
  public static final String ERR_USAGE = "Please supply 6 numbers (a-f).";

  /**
   * Error to display if the equation has no solution
   */
  public static final String ERR_NOSLTN = "The equation has no solution.";

  /**
   * Number of required parameters (a-f)
   */
  public static final int NUM_PARAMS = 6;

  /**
   * Validates command-line arguments and returns parameters if valid
   *
   * @param args command-line arguments
   * @return if valid an array of parameters, else null
   */
  public static double[] validateArgs(String[] args) {
    try {
      if (args.length == NUM_PARAMS) {
        double[] params = new double[NUM_PARAMS];
        for (int i = 0; i < params.length; i++) {
          params[i] = Double.valueOf(args[i]);
        }
        return params;
      }
    } catch (NumberFormatException ex) {}
    return null;
  }

  /**
   * Uses command-line arguments to create an instance of the linear equation, and
   * reports the outcome
   *
   * @param args command-line arguments, interpreted as equation parameters
   */
  public static void main(String[] args) {
    double[] p = validateArgs(args);
    if (p == null) {
      System.out.println(ERR_USAGE);
      System.exit(0);
    }
    LinearEquation linearequation = new LinearEquation(p);
    if (linearequation.isSolvable()) {
      System.out.printf(
        "Solution: x=%.3f, y=%.3f%n",
        linearequation.getX(),
        linearequation.getY()
      );
    } else {
      System.out.println(ERR_NOSLTN);
    }
  }
}
