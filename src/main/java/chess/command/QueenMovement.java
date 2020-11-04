package chess.command;

import chess.Board;
import chess.pieces.Piece;

public class QueenMovement implements Movement {

  int dest;
  Piece piece;
  Board board;

  public QueenMovement() {
  }

  public QueenMovement(int dest, Piece piece, Board board) {
    this.dest = dest;
    this.piece = piece;
    this.board = board;
  }

  @Override
  public void run() {
    this.piece.position = this.dest;
  }
}
