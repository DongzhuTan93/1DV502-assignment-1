package assignment1.task4;

import java.util.Scanner;

/**
 * Calculate the minimum number of days you need to work to earn a specific amount.
 */
public class DangerousWork {
  /**
   * Tack the specific input amount and calculate the corresponding days.
   *
   */
  public void run() {
    Scanner scan = new Scanner(System.in, "utf-8");
    System.out.print("How much would you like to earn? ");

    int money = scan.nextInt();
    double firstDay = 0.01;
    double calculate = money / firstDay;
    double workDays = Math.round((Math.log(calculate) / Math.log(2))); 
    // (loga b = log10 b / log10 a) => (log2 N = log10 N / log10 2 ). 
    // The worksDays(N) is log input(money) to the base 2.

    int doubleToInt = (int) workDays;
    
    if (workDays < 30) {
      System.out.println("You will have your money in " + doubleToInt + " days.");
    } else {
      System.out.println("You are dead from overwork!");

    }
    scan.close();
  }
} 
// I got inspiration here: https://www.geeksforgeeks.org/how-to-calculate-log-base-2-of-an-integer-in-java/

