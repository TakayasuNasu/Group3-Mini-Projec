package chess.command;

import chess.Board;
import chess.Validation;
import chess.pieces.Piece;
import java.util.ArrayList;

public class PawnMovement implements Movement {

  //Instance variables
  int dest;  // The destination (position where the player is going to move the piece)
  Piece piece; // The piece objet the player is going to move
  Board board; // The board we are using now
  Validation valid = new Validation();// Create a validation object so that we can use validation method "canMove"


  // Designated constructor
  public PawnMovement(Piece piece, Board board) {
    this.piece = piece;
    this.board = board;
  }

  /**
   * Move the piece to where the player has decided.
   */
  @Override
  public void run() {
    this.piece.position = this.dest;
  }


  /**
   * Calculate and store list of positions that where the piece can go. Positions are stored as
   * ArrayList like {12,23,45}
   *
   * @return the ArrayList.
   */
  @Override
  public ArrayList<Integer> where() {
    ArrayList<Integer> positions = new ArrayList<>();

    int pos = this.piece.position;
    pos += piece.isWhite ? -10 : 10; // if piece is white->↑(0,-10), black->↓(0,10)

    if (this.valid.canMove(pos)) {
      positions.add(pos);
    }

    return positions;
  }

  @Override
  public void setDestination(int dest) {
    this.dest = dest;
  }
}
