package assignment1.task3;

import java.util.Random;
import java.util.Scanner;

/**
 * code for task 3.
 */
public class Nine {
  // Inpiration found here:
  // https://stackoverflow.com/questions/36826558/getting-rid-of-findbugs-random-object-created-and-used-only-once-when-random-i
  private static final Random RANDOM = new Random();
  
  /**
   * Play dice with computer. Whoever has the max sum below 9 wins.
   */
  public void run() {
    Scanner scan = new Scanner(System.in, "utf-8");

    System.out.println("\nPlaying a game");
    System.out.println("==================");
    System.out.println("");

    System.out.print("Ready to play? (Y/N) ");
    String input = scan.nextLine();
    
    
    int yourFirstDice = 0;
    if (input.equals("Y")) {
      yourFirstDice = RANDOM.nextInt(6) + 1;
      System.out.println("You rolled " + yourFirstDice);
    } else {
      System.out.println("Closing the app ...");
      scan.close();
      return;
    }

    System.out.print("Would you like to roll again? (Y/N) ");
    input = scan.nextLine();

    int yourSecondDice = 0;
    if (input.equals("Y")) {
      yourSecondDice = RANDOM.nextInt(6) + 1;
    }

    int yourTotal = yourFirstDice + yourSecondDice;

    if (yourTotal > 9) {
      System.out.println("You lost!");
    } else {
      if (yourSecondDice != 0) {
        System.out.println("You rolled " + yourSecondDice + " and in total you have " + yourTotal);
      } else {
        System.out.println("You have " + yourTotal);
      }

      int computerFirstDice = RANDOM.nextInt(6) + 1;
      System.out.println("The computer rolled " + computerFirstDice);
      int computerTotalSum;

      if (computerFirstDice <= 4) {
        int computerSecondDice = RANDOM.nextInt(6) + 1;
        computerTotalSum = computerFirstDice + computerSecondDice;
        String output = "The computer rolls again and gets";
        System.out.println(output + " " +  computerSecondDice + " in total " + computerTotalSum);
      } else {
        computerTotalSum = computerFirstDice;
        System.out.print("The computer finished and got " + computerTotalSum + " in total.");
      }

      if (computerTotalSum > 9) {
        System.out.println("\nYou won!");
      } else {
        if (yourTotal > computerTotalSum) {
          System.out.println("\nYou won!");
        } else if (yourTotal == computerTotalSum) {
          System.out.println("\nEven!");
        } else {
          System.out.println("\nYou lost!");
        }
      }
    }

    scan.close();
  } 
}
// I got inspiration from teachers code from lecture 1.
