package chess;

import chess.command.Movement;
import chess.command.PawnMovement;
import chess.command.QueenMovement;
import chess.pieces.Piece;

public class MovementFactory {

  public Movement movement;

  public Movement create(Piece piece, Board board) {
    switch (piece.getClass().getSimpleName()) {
      case "Queen":
        this.movement = new QueenMovement(piece, board);
        break;
      case "Pawn":
        this.movement = new PawnMovement();
        break;
      default:
        this.movement = new QueenMovement(piece, board);
    }
    return this.movement;
  }
}
