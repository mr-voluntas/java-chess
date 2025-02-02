package voluntas.chess.main;

import java.util.LinkedList;
import java.util.HashMap;

public class Board {

  private String[][] squares = new String[8][8];
  private LinkedList<Piece> pieces;

  public void newGame() {
    pieces = createPieces();
  }

  public boolean movePiece(String colour, String from, String to) {
    Piece pieceToMove = getPieceAtSquare(from);
    if (pieceToMove.getColour().equals(colour)) {
      System.out.println("Moving " + pieceToMove.getName() + " from " + pieceToMove.getPosition() + " to " + to);
      pieceToMove.setPosition(to);
      printBoard();
      return true;
    } else {
      printBoard();
      System.out.printf("\nThe %s at %s is not your piece, try again.\n", pieceToMove.getName(), from);
      return false;
    }
  }

  public void printBoard() {
    System.out.println("");
    for (int row = 0; row < squares.length; row++) {
      System.out.println("\n\u001B[38;5;250m   |-----|-----|-----|-----|-----|-----|-----|-----|\u001B[0m");
      for (int col = 0; col < squares.length; col++) {
        if (col == 0) {
          System.out.printf("\u001B[38;5;250m %s |", squares.length - row);
        }
        Piece pieceAtSquare = getPieceAtSquare(translateToSquare(col, row));
        if (pieceAtSquare != null) {
          pieceAtSquare.printIcon();
        } else {
          System.out.print("     ");
        }
        System.out.print("\u001B[38;5;250m|");
      }
    }
    System.out.println("\n\u001B[38;5;250m   |-----|-----|-----|-----|-----|-----|-----|-----|\u001B[0m");
    System.out.println("\u001B[38;5;250m      A     B     C     D     E     F     G     H   \u001B[0m");
  }

  private String translateToSquare(int col, int row) {
    HashMap<Integer, String> rows = new HashMap<>();
    rows.put(0, "8");
    rows.put(1, "7");
    rows.put(2, "6");
    rows.put(3, "5");
    rows.put(4, "4");
    rows.put(5, "3");
    rows.put(6, "2");
    rows.put(7, "1");

    HashMap<Integer, String> cols = new HashMap<>();
    cols.put(0, "A");
    cols.put(1, "B");
    cols.put(2, "C");
    cols.put(3, "D");
    cols.put(4, "E");
    cols.put(5, "F");
    cols.put(6, "G");
    cols.put(7, "H");

    return cols.get(col) + rows.get(row);
  }

  private Piece getPieceAtSquare(String square) {
    Piece foundPiece = null;
    for (Piece piece : pieces) {
      if (piece.getPosition().equals(square)) {
        foundPiece = piece;
      }
    }
    return foundPiece;
  }

  private LinkedList<Piece> createPieces() {
    LinkedList<Piece> pieces = new LinkedList<>();
    // White pieces
    pieces.add(new Bishop("white", "A1"));
    pieces.add(new Knight("white", "B1"));
    pieces.add(new Rook("white", "C1"));
    pieces.add(new Queen("white", "D1"));
    pieces.add(new King("white", "E1"));
    pieces.add(new Rook("white", "F1"));
    pieces.add(new Knight("white", "G1"));
    pieces.add(new Bishop("white", "H1"));
    pieces.add(new Pawn("white", "A2"));
    pieces.add(new Pawn("white", "B2"));
    pieces.add(new Pawn("white", "C2"));
    pieces.add(new Pawn("white", "D2"));
    pieces.add(new Pawn("white", "E2"));
    pieces.add(new Pawn("white", "F2"));
    pieces.add(new Pawn("white", "G2"));
    pieces.add(new Pawn("white", "H2"));
    pieces.add(new Pawn("white", "H2"));

    // Black pieces
    pieces.add(new Bishop("black", "A8"));
    pieces.add(new Knight("black", "B8"));
    pieces.add(new Rook("black", "C8"));
    pieces.add(new Queen("black", "D8"));
    pieces.add(new King("black", "E8"));
    pieces.add(new Rook("black", "F8"));
    pieces.add(new Knight("black", "G8"));
    pieces.add(new Bishop("black", "H8"));
    pieces.add(new Pawn("black", "A7"));
    pieces.add(new Pawn("black", "B7"));
    pieces.add(new Pawn("black", "C7"));
    pieces.add(new Pawn("black", "D7"));
    pieces.add(new Pawn("black", "E7"));
    pieces.add(new Pawn("black", "F7"));
    pieces.add(new Pawn("black", "G7"));
    pieces.add(new Pawn("black", "H7"));
    pieces.add(new Pawn("black", "H7"));

    return pieces;
  }

}
