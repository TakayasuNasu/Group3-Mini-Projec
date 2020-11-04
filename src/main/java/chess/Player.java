package chess;

import chess.command.Movement;
import chess.pieces.Piece;
import java.util.Arrays;

public class Player {

  Board board;
  MovementFactory factory = new MovementFactory();

  public Player() {
  }

  public Player(Board board) {
    this.board = board;
  }

  public int chose(int position) throws Exception {
    Piece piece = this.board.choosed(position);
    Movement movement = this.factory.create(2, piece, this.board);
    movement.run();
    return piece.position;
  }
}
