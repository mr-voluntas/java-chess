package voluntas.chess.main;

public class Piece {

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

}
