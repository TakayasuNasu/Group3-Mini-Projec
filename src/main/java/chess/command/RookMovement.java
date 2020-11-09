package chess.command;

import chess.Board;
import chess.Validation;
import chess.pieces.Piece;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class RookMovement implements Movement {

  //Instance variables
  int dest;  // The destination (position where the player is going to move the piece)
  Piece piece; // The piece objet the player is going to move
  Board board; // The board we are using now
  Validation valid = new Validation();// Create a validation object so that we can use validation method "canMove"


  // Designated constructor
  public RookMovement(Piece piece, Board board) {
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
   * ArrayList like {12,22,32,42} or Arraylist like{12,13,14,15,16}
   * Position ID
   *               1
   *
   *
   *  4            P              2
   *
   *
   *
   *
   *              3
   *
   * @return the ArrayList.
   */
  @Override
  public ArrayList<Integer> where() {

    ArrayList<Integer> positions = new ArrayList<>();

    int pos1 = this.piece.position + 0 - 10;
    int pos2 = this.piece.position + -1 + 0;
    int pos3 = this.piece.position + 1 + 0;
    int pos4 = this.piece.position + 0 + 10;

    //UP
    for (int i = 1; i < 8; i++) {
      if (this.valid.canMove(this.piece.position - (10 * i))) {
        positions.add(pos1);
        pos1-=10;
      }
    }
    //RIGHT
    for (int i = 1; i < 8; i++) {
      if (this.valid.canMove(pos2)) {
        positions.add(pos2);
        pos2--;
      }
    }
    //DOWN
    for (int i = 1; i < 8; i++) {
      if (this.valid.canMove(pos3)) {
        positions.add(pos3);
        pos3++;
      }
    }

    //LEFT
    for (int i = 1; i < 8; i++) {
      if (this.valid.canMove(this.piece.position + (10 * i))) {
        positions.add(pos4);
        pos4+=10;
      }
    }

    return positions;
  }

  @Override
  public void setDestination ( int dest){
    this.dest = dest;
  }
}

