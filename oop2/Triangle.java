/**
 * @author Lawrence Li
 *
 */
public class Triangle extends Shape2D {

  private final Rectangle aabb;
  private final Point2D[] v;
  private final Point2D c;
  private final double a;
  private final double p;

  /**
   * Constructs a triangle given three points
   *
   * @param color color
   * @param p1    point 1
   * @param p2    point 2
   * @param p3    point 3
   */
  public Triangle(String color, Point2D p1, Point2D p2, Point2D p3) {
    super(color, "Triangle");
    v = new Point2D[] { p1, p2, p3 };
    aabb =
      new Rectangle(
        color,
        new Point2D(
          Math.min(p1.getX(), Math.min(p2.getX(), p3.getX())),
          Math.min(p1.getY(), Math.min(p2.getY(), p3.getY()))
        ),
        new Point2D(
          Math.max(p1.getX(), Math.max(p2.getX(), p3.getX())),
          Math.max(p1.getY(), Math.max(p2.getY(), p3.getY()))
        )
      );
    final double oneThird = 1.0 / 3.0;
    c =
      new Point2D(
        oneThird * (p1.getX() + p2.getX() + p3.getX()),
        oneThird * (p1.getY() + p2.getY() + p3.getY())
      );
    final double s1 = p1.distanceTo(p2);
    final double s2 = p1.distanceTo(p3);
    final double s3 = p2.distanceTo(p3);
    p = s1 + s2 + s3;
    final double s = p / 2;
    a = Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));
  }

  /**
   * Returns the axis-aligned bounding box for this triangle
   *
   * @return axis-aligned bounding box
   */
  public Rectangle getAxisAlignedBoundingBox() {
    return aabb;
  }

  @Override
  public double getArea() {
    return a;
  }

  @Override
  public double getPerimeter() {
    return p;
  }

  @Override
  public Point2D getCenter() {
    return c;
  }

  @Override
  public Point2D[] getVertices() {
    return v;
  }
}
