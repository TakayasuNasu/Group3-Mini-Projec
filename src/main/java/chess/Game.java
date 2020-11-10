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
  Player currentPlayer;
  Player whitePlayer = new Player(board);
  Player blackPlayer = new Player(board);
  boolean isFinished = false;

  public void start() {
    while (!this.isFinished) {
      Console.cellNumber();
      Console.showBoard(this.board);
      Console.beforeCall();
      this.currentPlayer = this.getNextPlayer();
      String input = this.currentPlayer.call();
      if (input.equals("error")) {
        Console.error(1);
        continue;
      }
      if (input.equals("help")) {
        Console.help();
        continue;
      }
      if (input.equals("resign")) {
        Console.resign(this.currentPlayer);
        break;
      }
      this.piece = this.currentPlayer.choose(Integer.parseInt(input));
      Movement movement = this.factory.create(this.piece, this.board);
      ArrayList<Integer> positions = movement.where();
      Console.pieceAndPosition(this.piece, Integer.parseInt(input));
      Console.positions(positions);
      int dest = this.currentPlayer.decide(positions);
      if (dest == -1) {
        Console.error(2);
        continue;
      }
      movement.setDestination(dest);
      this.currentPlayer.move(movement);
      this.mm.push(movement);
      Console.changePlayer();
    }
  }

  private Player getNextPlayer() {
    if (this.currentPlayer == null) {
      this.currentPlayer = this.whitePlayer;
    }
    return this.currentPlayer == this.whitePlayer ? this.blackPlayer : this.whitePlayer;
  }

}
