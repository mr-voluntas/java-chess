package voluntas.chess.main;

public class Player {

  private boolean isActivePlayer;

  public Player(boolean isActivePlayer) {
    this.isActivePlayer = isActivePlayer;
  }

  public boolean isActivePlayer() {
    return isActivePlayer;
  }

  public void setActivePlayer(boolean isActivePlayer) {
    this.isActivePlayer = isActivePlayer;
  }

}
