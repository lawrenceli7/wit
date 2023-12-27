import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class partA {

  /**
   * Reads all values from the provided scanner into the supplied array (up to its
   * size) and returns the number of integers read
   *
   * @param input input source
   * @param nums  destination for read integers
   * @return number of integers read
   */
  public static int readIntoArray(Scanner input, int[] nums) {
    int num_values = 0;
    try {
      while (input.hasNextInt() || num_values < nums.length) {
        nums[num_values] = input.nextInt();
        num_values++;
      }
    } catch (Exception ex) {}
    return num_values;
  }

  /**
   * Prints to the screen the average of the supplied array, up to the supplied
   * size, and all integers in the array, again up to the supplied size, that are
   * larger than the average
   *
   * @param nums array of numbers
   * @param size number of valid elements
   */
  public static void printAboveAverage(int[] nums, int size) {
    double sum = 0;
    for (int i = 0; i < size; i++) {
      sum = sum + nums[i];
    }
    double avg = 0;
    if (size == 0) {
      System.out.printf("Average: %.2f%n", avg);
      System.out.println("Values above average: none");
      System.exit(0);
    } else {
      avg = sum / size;
      System.out.printf("Average: %.2f%n", avg);
    }
    int count = 0;
    for (int i = 0; i < size; i++) {
      if (nums[i] > avg && count == 0) {
        count++;
        System.out.print("Values above average: ");
        System.out.printf("nums[%s]=%s", i, nums[i]);
      } else if (nums[i] > avg && count > 0) {
        System.out.printf(", nums[%s]=%s", i, nums[i]);
        count++;
      }
    }
    if (count == 0) {
      System.out.println("Values above average: none");
    } else {
      System.out.println();
    }
  }

  /**
   * Program execution point: input a sequence of integers (up to 100), output
   * average of integers and those over the average
   *
   * @param args command-line arguments (ignored)
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter up to 100 integers: ");
    int[] array = new int[100];
    int countOfInt = readIntoArray(input, array);
    printAboveAverage(array, countOfInt);
    input.close();
  }
}
