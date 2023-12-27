import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class partA {

  /**
   * Function displays the roots of the quadratic equation base on what value you
   * put in a, b, c. The message could display imaginary, one root, or two roots.
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double a, b, c;
    double d = 0;
    System.out.print("Enter a b c: ");
    a = input.nextDouble();
    b = input.nextDouble();
    c = input.nextDouble();
    d = b * b - (4 * a * c);
    double root1;
    double root2;
    root1 = (-b - Math.sqrt(d)) / (2 * a);
    root2 = (-b + Math.sqrt(d)) / (2 * a);
    // when discriminant is negative
    if (d < 0) {
      System.out.println("Roots: imaginary");
    }
    // when discriminant is zero
    else if (d == 0) {
      System.out.printf("Root: %.2f%n", root1);
    }
    // when discriminant is positive
    else if (d > 0) {
      if (root1 < root2) {
        System.out.printf("Roots: %.2f, %.2f%n", root1, root2);
      } else {
        System.out.printf("Roots: %.2f, %.2f%n", root2, root1);
      }
    }
    input.close();
  }
}
