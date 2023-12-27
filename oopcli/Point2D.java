/**
 * @author Lawrence Li
 *
 */
public class Point2D {

  private final double x;
  private final double y;

  /**
   * Constructor to initialize coordinates
   *
   * @param x x value
   * @param y y value
   */
  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Initializes to (0., 0.)
   */
  public Point2D() {
    this(0.0, 0.0);
  }

  /**
   * Get the x coordinate
   *
   * @return x coordinate
   */
  public double getX() {
    return x;
  }

  /**
   * Get the y coordinate
   *
   * @return y coordinate
   */
  public double getY() {
    return y;
  }

  /**
   * Gets a String representation of the coordinate in the form "(x, y)" (each
   * with three decimal places of precision)
   *
   * #return "(x, y)"
   */
  public String toString() {
    return String.format("(%.3f, %.3f)", x, y);
  }

  /**
   * Method to compute the Euclidean/L2 distance between two points in 2D space
   *
   * @param p1 point 1
   * @param p2 point 2
   * @return straightline distance between p1 and p2
   */
  public static double distance(Point2D p1, Point2D p2) {
    return Math.sqrt(
      (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y)
    );
  }

  /**
   * Method to compute the Euclidean distance between this point and a supplied
   * point
   *
   * @param p input point
   * @return straightline distance between this point and p
   */
  public double distanceTo(Point2D p) {
    return distance(this, p);
  }
}
