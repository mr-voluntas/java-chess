package voluntas.chess.main;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Board board = new Board();
    Player playerWhite = new Player(true);
    Player playerBlack = new Player(false);
    @SuppressWarnings("resource")
    Scanner userInput = new Scanner(System.in);

    board.newGame();
    board.printBoard();

    while (true) {

      if (playerWhite.isActivePlayer()) {
        System.out.println("\nWhite players turn...");
        System.out.print("Enter your move: ");
        String move = userInput.nextLine();
        String[] movePosition = move.split(" ");
        String from = movePosition[0];
        String to = movePosition[1];
        if (board.movePiece("white", from, to)) {
          playerWhite.setActivePlayer(false);
          playerBlack.setActivePlayer(true);
        }
      }

      if (playerBlack.isActivePlayer()) {
        System.out.println("\nBlack players turn...");
        System.out.print("Enter your move: ");
        String move = userInput.nextLine();
        String[] movePosition = move.split(" ");
        String from = movePosition[0];
        String to = movePosition[1];
        if (board.movePiece("black", from, to)) {
          playerWhite.setActivePlayer(true);
          playerBlack.setActivePlayer(false);
        }
      }
    }

  }
}
