package chess;

import chess.command.BishopMovement;
import chess.command.KingMovement;
import chess.command.KnightMovement;
import chess.command.Movement;
import chess.command.PawnMovement;
import chess.command.QueenMovement;
import chess.command.RookMovement;
import chess.pieces.Piece;

public class MovementFactory {

  public Movement movement;

  public Movement create(Piece piece, Board board) {
    switch (piece.getClass().getSimpleName()) {
      case "King":
        this.movement = new KingMovement(piece, board);
        break;
      case "Queen":
        this.movement = new QueenMovement(piece, board);
        break;
      case "Bishop":
        this.movement = new BishopMovement(piece, board);
        break;
      case "Rook":
        this.movement = new RookMovement(piece, board);
        break;
      case "Knight":
        this.movement = new KnightMovement(piece, board);
        break;
      case "Pawn":
        this.movement = new PawnMovement(piece, board);
        break;
      default:
        this.movement = new QueenMovement(piece, board);
    }
    return this.movement;
  }
}
