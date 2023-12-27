import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class calendar {

  /**
   * Error to output if year is not positive
   */
  static final String E_YEAR = "The year must be positive!";

  /**
   * Error to output if the day is not between 0 and 6
   */
  static final String E_DAY = "The day of January 1st must be between 0 and 6!";

  /**
   * Determines if an input is a leap year
   *
   * @param year year in question
   * @return true if a leap year
   */
  public static boolean isLeapYear(int year) {
    return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
  }

  /**
   * Outputs a month to the console
   *
   * @param month    title
   * @param startDay 0=Sunday ... 6=Saturday
   * @param numDays  number of days in the month
   * @return day of the week after the last day of the month
   */
  public static int printMonth(String month, int startDay, int numDays) {
    int x = 0;
    System.out.println(month);
    while (x < startDay) {
      System.out.print("   ");
      x++;
    }
    for (int i = 0; i < numDays; i++) {
      if (startDay == 7) {
        System.out.println();
        startDay = 0;
      }
      if (i < 9) {
        System.out.print("  " + (i + 1));
      }
      if (i >= 9) {
        System.out.print(" " + (i + 1));
      }
      startDay++;
    }
    System.out.println();
    if (startDay == 7) {
      startDay = 0;
    }
    System.out.println();
    return startDay;
  }

  /**
   * Program execution point: input year, day of the week (0-6) of january 1
   * output calendar for that year
   *
   * @param args command-line arguments (ignored)
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String[] months = {
      "January",
      "February",
      "March",
      "April",
      "May",
      "June",
      "July",
      "August",
      "September",
      "October",
      "November",
      "December",
    };
    int[] numDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    System.out.print("Enter the year: ");
    int year = input.nextInt();
    System.out.print(
      "Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): "
    );
    int day = input.nextInt();
    if (year < 0) {
      System.out.println(E_YEAR);
      System.exit(0);
    }
    if ((day < 0) || (day > 6)) {
      System.out.println(E_DAY);
      System.exit(0);
    }
    if (isLeapYear(year) == true) {
      numDays[1] = 29;
    }
    int x = 0;
    int test = day;
    while (x < 12) {
      day = printMonth(months[x], day, numDays[x]);
      x++;
    }
    input.close();
  }
}
