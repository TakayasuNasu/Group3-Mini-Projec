package chess;

import java.util.ArrayList;

public class Game {

  Board board = new Board();
  Player whitePlayer = new Player(board);
  Player BlackPlayer = new Player(board);
  Console console = new Console();
  boolean isFinished = false;

  public void start() {
    while (!this.isFinished) {
      this.console.cellNumber();
      this.console.showBoard();
      try {
        this.whitePlayer.chose(1);
      } catch (Exception e) {
        e.printStackTrace();
      }
      this.isFinished = true;
    }
  }

  // to try unit test.
  public int hoge() {
    ArrayList<String> list = new ArrayList<String>();
    return 1;
  }
}
