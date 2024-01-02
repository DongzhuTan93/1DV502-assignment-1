package assignment1.task2;

import java.util.Scanner;

/**
 * code for task 2.
 */
public class Time {
  /**
   * Reads a number of seconds and convert it to hours, minutes and seconds.
   *
   */
  public void run() {
    
    System.out.println("Give a number of seconds:");
    Scanner scan = new Scanner(System.in, "utf-8");
    int number = scan.nextInt();
    int hours = number / 3600;
    int minuters = (number / 60) % 60;
    int seconds = number % 60;

    String times =  hours + " hours " + minuters + " minutes " + seconds + " seconds.";
    System.out.println("This corresponds to: " + times);
    
    scan.close();
  }
} 
// I got inspiration here: https://www.geeksforgeeks.org/converting-seconds-into-days-hours-minutes-and-seconds/