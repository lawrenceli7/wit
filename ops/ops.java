import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class ops {

  /**
   * Outputs the result of one of three operations (min, l1 norm, l2 norm)
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double a, b, c;
    String operation;
    System.out.print("Enter three numbers: ");
    a = input.nextDouble();
    b = input.nextDouble();
    c = input.nextDouble();
    System.out.print("Enter operation: ");
    operation = input.next();
    if (operation.equals("min")) {
      if (a < b && a < c) {
        System.out.printf("min(%.2f, %.2f, %.2f) = %.2f%n", a, b, c, a);
      } else if (b < a && b < c) {
        System.out.printf("min(%.2f, %.2f, %.2f) = %.2f%n", a, b, c, b);
      } else {
        System.out.printf("min(%.2f, %.2f, %.2f) = %.2f%n", a, b, c, c);
      }
    } else if (operation.equals("l1")) {
      double abs = Math.abs(a) + Math.abs(b) + Math.abs(c);
      System.out.printf("l1(%.2f, %.2f, %.2f) = %.2f%n", a, b, c, abs);
    } else if (operation.equals("l2")) {
      double sqrt = Math.sqrt((a * a) + (b * b) + (c * c));
      System.out.printf("l2(%.2f, %.2f, %.2f) = %.2f%n", a, b, c, sqrt);
    } else {
      System.out.println("Invalid operation!");
      System.exit(0);
    }
    input.close();
  }
}
