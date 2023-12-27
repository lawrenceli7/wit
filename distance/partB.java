import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class partB {

  /**
   * Converts inches to fewest yards, feet, and inches
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter number of inches: ");
    int total_inches = input.nextInt();
    int yards = total_inches / 36;
    System.out.printf("Yards: %d%n", yards);
    int feet = (total_inches - yards * 36) / 12;
    System.out.printf("Feet: %d%n", feet);
    int inches = (total_inches - yards * 36 - feet * 12);
    System.out.printf("Inches: %d%n", inches);
    input.close();
  }
}
