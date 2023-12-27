import java.util.Random;
import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class partB {

  /**
   * Guess a target between number 1-100 Output if guess is right
   *
   * @param args
   */
  public static void main(String[] args) {
    Long seed;
    if (args.length != 1) {
      seed = null;
      // the value must end in L, such as 1070L
    } else {
      seed = Long.valueOf(args[0]);
    }

    // Gets a random number between 1 and 100
    // Use the target variable as the correct answer for guessing
    Random random;
    if (seed == null) {
      random = new Random();
    } else {
      random = new Random(seed);
    }
    int target = (Math.abs(random.nextInt()) % 100) + 1;

    Scanner input = new Scanner(System.in);
    int guess;
    // do while loop that checks if guess equals target and outputs message
    do {
      System.out.print("Enter your guess (between 1 and 100): ");
      guess = input.nextInt();
      if (guess > 100) {
        System.out.println("Invalid guess, try again!");
      } else if (guess < 1) {
        System.out.println("Invalid guess, try again!");
      } else if (guess > target) {
        System.out.println("Too high!");
      } else if (guess < target) {
        System.out.println("Too low!");
      }
    } while (guess != target);
    {
      // when guess equals to target
      System.out.println("You win!");
    }
    input.close();
  }
}
