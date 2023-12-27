import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class partD {

  /**
   * Error message to display for negative amount
   */
  public static final String ERR_MSG = "The package cannot be shipped!";

  /**
   * Method to compute shipping cost
   *
   * @param weight, assumed to be in (0, 20]
   * @return cost to ship
   */
  public static double shippingCost(double weight) {
    if (weight > 0 && weight <= 1) {
      return 3.50;
    }
    if (weight > 1 && weight <= 3) {
      return 5.50;
    }
    if (weight > 3 && weight <= 10) {
      return 8.50;
    }
    if (weight > 10 && weight <= 20) {
      return 10.50;
    }
    return weight;
  }

  /**
   * Input package weight Outputs the price to ship the package based on how much
   * it weights
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter package weight: ");
    double package_weight = input.nextDouble();
    if (package_weight <= 0 || package_weight > 20) {
      System.out.println(ERR_MSG);
      System.exit(0);
    } else {
      System.out.printf(
        "It will cost $%.2f to ship this package.%n",
        shippingCost(package_weight)
      );
    }
    input.close();
  }
}
