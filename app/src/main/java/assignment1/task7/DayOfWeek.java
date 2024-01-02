package assignment1.task7;

import java.util.Scanner;

/**
 * Asks for a day and prints the name of that day.
 */
public class DayOfWeek {
  /**
   * To run the game according to the input of the year/month/day of the month
   * then print the name of that day.
   * 
   */
  public void run() {
    Scanner scan = new Scanner(System.in, "utf-8");
    System.out.print("Enter year: ");
    int year = scan.nextInt();

    System.out.print("Enter month (1-12): ");
    int month = scan.nextInt();

    System.out.print("Enter day of the month (1-31): ");
    int day = scan.nextInt();

  
    final String[] theDays = new String[]{"Saturday",
      "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"}; 

    if (month == 1 || month == 2) {
      month += 12;
      year--;
    }

    int j = year / 100;
    int k = year % 100;
    int q = day;
    int m = month;

    int h = (q + 26 * (m + 1) / 10 + k + k / 4 + j / 4 + 5 * j) % 7;

    System.out.print("Day of th week is " + theDays[h]);

    scan.close();

  }
}
// I got inspiration here: https://stackoverflow.com/questions/6840020/day-of-the-week-java-and-zellers-congruence

// https://stackoverflow.com/questions/17390785/determining-day-of-the-week-using-zellers-congruence-in-java

// https://stackoverflow.com/questions/42421171/create-a-program-in-java-that-allows-the-user-to-play-the-rock-paper-scissors-ga
