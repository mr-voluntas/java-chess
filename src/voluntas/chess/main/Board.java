package voluntas.chess.main;

import java.util.LinkedList;
import java.util.HashMap;

public class Board {

  public String[][] squares = new String[17][17];
  private LinkedList<Piece> pieces;

  public void newGame() {
    pieces = createPieces();
  }

  public void movePiece(String from, String to) {
    System.out.println("from " + from);
    System.out.println("to " + to);
    Piece pieceToMove = getPieceAtSquare(from);
    System.out.println(pieceToMove.getName() + ": " + pieceToMove.getPosition());
    pieceToMove.setPosition(to);
    printBoard();
  }

  public void printBoard() {
    System.out.println("");
    for (int row = 0; row < squares.length; row++) {
      if (row % 2 != 0) {
        System.out.println("");
      } else {
        System.out.printf("\u001B[38;5;250m|-----|-----|-----|-----|-----|-----|-----|-----|\u001B[0m\n", row);
      }
      for (int col = 0; col < squares.length; col++) {
        if (row % 2 == 0 && col == 0) {
          System.out.print(" ");
        }
        Piece pieceAtSquare = getPieceAtSquare(translateToSquare(col, row));
        if (pieceAtSquare != null) {
          if (pieceAtSquare.getColour().equals("black")) {
            System.out.printf("\u001B[1m\u001B[38;5;16m -%s-  \u001B[0m", pieceAtSquare.getIcon());
          } else {
            System.out.printf("\u001B[1m\u001B[37m -%s-  \u001B[0m", pieceAtSquare.getIcon());
          }
        } else {
        }
      }
    }
  }

  private String translateToSquare(int col, int row) {
    HashMap<Integer, String> rows = new HashMap<>();
    rows.put(14, "1");
    rows.put(12, "2");
    rows.put(10, "3");
    rows.put(8, "4");
    rows.put(6, "5");
    rows.put(4, "6");
    rows.put(2, "7");
    rows.put(0, "8");

    HashMap<Integer, String> cols = new HashMap<>();
    cols.put(0, "A");
    cols.put(2, "B");
    cols.put(4, "C");
    cols.put(6, "D");
    cols.put(8, "E");
    cols.put(10, "F");
    cols.put(12, "G");
    cols.put(14, "H");

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
    pieces.add(new Piece("bishop", "white", "B", "A1"));
    pieces.add(new Piece("knight", "white", "N", "B1"));
    pieces.add(new Piece("rook", "white", "R", "C1"));
    pieces.add(new Piece("queen", "white", "Q", "D1"));
    pieces.add(new Piece("king", "white", "K", "E1"));
    pieces.add(new Piece("rook", "white", "R", "F1"));
    pieces.add(new Piece("knight", "white", "N", "G1"));
    pieces.add(new Piece("bishop", "white", "B", "H1"));
    pieces.add(new Piece("pawn", "white", "P", "A2"));
    pieces.add(new Piece("pawn", "white", "P", "B2"));
    pieces.add(new Piece("pawn", "white", "P", "C2"));
    pieces.add(new Piece("pawn", "white", "P", "D2"));
    pieces.add(new Piece("pawn", "white", "P", "E2"));
    pieces.add(new Piece("pawn", "white", "P", "F2"));
    pieces.add(new Piece("pawn", "white", "P", "G2"));
    pieces.add(new Piece("pawn", "white", "P", "H2"));
    // Black pieces
    pieces.add(new Piece("bishop", "black", "B", "A8"));
    pieces.add(new Piece("knight", "black", "N", "B8"));
    pieces.add(new Piece("rook", "black", "R", "C8"));
    pieces.add(new Piece("queen", "black", "Q", "D8"));
    pieces.add(new Piece("king", "black", "K", "E8"));
    pieces.add(new Piece("rook", "black", "R", "F8"));
    pieces.add(new Piece("knight", "black", "N", "G8"));
    pieces.add(new Piece("bishop", "black", "B", "H8"));
    pieces.add(new Piece("pawn", "black", "P", "A7"));
    pieces.add(new Piece("pawn", "black", "P", "B7"));
    pieces.add(new Piece("pawn", "black", "P", "C7"));
    pieces.add(new Piece("pawn", "black", "P", "D7"));
    pieces.add(new Piece("pawn", "black", "P", "E7"));
    pieces.add(new Piece("pawn", "black", "P", "F7"));
    pieces.add(new Piece("pawn", "black", "P", "G7"));
    pieces.add(new Piece("pawn", "black", "P", "H7"));

    return pieces;
  }

}
