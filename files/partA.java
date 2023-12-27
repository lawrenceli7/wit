import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class partA {

  /**
   * Error to output when a file cannot be opened.
   */
  static final String E_NOT_FOUND = "Error! File not found!";

  /**
   * Reads all integers in input scanner, outputs positive ones to output each on
   * its own line
   *
   * @param input  input source
   * @param output output destination
   */
  public static void process(Scanner input, PrintWriter output) {
    while (input.hasNext()) {
      int number = input.nextInt();
      if (number > 0) {
        output.println(number);
      }
    }
  }

  /**
   * Program execution point: input an input file name and an output file name,
   * for each positive number in the input file print on its own line to the
   * output file
   *
   * @param args command-line arguments (ignored)
   * @throws FileNotFoundException
   */
  public static void main(String[] args) {
    Scanner keyboardInput = new Scanner(System.in);
    System.out.print("Enter the name of the input file: ");
    String inputFileName = keyboardInput.next();
    System.out.print("Enter the name of the output file: ");
    String outputFileName = keyboardInput.next();
    try (
      Scanner fin = new Scanner(new File(inputFileName));
      PrintWriter fout = new PrintWriter(new File(outputFileName));
    ) {
      process(fin, fout);
    } catch (FileNotFoundException ex) {
      System.out.println(E_NOT_FOUND);
      System.exit(0);
    }
    keyboardInput.close();
  }
}
