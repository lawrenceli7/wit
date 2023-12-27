import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class stats {

  /**
   * Outputs sum, mean, and standard deviation of five numbers
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double a, b, c, d, e, mean, sum, standard_deviation_a, standard_deviation_b, standard_deviation_c, standard_deviation_d, standard_deviation_e, sum_standard_deviation, sum_inputs, standard_deviation_sqrt;
    System.out.print("Enter five numbers: ");
    a = input.nextDouble();
    b = input.nextDouble();
    c = input.nextDouble();
    d = input.nextDouble();
    e = input.nextDouble();
    sum = a + b + c + d + e;
    System.out.printf("Sum: %.2f%n", sum);
    mean = (a + b + c + d + e) / 5;
    System.out.printf("Mean: %.2f%n", mean);
    standard_deviation_a = (a - mean);
    standard_deviation_b = (b - mean);
    standard_deviation_c = (c - mean);
    standard_deviation_d = (d - mean);
    standard_deviation_e = (e - mean);
    sum_standard_deviation =
      (a - mean) *
      (a - mean) +
      (b - mean) *
      (b - mean) +
      (c - mean) *
      (c - mean) +
      (d - mean) *
      (d - mean) +
      (e - mean) *
      (e - mean);
    sum_inputs = (sum_standard_deviation) / 5;
    standard_deviation_sqrt = Math.sqrt(sum_inputs);
    System.out.printf(
      "Population Standard Deviation: %.2f%n",
      standard_deviation_sqrt
    );
    input.close();
  }
}
