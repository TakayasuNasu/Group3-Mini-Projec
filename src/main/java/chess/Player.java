package chess;

import chess.command.Movement;
import chess.pieces.Piece;

public class Player {

  Board board;

  public Player() {
  }

  public Player(Board board) {
    this.board = board;
  }

  public Piece chose(int position) throws Exception {
    return this.board.choosed(position);
  }

  public void move(Movement movement) {
    movement.run();
  }
}
