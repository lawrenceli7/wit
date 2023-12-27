import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class partA {

  /**
   * Output area of a triangle
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double a, b, c, s, area;
    System.out.print("Enter the length of side a: ");
    a = input.nextDouble();
    System.out.print("Enter the length of side b: ");
    b = input.nextDouble();
    System.out.print("Enter the length of side c: ");
    c = input.nextDouble();
    s = (a + b + c) / (2.0);
    area = Math.sqrt((1.0 * s * (s - a) * (s - b) * (s - c)));
    // when the side lengths are negative or 0
    if (a <= 0 || b <= 0 || c <= 0) {
      System.out.println("Side lengths must all be positive");
      System.exit(0);
    }
    // when side c is larger than both side a and side b combined
    else if (c > a + b) {
      System.out.println("Side c is too long");
    }
    // when side a is larger than both side c and side b combined
    else if (a > b + c) {
      System.out.println("Side a is too long");
    }
    // when side b is larger than both side a and side c combined
    else if (b > a + c) {
      System.out.println("Side b is too long");
    } else {
      System.out.printf("The area is %.2f%n", area);
    }
    input.close();
  }
}
