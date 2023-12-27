/**
 * @author Lawrence Li
 *
 */
public class partB {

  /**
   * Error if incorrect command-line arguments are supplied
   */
  public static final String ERR_USAGE =
    "Please supply correct inputs: color x1 y1 x2 y2 x3 y3";

  /**
   * Number of command-line arguments
   */
  public static final int NUM_ARGS = 7;

  private static String validateArgs(String[] args, double[] points) {
    if (args.length == NUM_ARGS) {
      try {
        for (int i = 0; i < points.length; i++) {
          points[i] = Double.parseDouble(args[i + 1]);
        }

        return args[0];
      } catch (NumberFormatException e) {}
    }

    return null;
  }

  private static String pointCSV(String color, Point2D p) {
    return String.format("\"%s\",%.3f,%.3f", color, p.getX(), p.getY());
  }

  /**
   * Produces a string representing all vertex information in CSV format:
   * "color",x,y
   *
   * For all shape vertices, including axis-aligned bounding boxes for any
   * included triangles
   *
   * @param shapes array of shapes
   * @return string of CSV information
   */
  public static String shapeVertices(Shape2D[] shapes) {
    final StringBuilder sb = new StringBuilder();
    final String nl = String.format("%n");
    boolean first = true;

    for (Shape2D s : shapes) {
      for (Point2D p : s.getVertices()) {
        if (!first) sb.append(nl);
        first = false;
        sb.append(pointCSV(s.getColor(), p));
      }

      if (s instanceof Triangle) {
        final Rectangle r = ((Triangle) s).getAxisAlignedBoundingBox();
        for (Point2D p : r.getVertices()) {
          if (!first) sb.append(nl);
          sb.append(pointCSV(r.getColor(), p));
        }
      }
    }
    return sb.toString();
  }

  /**
   * Outputs vertex information in CSV format about the triangle supplied via
   * command-line arguments, including its axis-aligned bounding box
   *
   * @param args command-line arguments: color x1 y1 x2 y2 x3 y3
   */
  public static void main(String[] args) {
    final double[] points = new double[NUM_ARGS - 1];

    final String color = validateArgs(args, points);
    if (color == null) {
      System.out.printf("%s%n", ERR_USAGE);
      System.exit(1);
    }

    final Triangle t = new Triangle(
      color,
      new Point2D(points[0], points[1]),
      new Point2D(points[2], points[3]),
      new Point2D(points[4], points[5])
    );

    System.out.printf("%s%n", shapeVertices(new Shape2D[] { t }));
  }
}
