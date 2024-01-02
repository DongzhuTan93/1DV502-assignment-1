package assignment1.task5;

import java.util.Scanner;

/**
 * Create an diamond of stars by having the users positive number input.
 */
public class Diamonds {
  /**
   * Turn a positive input number to the specific shape of diamond.
   *
   */
  public void run() {
    Scanner scan = new Scanner(System.in, "utf-8");
    System.out.print("Give a positive number: ");
    int inputNumber = scan.nextInt();
   
    if (inputNumber > 0) {
      for (int rows = 1; rows <= inputNumber; rows++) { 
        for (int spaces = inputNumber; spaces > rows; spaces--) {
          System.out.print(" ");
        }
        for (int star = 1; star <= rows * 2 - 1; star++) {
          System.out.print("*");
        }
        System.out.print("\n");
      }
 
      for (int i = inputNumber - 1; i >= 1; i--) {
        for (int spaces = 1; spaces <= inputNumber - i; spaces++) {
          System.out.print(" ");
        }
        for (int star = 1; star <= i * 2 - 1; star++) {
          System.out.print("*");
        }
        System.out.print("\n");
      }
    } else {
      System.out.print("Please enter a positive number!! ");
      
    } 
    scan.close();
  }
} 
// I got inspiration here: https://www.youtube.com/watch?v=aTsuiEvxrDs
// https://www.youtube.com/watch?v=UGm5lEJmN6g
