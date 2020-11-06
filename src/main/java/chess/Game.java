package chess;

import chess.command.MacroMovement;
import chess.command.Movement;
import chess.pieces.Piece;
import java.util.ArrayList;

public class Game {

  Board board = new Board();
  MovementFactory factory = new MovementFactory();
  MacroMovement mm = new MacroMovement();
  Piece piece;
  Player whitePlayer = new Player(board);
  Player BlackPlayer = new Player(board);
  boolean isFinished = false;

  public void start() {
    while (!this.isFinished) {
      Console.cellNumber();
      Console.showBoard(this.board);
      Console.beforeCall();
      String input = this.whitePlayer.call();
      if (input.equals("error")) {
        Console.error(1);
        continue;
      }
      this.piece = this.whitePlayer.choose(Integer.parseInt(input));
      Movement movement = this.factory.create(this.piece, this.board);
      ArrayList<Integer> positions = movement.where();
      Console.pieceAndPosition(this.piece, Integer.parseInt(input));
      Console.positions(positions);
      int dest = this.whitePlayer.decide(positions);
      if (dest == -1) {
        Console.error(2);
        continue;
      }
      movement.setDestination(dest);
      this.whitePlayer.move(movement);
      this.mm.push(movement);
      this.isFinished = true;
    }
  }

}
