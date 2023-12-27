import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class partA {

  /**
   * Converts yards, feet, and inches to total inches
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter number of yards: ");
    int yards = input.nextInt();
    System.out.print("Enter number of feet: ");
    int feet = input.nextInt();
    System.out.print("Enter number of inches: ");
    int inches = input.nextInt();
    int total = (yards * 36) + (feet * 12) + inches;
    System.out.printf("Total number of inches: %d%n", total);
    input.close();
  }
}
