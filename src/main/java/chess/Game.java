package chess;

import chess.command.MacroMovement;
import chess.command.Movement;
import chess.pieces.Piece;
import java.util.ArrayList;

public class Game {

  Board board = new Board();
  Player whitePlayer = new Player(board);
  Player BlackPlayer = new Player(board);
  Console console = new Console();
  Piece piece;
  MovementFactory factory = new MovementFactory();
  MacroMovement mm = new MacroMovement();
  boolean isFinished = false;

  public void start() {
    while (!this.isFinished) {
      this.console.cellNumber();
      this.console.showBoard();
      try {
        this.piece = this.whitePlayer.chose(1);
      } catch (Exception e) {
        e.printStackTrace();
      }
      Movement movement = this.factory.create(2, this.piece, this.board);
      ArrayList<Integer> positions = movement.where();
      console.positions(positions);
      this.whitePlayer.move(movement);
      this.mm.push(movement);
      this.isFinished = true;
    }
  }

}
