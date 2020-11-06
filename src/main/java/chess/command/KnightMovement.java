package chess.command;

import chess.Board;
import chess.Validation;
import chess.pieces.Piece;
import java.util.ArrayList;

public class KnightMovement implements Movement {

  //Instance variables
  int dest;  // The destination (position where the player is going to move the piece)
  Piece piece; // The piece objet the player is going to move
  Board board; // The board we are using now
  Validation valid = new Validation();// Create a validation object so that we can use validation method "canMove"

  // Designated constructor
  public KnightMovement(int dest, Piece piece, Board board) {
    this.dest = dest;
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
    int pos1 = this.piece.position + 1 - 20;
    int pos2 = this.piece.position + 2 - 10;
    int pos3 = this.piece.position + 2 + 10;
    int pos4 = this.piece.position + 1 + 20;
    int pos5 = this.piece.position + -1 + 20;
    int pos6 = this.piece.position + -2 + 10;
    int pos7 = this.piece.position + -2 - 10;
    int pos8 = this.piece.position + -1 - 20;

    if (this.valid.canMove(pos1)) {
      positions.add(pos1);
    }
    if (this.valid.canMove(pos2)) {
      positions.add(pos2);
    }
    if (this.valid.canMove(pos3)) {
      positions.add(pos3);
    }
    if (this.valid.canMove(pos4)) {
      positions.add(pos4);
    }
    if (this.valid.canMove(pos5)) {
      positions.add(pos5);
    }
    if (this.valid.canMove(pos6)) {
      positions.add(pos6);
    }
    if (this.valid.canMove(pos7)) {
      positions.add(pos7);
    }
    if (this.valid.canMove(pos8)) {
      positions.add(pos8);
    }

    return positions;
  }

  @Override
  public void setDestination(int dest) {

  }
}


