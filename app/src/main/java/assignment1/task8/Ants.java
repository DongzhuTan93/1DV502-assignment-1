package assignment1.task8;

import java.util.Random;


/**
 * Count the number of steps the ants move on the chessboard and the average number of steps.
 */
public class Ants {
  // Inpiration found here:
  // https://stackoverflow.com/questions/36826558/getting-rid-of-findbugs-random-object-created-and-used-only-once-when-random-i
  private static final Random RANDOM = new Random();

  /**
   * The ant's total steps of the whole square on the chessboard, and the average number of steps.
   * 
   */
  public void run() {

    System.out.println("Ants");
    System.out.println("=======");
    System.out.println();
    int totalSteps = 0;

    for (int i = 0; i < 10; i++) {
      int moveOfSteps = 0;
      int sumOfSquare = 0;
      int x = 0;
      int y = 0;
      int limmitSquare = 64; 
      int[][] grid = new int[8][8];
      
      while (true) {
        int randomNum = RANDOM.nextInt(4) + 1;

        if (randomNum == 1) {
          if (x != 7) {
            x++;      // Move to the right
          } else {
            x--;      // Move back if ant falls off
          }
        }

        if (randomNum == 2) {
          if (x != 0) {
            x--;      // Move to the left
          } else {
            x++;
          }
        }

        if (randomNum == 3) {
          if (y != 7) {
            y++;     // Move up
          } else {
            y--;     
          }  
        }

        if (randomNum == 4) {
          if (y != 0) {
            y--;    // Move down
          } else {
            y++;    
          }
        }
        moveOfSteps++;

        if (grid[x][y] == 0) {
          grid[x][y] = 1;    // Set the position to 1 if the ant have already been there
          sumOfSquare++;
        }

        if (sumOfSquare == limmitSquare) {
         
          break;
        }
      } 

      System.out.println("Number of steps in simulation " + (i + 1) + ":" + " " + moveOfSteps);
      
      totalSteps = totalSteps + moveOfSteps;
      
    }
      
    int average = totalSteps / 10;
    System.out.print("Average amount of steps: " + average);
  }
}
// I got inspiration here: https://stackoverflow.com/questions/59805045/ant-on-a-chess-board
// https://stackoverflow.com/questions/59805045/ant-on-a-chess-board/59805298#59805298
// https://stackoverflow.com/questions/20321181/java-antwalk-2d-arrays
