import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class partB {

  /**
   * Program execution point: input an input file name, output the smallest and
   * largest integers found in the file (or invalid if not only integers in the
   * file)
   *
   * @param args command-line arguments (ignored)
   * @throws FileNotFoundException
   */
  public static void main(String[] args) {
    Scanner keyboardInput = new Scanner(System.in);
    System.out.print("Enter the name of the input file: ");
    String inputFileName = keyboardInput.next();
    File f = new File(inputFileName);
    try (Scanner fin = new Scanner(f)) {
      int lowest = Integer.MAX_VALUE;
      int highest = Integer.MIN_VALUE;
      if (f.length() == 0) {
        System.out.println("File: invalid");
        System.exit(0);
      }
      while (fin.hasNextInt()) {
        int x = fin.nextInt();
        if (x < lowest) {
          lowest = x;
        }
        if (x > highest) {
          highest = x;
        }
      }
      while (fin.hasNextDouble()) {
        System.out.println("File: invalid");
        System.exit(0);
      }
      while (fin.hasNext()) {
        System.out.println("File: invalid");
        System.exit(0);
      }
      System.out.printf("File: [%d, %d]%n", lowest, highest);
    } catch (FileNotFoundException ex) {
      System.out.println("File: invalid");
      System.exit(0);
    } catch (NoSuchElementException ex) {
      System.out.println("File: invalid");
      System.exit(0);
    }
    keyboardInput.close();
  }
}
