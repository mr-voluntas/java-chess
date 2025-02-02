package voluntas.chess.main;

public abstract class Piece {

  private String name;
  private String colour;
  private String icon;
  private String position;
  private boolean isTaken;

  public Piece(String name, String colour, String icon, String position) {
    this.name = name;
    this.colour = colour;
    this.icon = icon;
    this.position = position;
    this.isTaken = false;
  }

  public String getName() {
    return name;
  }

  public String getColour() {
    return colour;
  }

  public String getIcon() {
    return icon;
  }

  public String getPosition() {
    return position;
  }

  public boolean isTaken() {
    return isTaken;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public void setTaken(boolean isTaken) {
    this.isTaken = isTaken;
  }

  public void printIcon() {
    if (getColour().equals("white")) {
      System.out.printf("\u001B[1m\u001B[37m -%s- \u001B[0m", getIcon());
    } else {
      System.out.printf("\u001B[1m\u001B[38;5;16m -%s- \u001B[0m", getIcon());
    }
  }

}
