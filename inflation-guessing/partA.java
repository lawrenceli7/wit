import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class partA {

  /**
   * Calculates inflation price of an item
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double price, inflation;
    int years = 0;
    // input the price of item, number of years, and inflation rate
    System.out.print("Enter the current price of the item: $");
    price = input.nextDouble();
    System.out.print("Enter the number of years: ");
    years = input.nextInt();
    System.out.print("Enter the inflation rate as a percentage: ");
    inflation = input.nextDouble();
    // checking for years, price, and inflation to be at least zero
    if (years < 0) {
      System.out.println("The number of years must be at least 0!");
      System.exit(0);
    }
    if (price < 0) {
      System.out.println("The current price must be at least 0!");
      System.exit(0);
    }
    if (inflation < 0) {
      System.out.println("The inflation rate must be at least 0!");
      System.exit(0);
    }
    double inflation_percent;
    inflation_percent = (inflation / 100);
    int i = 1;
    // do while loop, inflation after i amount of years
    do {
      price = price * (1 + inflation_percent);
      i++;
    } while (i <= years);
    // checks for years and year
    if (years == 1) {
      System.out.printf(
        "After %d year, the price will be $%.2f%n",
        years,
        price
      );
    } else {
      System.out.printf(
        "After %d years, the price will be $%.2f%n",
        years,
        price
      );
    }
    input.close();
  }
}
