import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */

public class gcd {

  /**
   * Error to output if either input is not positive
   */
  static final String E_POSITIVE = "Inputs must both be positive.";

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a: ");
    int num1 = input.nextInt();
    System.out.print("Enter b: ");
    int num2 = input.nextInt();
    if (num1 > 0 && num2 > 0) {
      System.out.printf(
        "The GCD of %d and %d is %d%n",
        num1,
        num2,
        gcd(num1, num2)
      );
    } else {
      System.out.println(E_POSITIVE);
    }
    input.close();
  }

  /**
   * Returns the greatest common denominator (gcd) of two positive integers
   *
   * @param num1 integer 1
   * @param num2 integer 2
   * @return gcd of integers 1 and 2
   */
  public static int gcd(int num1, int num2) {
    if (num2 == 0) {
      return num1;
    }
    return gcd(num2, num1 % num2);
  }
}
