import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class partE {

  /**
   * Counts the number of upper case characters within the supplied string
   *
   * @param s input string
   * @return number of upper case characters
   */
  public static int numUpperCase(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (Character.isUpperCase(s.charAt(i))) {
        count++;
      }
    }
    return count;
  }

  /**
   * Input a string Outputs the number of uppercase letters in the string
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String text = input.nextLine();
    if (numUpperCase(text) == 0) {
      System.out.println("There are no uppercase characters.");
    } else if (numUpperCase(text) == 1) {
      System.out.println("There is 1 uppercase character in the string.");
    } else {
      System.out.printf(
        "There are %d uppercase characters in the string.%n",
        numUpperCase(text)
      );
    }
    input.close();
  }
}
