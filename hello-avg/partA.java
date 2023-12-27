import java.util.Scanner;

/**
 * @author Lawrence Li
 *
 */
public class partA {

  /**
   * Prints hello world sideways
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String myMessage;
    System.out.print("Input message: ");
    myMessage = input.nextLine();
    int num_char;
    num_char = myMessage.length();
    // loop that gets the letters uppercase or lowercase
    for (int i = 0; i < num_char; i++) {
      switch (myMessage.charAt(i)) {
        case 'h':
        case 'H':
          h();
          break;
        case 'e':
        case 'E':
          e();
          break;
        case 'l':
        case 'L':
          l();
          break;
        case 'o':
        case 'O':
          o();
          break;
        case 'w':
        case 'W':
          w();
          break;
        case 'r':
        case 'R':
          r();
          break;
        case 'd':
        case 'D':
          d();
          break;
        case ' ':
          blank();
          break;
      }
    }
  }

  // letter h
  public static void h() {
    System.out.printf("%n");
    System.out.printf("*******%n");
    System.out.printf("   *   %n");
    System.out.printf("   *   %n");
    System.out.printf("   *   %n");
    System.out.printf("*******%n");
    System.out.printf("%n");
  }

  // letter e
  public static void e() {
    System.out.printf("%n");
    System.out.printf("*******%n");
    System.out.printf("*  *  *%n");
    System.out.printf("*  *  *%n");
    System.out.printf("*  *  *%n");
    System.out.printf("*  *  *%n");
    System.out.printf("%n");
  }

  // letter l
  public static void l() {
    System.out.printf("%n");
    System.out.printf("*******%n");
    System.out.printf("*      %n");
    System.out.printf("*      %n");
    System.out.printf("*      %n");
    System.out.printf("*      %n");
    System.out.printf("%n");
  }

  // letter o
  public static void o() {
    System.out.printf("%n");
    System.out.printf("*******%n");
    System.out.printf("*     *%n");
    System.out.printf("*     *%n");
    System.out.printf("*     *%n");
    System.out.printf("*******%n");
    System.out.printf("%n");
  }

  // letter w
  public static void w() {
    System.out.printf("%n");
    System.out.printf("*******%n");
    System.out.printf("*      %n");
    System.out.printf("****   %n");
    System.out.printf("*      %n");
    System.out.printf("*******%n");
    System.out.printf("%n");
  }

  // letter r
  public static void r() {
    System.out.printf("%n");
    System.out.printf("*******%n");
    System.out.printf("   *  *%n");
    System.out.printf("  **  *%n");
    System.out.printf(" * ****%n");
    System.out.printf("*      %n");
    System.out.printf("%n");
  }

  // letter d
  public static void d() {
    System.out.printf("%n");
    System.out.printf("*******%n");
    System.out.printf("*     *%n");
    System.out.printf("*     *%n");
    System.out.printf(" *   * %n");
    System.out.printf("  ***  %n");
    System.out.printf("%n");
  }

  // blank space
  public static void blank() {
    System.out.printf("%n%n%n");
  }
}
