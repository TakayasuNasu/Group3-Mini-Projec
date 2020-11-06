package chess;

import chess.command.Movement;
import chess.command.PawnMovement;
import chess.command.QueenMovement;
import chess.pieces.Piece;

public class MovementFactory {

  public Movement movement;

  public Movement create(int dest, Piece piece, Board boare) {
    switch (piece.getClass().getSimpleName()) {
      case "Queen":
        this.movement = new QueenMovement(dest, piece, boare);
        break;
      case "Pawn":
        this.movement = new PawnMovement(dest, piece, boare);
        break;
      default:
        this.movement = new QueenMovement(dest, piece, boare);
    }
    return this.movement;
  }
}
