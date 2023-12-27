import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class partB {

  /**
   * Outputs zodiac sign base on birth month and day
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int day, month;
    System.out.print("Enter your birth month (1-12): ");
    month = input.nextInt();
    System.out.print("Enter your birth day (1-31): ");
    day = input.nextInt();
    // day is not between 1 to 31
    if ((day >= 32) || (day <= 0)) {
      System.out.println("Day must be between 1 and 31!");
      System.exit(0);
    }
    // month is not in January to December
    else if ((month >= 13) || (month <= 0)) {
      System.out.println("Month must be between 1 and 12!");
      System.exit(0);
    }
    // between March 21 to April 19
    else if (((month == 3) && (day >= 21)) || ((month == 4 && day <= 19))) {
      System.out.println("You are an Aries!");
    }
    // between April 20 to May 20
    else if (((month == 4) && (day >= 20)) || ((month == 5 && day <= 20))) {
      System.out.println("You are a Taurus!");
    }
    // between May 21 to June 21
    else if (((month == 5) && (day >= 21)) || ((month == 6 && day <= 21))) {
      System.out.println("You are a Gemini!");
    }
    // between June 22 to July 22
    else if (((month == 6) && (day >= 22)) || ((month == 7 && day <= 22))) {
      System.out.println("You are a Cancer!");
    }
    // between July 23 to August 22
    else if (((month == 7) && (day >= 23)) || ((month == 8 && day <= 22))) {
      System.out.println("You are a Leo!");
    }
    // between August 23 to September 22
    else if (((month == 8) && (day >= 23)) || ((month == 9 && day <= 22))) {
      System.out.println("You are a Virgo!");
    }
    // between September 23 to October 22
    else if (((month == 9) && (day >= 23)) || ((month == 10 && day <= 22))) {
      System.out.println("You are a Libra!");
    }
    // between October 23 to November 21
    else if (((month == 10) && (day >= 23)) || ((month == 11 && day <= 21))) {
      System.out.println("You are a Scorpio!");
    }
    // between November 22 to December 21
    else if (((month == 11) && (day >= 22)) || ((month == 12 && day <= 21))) {
      System.out.println("You are a Sagittarius!");
    }
    // between December 22 to January 19
    else if (((month == 12) && (day >= 22)) || ((month == 1 && day <= 19))) {
      System.out.println("You are a Capricorn!");
    }
    // between January 20 to February 18
    else if (((month == 1) && (day >= 20)) || ((month == 2 && day <= 18))) {
      System.out.println("You are an Aquarius!");
    }
    // between February 19 to March 20
    else if (((month == 2) && (day >= 19)) || ((month == 3 && day <= 20))) {
      System.out.println("You are a Pisces!");
    }
    input.close();
  }
}
