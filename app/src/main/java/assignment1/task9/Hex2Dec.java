package assignment1.task9;

import java.util.Scanner;

/**
 * Converting Hexadecimals to Decimals.
 */
public class Hex2Dec {
  /**
   * Run the function.
   * 
   */
  public void run() {
    Scanner scan = new Scanner(System.in, "utf-8");
    System.out.print("Enter a hex number: ");
    String hex = scan.nextLine();
    hexToDecimal(hex);

    scan.close();
  }

  /**
   * Print out the deciaml value for a string containing a hexadecimal value.
   * 
   */
  private void hexToDecimal(String hex) {
    int toDecimal = Integer.parseInt(hex, 16);
    System.out.println("The decimal value for " + hex + " is " + toDecimal + ".");
  }
}
// I got inspiration here: https://www.javatpoint.com/java-hex-to-decimal
