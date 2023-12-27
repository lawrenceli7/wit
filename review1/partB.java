import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class partB {

  /**
   * Error message to display for any non-negative counts
   */
  public static final String ERR_MSG = "All coin counts must be non-negative!";

  /**
   * Input quarters, dimes, nickels, and pennies Outputs total amount of money
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter number of quarters: ");
    int quarters = input.nextInt();
    System.out.print("Enter number of dimes: ");
    int dimes = input.nextInt();
    System.out.print("Enter number of nickels: ");
    int nickels = input.nextInt();
    System.out.print("Enter number of pennies: ");
    int pennies = input.nextInt();
    if (pennies < 0 || nickels < 0 || dimes < 0 || quarters < 0) {
      System.out.println(ERR_MSG);
      System.exit(0);
    }
    double coins =
      (quarters * 0.25) + (dimes * 0.10) + (nickels * 0.05) + (pennies * 0.01);
    System.out.printf("You have $%.2f in coins.%n", coins);
    input.close();
  }
}
