import java.util.ArrayList;

/**
 * @author Lawrence Li
 *
 */
public class Shifter {

  /**
   * Number of letters in the English alphabet
   */
  public static final int NUM_LETTERS = ('z' - 'a') + 1;

  private final String[] shifts = new String[NUM_LETTERS];

  private static String shift(String s, StringBuilder sb, int n) {
    for (int i = 0; i < s.length(); i++) {
      final char c = s.charAt(i);
      final boolean isLowercase = (c >= 'a' && c <= 'z');
      final boolean isUppercase = (c >= 'A' && c <= 'Z');
      final char r;
      if (isLowercase || isUppercase) {
        char base = isLowercase ? 'a' : 'A';
        r = (char) (base + ((NUM_LETTERS + (c - base) + n) % NUM_LETTERS));
      } else {
        r = c;
      }
      sb.setCharAt(i, r);
    }
    return sb.toString();
  }

  /**
   * Initializes the shifter
   *
   * @param s encrypted string
   */
  public Shifter(String s) {
    final StringBuilder sb = new StringBuilder(s);
    shifts[0] = s;
    for (int i = 1; i < NUM_LETTERS; i++) {
      shifts[i] = shift(s, sb, i);
    }
  }

  private static int shiftMod(int n) {
    return (NUM_LETTERS + n) % NUM_LETTERS;
  }

  /**
   * Returns the result of shifting by a supplied amount
   *
   * @param n number of places to shift
   * @return shifted string
   */
  public String shift(int n) {
    return shifts[shiftMod(n)];
  }

  /**
   * Finds all shifts that contain the supplied substring
   *
   * @param sub substring to find
   * @return array of shifts (0-25) that contain the substring (in order)
   */
  public int[] findShift(String sub) {
    ArrayList<Integer> n = new ArrayList<>();
    for (int i = 0; i < NUM_LETTERS; i++) {
      if (shift(i).indexOf(sub) != -1) {
        n.add(i);
      }
    }
    int[] r = new int[n.size()];
    for (int i = 0; i < n.size(); i++) {
      r[i] = n.get(i);
    }
    return r;
  }
}
