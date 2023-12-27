import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class partB {

  /**
   * Error to supply if input is not positive
   */
  public static final String ERR_VALUES = "Number of values must be positive.";

  /**
   * Returns true if the supplied array has a sequence of k consecutive values
   *
   * @param values input array
   * @param k      sequence length for which to search
   * @return true if values has a consecutive sequence of at least k
   */
  public static boolean hasConsecutive(int[] values, int k) {
    if (k <= 0 || values.length == 0 || values.length < k) {
      return false;
    }
    int max_count = 0;
    int consecutive = 1;
    for (int i = 1; i < values.length; i++) {
      if (values[i] == values[i - 1]) {
        consecutive++;
      } else {
        if (consecutive > max_count) {
          max_count = consecutive;
        }
        consecutive = 1;
      }
    }
    if (consecutive >= k || max_count >= k) {
      return true;
    }

    return false;
  }

  /**
   * Returns the length of the longest consecutive sequence in the supplied array
   *
   * @param values input array
   * @return length of the longest consecutive value sequence in values
   */
  public static int maxConsecutive(int[] values) {
    if (values.length == 0) {
      return 0;
    }
    int max_count = 1;
    int current_count = 1;
    int previous = values[0];
    for (int i = 1; i < values.length; i++) {
      if (values[i] == previous) {
        current_count++;
        max_count = Math.max(current_count, max_count);
      } else {
        current_count = 1;
        previous = values[i];
      }
    }
    return max_count;
  }

  /**
   * Inputs an array of numbers and outputs the longest consecutive sequence of
   * values
   *
   * @param args command-line arguments, ignored
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the number of values: ");
    int num_values = input.nextInt();
    if (num_values <= 0) {
      System.out.println(ERR_VALUES);
      System.exit(0);
    }
    int array[] = new int[num_values];
    System.out.print("Enter the values: ");
    for (int i = 0; i < num_values; i++) {
      array[i] = input.nextInt();
    }
    System.out.printf(
      "The maximum length of consecutive values is %d.%n",
      maxConsecutive(array)
    );
    input.close();
  }
}
