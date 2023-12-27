import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class partC {

  /**
   * Removes all duplicate values from the supplied list
   *
   * @param list list from which to remove repeated elements
   */
  public static void removeRepeated(ArrayList<Integer> list) {
    final ArrayList<Integer> temp = new ArrayList<>();
    for (int i : list) {
      if (!temp.contains(i)) {
        temp.add(i);
      }
    }
    list.clear();
    list.addAll(temp);
    list.trimToSize();
  }

  /**
   * Reads numbers from the keyboard and outputs the list of distinct values
   *
   * @param args command-line arguments, ignored
   */
  public static void main(String[] args) {
    final Scanner input = new Scanner(System.in);
    final ArrayList<Integer> list = new ArrayList<>();
    System.out.print("Enter integers: ");
    while (input.hasNextInt()) {
      list.add(input.nextInt());
    }
    if (list.isEmpty()) {
      System.out.print("No values entered.");
    } else {
      removeRepeated(list);
      System.out.print("The distinct integer(s):");
      for (int i : list) {
        System.out.printf(" %d", i);
      }
    }
    System.out.println();
    input.close();
  }
}
