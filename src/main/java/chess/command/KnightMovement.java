package chess.command;

import chess.Board;
import chess.Validation;
import chess.pieces.Knight;
import chess.pieces.Piece;
import java.util.ArrayList;

public class KnightMovement implements Movement {

  //Instance variables
  int dest;  // The destination (position where the player is going to move the piece)
  Piece piece; // The piece objet the player is going to move
  Board board; // The board we are using now
  Validation valid = new Validation();// Create a validation object so that we can use validation method "canMove"

  //Constructor
  public KnightMovement(Piece piece, Board board) {
    this.piece = piece;
    this.board = board;
  }

  public KnightMovement(int dest, Piece piece, Board board) {
    this(piece, board);
    this.setDestination(dest);
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

    /**
     *
     * Position id
     *   8   1
     * 7       2
     *     p
     * 6       3
     *   5   4
     *
     * Check if it can move to 1...8
     */

    // ex (1 -20) means +1 to x axis, -20 to y axis

    ArrayList<Integer> candidates = new ArrayList<>();
    candidates.add( 1 - 20);
    candidates.add( 2 - 10);
    candidates.add( 2 + 10);
    candidates.add( 1 + 20);
    candidates.add(-1 + 20);
    candidates.add(-2 + 10);
    candidates.add(-2 - 10);
    candidates.add(-1 - 20);

    for (int pos: candidates) {
      if (this.valid.canMove(this.piece.position + pos)) {
        positions.add(this.piece.position + pos);
      }
    }

    return positions;
  }

  @Override
  public void setDestination(int dest) {
    this.dest = dest;
  }
}


