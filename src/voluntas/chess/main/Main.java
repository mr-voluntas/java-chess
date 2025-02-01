package voluntas.chess.main;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Board board = new Board();
    // Player playerWhite = new Player(true);
    // Player playerBlack = new Player(false);

    board.newGame();
    board.printBoard();

    Scanner userInput = new Scanner(System.in);

    System.out.println("Make a move...");
    String move = userInput.nextLine();
    String[] moves = move.split(" ");
    board.movePiece(moves[0], moves[1]);

    userInput.close();
  }
}
