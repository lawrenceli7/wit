import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class anagram {

  /**
   * Returns an array with counts for each letter from a-z (case-insensitive),
   * ignoring all other characters:
   *
   * [0]: number of a/A's [1]: number of b/B's ... [25]: number of z/Z's
   *
   * @param word input word
   * @return count of case-insensitive letters
   */
  public static int[] countLetters(String word) {
    int[] counts = new int[26];

    for (char c : word.toCharArray()) {
      c = Character.toLowerCase(c);
      if (c >= 'a' && c <= 'z') {
        counts[c - 'a']++;
      }
    }

    return counts;
  }

  /**
   * Compares two arrays and returns true if they have the same contents
   *
   * @param c1 array 1
   * @param c2 array 2
   * @return true if c1 and c2 have the same contents
   */
  public static boolean sameCounts(int[] c1, int[] c2) {
    if (c1.length != c2.length) {
      return false;
    }
    for (int i = 0; i < c1.length; i++) {
      if (c1[i] != c2[i]) {
        return false;
      }
    }

    return true;
  }

  /**
   * Inputs two phrases and outputs if they are anagrams (ignoring case and any
   * non-letter characters)
   *
   * @param args command-line arguments, ignored
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter phrase 1: ");
    String phrase1 = input.nextLine();
    System.out.print("Enter phrase 2: ");
    String phrase2 = input.nextLine();
    int[] content1 = countLetters(phrase1);
    int[] content2 = countLetters(phrase2);
    boolean anagram = sameCounts(content1, content2);
    if (anagram) {
      System.out.println("These phrases are anagrams.");
    } else {
      System.out.println("These phrases are not anagrams.");
    }
    input.close();
  }
}
