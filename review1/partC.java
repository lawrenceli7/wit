import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class partC {

  /**
   * Error message to display for negative amount
   */
  public static final String ERR_MSG = "Dollar amount must be non-negative!";

  /**
   * Method to convert a double to an integer
   *
   * @param num number to convert
   * @return converted value
   */
  public static int convertToInt(double num) {
    return (int) Math.round(num);
  }

  /**
   * Input total amount of money Outputs fewest number of quarters, dimes,
   * nickels, and pennies needed
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter total amount: $");
    double amount = input.nextDouble();
    if (amount < 0) {
      System.out.println(ERR_MSG);
      System.exit(0);
    }
    amount = amount * 100;
    int total = convertToInt(amount);
    int quarter = 0, dime = 0, nickel = 0, penny = 0;
    if (total >= 25) {
      quarter = total / 25;
      total = total % 25;
    }
    if (total >= 10) {
      dime = total / 10;
      total = total % 10;
    }
    if (total >= 5) {
      nickel = total / 5;
      total = total % 5;
    }
    if (total >= 1) {
      penny = total / 1;
      total = total % 1;
    }
    String quarters = ((quarter == 1) ? "" : "s");
    String dimes = ((dime == 1) ? "" : "s");
    String nickels = ((nickel == 1) ? "" : "s");
    String pennies = ((penny == 1) ? "y" : "ies");
    System.out.printf(
      "You have %d quarter%s, " +
      "%d dime%s, " +
      "%d nickel%s, " +
      "and %d penn%s.%n",
      quarter,
      quarters,
      dime,
      dimes,
      nickel,
      nickels,
      penny,
      pennies
    );
    input.close();
  }
}
