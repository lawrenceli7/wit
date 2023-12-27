import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class partB {

  /**
   * Program execution point: input text via console input, output counts for each
   * letter found in the input (case-insensitive)
   *
   * @param args command-line arguments (ignored)
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter text: ");
    int count = 0;
    int array[] = new int[26];
    boolean hasletters = false;
    while (input.hasNext()) {
      String letter = input.nextLine();
      letter = letter.toUpperCase();
      for (int i = 0; i < 26; i++) {
        array[i] = 0;
        count++;
      }
      for (int i = 0; i < letter.length(); i++) {
        if (letter.charAt(i) >= 'A' && letter.charAt(i) <= 'Z') {
          array[letter.charAt(i) - 'A']++;
          hasletters = true;
        }
      }
      for (int i = 0; i < array.length; i++) {
        if (array[i] >= 1) {
          char b = (char) (i + 'A');
          System.out.printf("%s: %d%n", b, array[i]);
        }
      }
    }
    if (hasletters == false) {
      System.out.println();
    }
    input.close();
  }
}
