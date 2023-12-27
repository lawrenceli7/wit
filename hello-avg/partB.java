import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class partB {

  /**
   * Computes average of numbers after a negative number Outputs whether or not to
   * continue after previous average
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double avg;
    String y_n;
    boolean repeat = true;
    // do while loop that repeats the message if answered yes, and stops if answered no
    do {
      avg = getNon_Neg_Nums(input);
      System.out.printf("The average is: %.2f%n", avg);
      System.out.print("Do you want to compute another average (y/n)? ");
      y_n = input.next();
      if (!y_n.equalsIgnoreCase("y")) {
        repeat = false;
      }
    } while (repeat);
    input.close();
  }

  // gets positive integers and the average of those integers
  public static double getNon_Neg_Nums(Scanner input) {
    double value;
    int nums = 1;
    double avg = 0, total = 0;
    System.out.printf(
      "Enter a stream of non-negative numbers (negative when finished): "
    );
    do {
      value = input.nextDouble();
      if (value >= 0) {
        total = total + value;
        avg = total / nums;
        nums++;
      }
    } while (value >= 0);
    return avg;
  }
}
