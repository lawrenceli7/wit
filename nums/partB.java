import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class partB {

  /**
   * Function basically sums up the positive and non-positive numbers, and also
   * shows the average of those positive and non-positive numbers. Lastly it also
   * displays the total sum and total average of the 5 numbers
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int a, b, c, d, e;
    int sum_pos = 0, sum_nonpos = 0, sum_total = 0;
    double avg_pos = 0, avg_nonpos = 0, avg_total = 0;
    int count_pos = 0, count_nonpos = 0;
    System.out.print("Enter five whole numbers: ");
    a = input.nextInt();
    b = input.nextInt();
    c = input.nextInt();
    d = input.nextInt();
    e = input.nextInt();
    sum_total = a + b + c + d + e;
    avg_total = sum_total / 5.0;
    // check a
    if (a > 0) {
      sum_pos = sum_pos + a;
      count_pos = count_pos + 1;
    } else {
      sum_nonpos = sum_nonpos + a;
      count_nonpos = count_nonpos + 1;
    }
    // check b
    if (b > 0) {
      sum_pos = sum_pos + b;
      count_pos = count_pos + 1;
    } else {
      sum_nonpos = sum_nonpos + b;
      count_nonpos = count_nonpos + 1;
    }
    // check c
    if (c > 0) {
      sum_pos = sum_pos + c;
      count_pos = count_pos + 1;
    } else {
      sum_nonpos = sum_nonpos + c;
      count_nonpos = count_nonpos + 1;
    }
    // check d
    if (d > 0) {
      sum_pos = sum_pos + d;
      count_pos = count_pos + 1;
    } else {
      sum_nonpos = sum_nonpos + d;
      count_nonpos = count_nonpos + 1;
    }
    // check e
    if (e > 0) {
      sum_pos = sum_pos + e;
      count_pos = count_pos + 1;
    } else {
      sum_nonpos = sum_nonpos + e;
      count_nonpos = count_nonpos + 1;
    }
    // avg pos
    if (count_pos != 0) {
      avg_pos = 1.0 * sum_pos / count_pos;
    }
    // avg nonpos
    if (count_nonpos != 0) {
      avg_nonpos = 1.0 * sum_nonpos / count_nonpos;
    }
    // numbers vs. number
    if ((count_pos == 1) && (count_nonpos == 1)) {
      System.out.printf(
        "The sum of the %d positive number: %d%n",
        count_pos,
        sum_pos
      );
      System.out.printf(
        "The sum of the %d non-positive number: %d%n",
        count_nonpos,
        sum_nonpos
      );
      System.out.printf("The sum of the 5 numbers: %d%n", sum_total);
      System.out.printf(
        "The average of the %d positive number: %.2f%n",
        count_pos,
        avg_pos
      );
      System.out.printf(
        "The average of the %d non-positive number: %.2f%n",
        count_nonpos,
        avg_nonpos
      );
      System.out.printf("The average of the 5 numbers: %.2f%n", avg_total);
    } else if ((count_pos != 1) && (count_nonpos != 1)) {
      System.out.printf(
        "The sum of the %d positive numbers: %d%n",
        count_pos,
        sum_pos
      );
      System.out.printf(
        "The sum of the %d non-positive numbers: %d%n",
        count_nonpos,
        sum_nonpos
      );
      System.out.printf("The sum of the 5 numbers: %d%n", sum_total);
      System.out.printf(
        "The average of the %d positive numbers: %.2f%n",
        count_pos,
        avg_pos
      );
      System.out.printf(
        "The average of the %d non-positive numbers: %.2f%n",
        count_nonpos,
        avg_nonpos
      );
      System.out.printf("The average of the 5 numbers: %.2f%n", avg_total);
    } else if ((count_pos == 1) && (count_nonpos != 1)) {
      System.out.printf(
        "The sum of the %d positive number: %d%n",
        count_pos,
        sum_pos
      );
      System.out.printf(
        "The sum of the %d non-positive numbers: %d%n",
        count_nonpos,
        sum_nonpos
      );
      System.out.printf("The sum of the 5 numbers: %d%n", sum_total);
      System.out.printf(
        "The average of the %d positive number: %.2f%n",
        count_pos,
        avg_pos
      );
      System.out.printf(
        "The average of the %d non-positive numbers: %.2f%n",
        count_nonpos,
        avg_nonpos
      );
      System.out.printf("The average of the 5 numbers: %.2f%n", avg_total);
    } else {
      System.out.printf(
        "The sum of the %d positive numbers: %d%n",
        count_pos,
        sum_pos
      );
      System.out.printf(
        "The sum of the %d non-positive number: %d%n",
        count_nonpos,
        sum_nonpos
      );
      System.out.printf("The sum of the 5 numbers: %d%n", sum_total);
      System.out.printf(
        "The average of the %d positive numbers: %.2f%n",
        count_pos,
        avg_pos
      );
      System.out.printf(
        "The average of the %d non-positive number: %.2f%n",
        count_nonpos,
        avg_nonpos
      );
      System.out.printf("The average of the 5 numbers: %.2f%n", avg_total);
    }
    input.close();
  }
}
