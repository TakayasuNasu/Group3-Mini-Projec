package chess;

import chess.command.MacroMovement;
import chess.command.Movement;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import java.util.ArrayList;

public class Game {

  Board board = new Board();
  MovementFactory factory = new MovementFactory();
  MacroMovement mm = new MacroMovement();
  Piece piece;
  Player whitePlayer = new Player(board, true);
  Player blackPlayer = new Player(board, false);
  Player currentPlayer = this.whitePlayer; //Default player
  boolean isFinished = false;

  public void start() {
    Console.cellNumber();
    while (!this.isFinished) {

      Console.showBoard(this.board);
      Console.playerTurn(this.currentPlayer);
      Console.beforeCall();

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

      /**
       * Decide the destination from list where piece can move
       * if invalid is input -> loop
       * if "q" is input -> select the piece again (no player change)
       * else -> move the piece to the selected position.
       */
      int dest = 0;
      while(true) {
        Console.pieceAndPosition(this.piece, Integer.parseInt(input));
        Console.positions(positions);
        System.out.println("(If you want to choose other piece, please enter \"q\")");
        dest = this.currentPlayer.decide(positions);
        if (dest == -1) {
          Console.error(2);
        }else{
          break;
        }
      }
      if (dest == -2){
        continue;
      }

      Console.pieceMoved(this.piece, dest);
      movement.setDestination(dest);
      this.currentPlayer.move(movement, dest);
      this.mm.push(movement);
      if (this.board.getKing(this.getNextPlayer().isWhite).isGone) {
        Console.won(this.currentPlayer);
        break;
      }
      Console.changePlayer(this.currentPlayer);
      this.currentPlayer = this.getNextPlayer();
    }
  }

  private Player getNextPlayer() {
    return this.currentPlayer == this.whitePlayer ? this.blackPlayer : this.whitePlayer;
  }

}
