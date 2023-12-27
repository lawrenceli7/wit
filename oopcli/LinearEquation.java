/**
 * @author Lawrence Li
 *
 */
public class LinearEquation {

  private final double a;
  private final double b;
  private final double c;
  private final double d;
  private final double e;
  private final double f;
  private final boolean isSolvable;
  private final Double x;
  private final Double y;

  /**
   * Initialize the linear equation of form: ax + by = e cx + dy = f
   *
   * @param a parameter a
   * @param b parameter b
   * @param c parameter c
   * @param d parameter d
   * @param e parameter e
   * @param f parameter f
   */
  public LinearEquation(
    double a,
    double b,
    double c,
    double d,
    double e,
    double f
  ) {
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
    this.e = e;
    this.f = f;

    final double denom = (a * d - b * c);
    isSolvable = (denom != 0);
    if (isSolvable) {
      x = (e * d - b * f) / denom;
      y = (a * f - e * c) / denom;
    } else {
      x = null;
      y = null;
    }
  }

  /**
   * Convenience constructor to initialize the linear equation via array
   *
   * THIS CONSTRUCTOR CALLS THE CONSTRUCTOR ABOVE USING THE ARRAY CONTENTS
   *
   * @param p parameter array, assumed to be length 6 (a-f, in order)
   */
  public LinearEquation(double[] p) {
    this(p[0], p[1], p[2], p[3], p[4], p[5]);
  }

  /**
   * Returns parameter a
   *
   * @return a
   */
  public double getA() {
    return a;
  }

  /**
   * Returns parameter b
   *
   * @return b
   */
  public double getB() {
    return b;
  }

  /**
   * Returns parameter c
   *
   * @return c
   */
  public double getC() {
    return c;
  }

  /**
   * Returns parameter d
   *
   * @return d
   */
  public double getD() {
    return d;
  }

  /**
   * Returns parameter e
   *
   * @return e
   */
  public double getE() {
    return e;
  }

  /**
   * Returns parameter f
   *
   * @return f
   */
  public double getF() {
    return f;
  }

  /**
   * Returns true if the parameterized equation is solvable (i.e. denominator
   * ad-bc is not 0)
   *
   * @return true if solvable, false otherwise
   */
  public boolean isSolvable() {
    return isSolvable;
  }

  /**
   * Returns solution for x if solvable, null otherwise
   *
   * @return x if solvable, null otherwise
   */
  public Double getX() {
    return x;
  }

  /**
   * Returns solution for y if solvable, null otherwise
   *
   * @return y if solvable, null otherwise
   */
  public Double getY() {
    return y;
  }
}
