package assignment1.task10;

import java.util.Scanner;

/**
 * Print out the month with days and the number for each day according to the input value.
 */
public class PrintCalendar {
  /**
   * Run the function.
   * 
   */
  public void run() {
    Scanner scan = new Scanner(System.in, "utf-8");
    System.out.print("Enter a year after 1800: ");
    int inputyear = scan.nextInt();

    System.out.print("Enter a month (1-12): ");
    int inputmonth = scan.nextInt();
    System.out.println(printMonth(inputmonth) + " " + inputyear);
    
    System.out.println("---------------------------");
    System.out.println("Mon Tue Wed Thu Fri Sat Sun");

    printCalendar(inputyear, inputmonth);

    scan.close();

  }

  /**
   * Count the input year.
   *
   * @return Reaturn the leap year if condition true.
   */
  private boolean leapYear(int inputyear) {

    if ((inputyear % 4 == 0 && inputyear % 100 != 0) 
        || (inputyear % 400 == 0 && inputyear % 100 == 0)) {
      return true;
    } else {
      return false;
    }
    // I got inspration here: https://www.wikihow.com/Calculate-Leap-Years
    // https://www.calendar-12.com/leap_year?#
  }

  /**
   * Count the input the days of the month.
   * 
   */

  private String printMonth(int inputmonth) {
    
    String[] monthOfyeaStrings = {"January", "February", "March",
        "April", "May", "June",
        "July", "August", "September",
        "October", "November", "December"};

    String printOutMon =  monthOfyeaStrings[inputmonth - 1];
    return printOutMon;

  }

  /**
   * Count the input the days of the months.
   *
   * @return The days of months.
   */
  private int printDaysOfmonth(int inputyear, int inputmonth) {

    int[] daysOfmonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    for (int monthsOfYear = 1; monthsOfYear <= 11; monthsOfYear++) {
      if (leapYear(inputyear) && printMonth(inputmonth) == "February") {
        daysOfmonth[monthsOfYear] = 29;
      }
    }
    int printDay = daysOfmonth[inputmonth - 1];
    return printDay;
  }

  /**
   * Get the number day of weeks.
   *
   * @return The number day where 0 is Saturday, 1 is Sunday and so on.
   */
  private int dayOfWeek(int inputyear, int inputmonth) {

    if (inputmonth == 1 || inputmonth == 2) {
      inputmonth += 12;
      inputyear--;   
      // inputmonth 3 is March, 4 is April. 
      // January and February are counted as months 13 and 14 for the previous year.
    }

    int dayOfWeek = (1 + ((26 * (inputmonth + 1)) / 10) + (inputyear % 100) 
        + ((inputyear % 100)  / 4) + ((inputyear / 100) / 4) + (5 * (inputyear / 100))) % 7;

    return dayOfWeek;  
  }
  // I got inspration here: https://gitlab.lnu.se/tanmsi/1dv502_assignments/-/blob/master/labb1/assignment1.md
 

  /**
   * Combine the print out calendar with the day of week.
   *
   * @return The position of the days of week.
   */
  private int startPosition(int inputyear, int inputmonth) {

    int representNumber = 0;

    if (dayOfWeek(inputyear, inputmonth) == 0) {
      representNumber = 5;    // Saturday
    } else if (dayOfWeek(inputyear, inputmonth) == 1) {
      representNumber = 6;   // Sunday
    } else if (dayOfWeek(inputyear, inputmonth) == 2) {
      representNumber = 0;   // Monday
    } else if (dayOfWeek(inputyear, inputmonth) == 3) {
      representNumber = 1;   // Tuesday
    } else if (dayOfWeek(inputyear, inputmonth) == 4) {
      representNumber = 2;   // Wednesday
    } else if (dayOfWeek(inputyear, inputmonth) == 5) {
      representNumber = 3;   // Thursday
    } else if (dayOfWeek(inputyear, inputmonth) == 6) {
      representNumber = 4;   // Friday
    }
    return representNumber;
  }

  /**
   * Print out the calendar.
   * 
   */
  private void printCalendar(int inputyear, int inputmonth) {

    for (int fourSpace = 0; fourSpace < startPosition(inputyear, inputmonth); fourSpace++) {
      System.out.print("    ");
    }
    
    int totaldays = 0;
    int days = 1;

    for (int oneSpace = 0; oneSpace <= 6; oneSpace++) {
      
      while (true) {
        for (; days <= printDaysOfmonth(inputyear, inputmonth); days++) {
          System.out.printf(" %2d ",  days);
          
          if ((startPosition(inputyear, inputmonth) + days + oneSpace) % 7 == 0) {
            System.out.print("\n");
          } 
          totaldays = days;
        }

        if ((totaldays == printDaysOfmonth(inputyear, inputmonth))) {
          break;
        }
      }
    }
    
    System.out.print(" ");
  }
} 