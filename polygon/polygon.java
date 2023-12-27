import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class polygon {

  /**
   * Outputs the area, perimeter, and interior angle of a regular polygon
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double area, n, p;
    double s = 0, i = 0;
    System.out.print("Enter number of sides: ");
    n = input.nextDouble();
    System.out.print("Enter side length: ");
    s = input.nextDouble();
    if (n < 3) {
      System.out.println("A polygon must have at least 3 sides.");
      System.exit(0);
    }
    if (s <= 0) {
      System.out.println("Side length must be positive.");
      System.exit(0);
    }
    if (i <= 180 && i > 0) {
      System.exit(0);
    }
    area = (s * s * n) / (4 * Math.tan(Math.PI / n));
    System.out.printf("Area: %.3f%n", area);
    p = n * s;
    System.out.printf("Perimeter: %.3f%n", p);
    i = 180 - 360 / n;
    System.out.printf("Interior Angle: %.3f degrees%n", i);
    input.close();
  }
}
