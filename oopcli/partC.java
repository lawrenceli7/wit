/**
 * @author Lawrence Li
 *
 */
public class partC {

  /**
   * Error to display if the command-line arguments are invalid
   */
  public static final String ERR_USAGE = "Please supply 2 numbers (x y).";

  /**
   * Number of required parameters (x, y)
   */
  public static final int NUM_PARAMS = 2;

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
   * Computes the distance using three methods from the origin to a point supplied
   * via command-line arguments
   *
   * @param args command-line args: x y
   */
  public static void main(String[] args) {
    double[] xy = validateArgs(args);
    if (xy == null) {
      System.out.println(ERR_USAGE);
      System.exit(0);
    }
    final Point2D p = new Point2D(xy[0], xy[1]);

    final Point2D o = new Point2D();
    System.out.printf("Point 1: %s%n", o);
    System.out.printf("Point 2: %s%n", p);
    System.out.printf("Static method distance: %.3f%n", Point2D.distance(o, p));
    System.out.printf("Distance from P1: %.3f%n", o.distanceTo(p));
    System.out.printf("Distance from P2: %.3f%n", p.distanceTo(o));
  }
}
