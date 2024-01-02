package assignment1.task6;

import java.util.Random;
import java.util.Scanner;

/**
 * Plays the popular scissor-rock-paper game.
 */
public class GameSRP {

  // Inpiration found here:
  // https://stackoverflow.com/questions/36826558/getting-rid-of-findbugs-random-object-created-and-used-only-once-when-random-i
  private static final Random RANDOM = new Random();

  /**
   * To run the normal scissor-rock-paper game 
   * where a scissor can cut paper a rock kan nock a scissor and a paper can wrap a rock,
   * (1 for scissor, 2 for rock or 3 for paper). The game will stop when it get 0 from input.
   */
  public void run() {
    Scanner scan = new Scanner(System.in, "utf-8");
    int playerInput = readNumber(scan);
    int playerWon = 0;
    int computerWon = 0;
    int draw = 0;

    do {
      String computerResult = computerShows();
      if (playerShows(playerInput).equals(computerResult)) {
        System.out.println("It's a draw!");
        draw++;
      } else if (playerWins(computerResult, playerShows(playerInput))) {
        System.out.println("You won" + "," + "computer had " + computerResult + "!");
        playerWon++;
      } else {
        System.out.println("You lost " + "," + "computer had " + computerResult + "!");
        computerWon++;
      }
      if (playerInput != 0) {
        playerInput = readNumber(scan);
      }
    } while (playerInput != 0);
  
  

    System.out.println(playerWon + "(you)" + computerWon + "(computer)" + draw + "(draw).");

    scan.close();
  }

  /**
   * The program get the computer the random options. 
   *
   * @return The corresponding string/word according to the random number received by the computer.
   */
  public String computerShows() { 

    int computerRnd = RANDOM.nextInt(3) + 1;
  
    if (computerRnd == 1) {
      return "scissor"; 
    } else if (computerRnd == 2) {
      return "rock";
    } else {
      return "paper";
    }
  }
   
  /**
   * The program asks the user for the options. 
   *
   *@param playerInput The input option from terminal.
   *@return The corresponding string/word according to the random number received by input option.
   */
  public String playerShows(int playerInput) { 

    int playerGet = playerInput;

    if (playerGet == 1) {
      return "scissor"; 
    } else if (playerGet == 2) {
      return "rock";
    } else {
      return "paper";
    }
  }

  private boolean playerWins(String computerHand, String playerHand) {
    if (playerHand.equals("paper") && computerHand.equals("rock")) {
      return true;
    } else if (playerHand.equals("scissor") && computerHand.equals("paper")) {
      return true;
    } else if (playerHand.equals("rock") && computerHand.equals("scissor")) {
      return true;
    } else {
      return false;
    }
  }

  // Inspiration found here:
  // https://stackoverflow.com/questions/13609121/how-to-check-if-an-input-is-an-int-and-is-between-two-values
  
  private int readNumber(Scanner scan) {

    int input;
    do {
      System.out.print("Scissor (1), rock (2), paper (3) or 0 to quit: ");
      while (!scan.hasNextInt()) {
        scan.nextLine(); 
        System.out.print("Please enter an integer between 1 and 3：");
      }
      input = scan.nextInt();
    } while (input != 0 && input != 1 && input != 2 && input != 3);
    
    return input;
  }

}
// I got inspiration here: https://stackoverflow.com/questions/42421171/create-a-program-in-java-that-allows-the-user-to-play-the-rock-paper-scissors-ga
// https://medium.com/geekculture/how-to-code-a-simple-rock-paper-scissors-game-in-java-7ec5dda68be1
