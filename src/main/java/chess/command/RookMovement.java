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
    int curPosition = this.piece.position;

    //  { ↑:-10, ↓:+10, →:+1, ←: -1,  ↗:-9 ,  ↖:-11,  ↘:+11,  ↙:+9 }
    ArrayList<Integer> directions = new ArrayList<>();
    directions.add(-10); // Up    ↑
    directions.add(-1); // Down  ↓
    directions.add(1);  // Right →
    directions.add(10);  // Left  ←

    for (int direction : directions) {
      positions = searchLine(curPosition, positions, direction);
    }

    return positions;
  }

  @Override
  public void setDestination ( int dest){
    this.dest = dest;
  }


  /**
   * Search if the piece can move in straight line <---->. There are 8 ways to search and each ways
   * are selected by {@code direction} { ↑:-10, ↓:+10, →:+1, ←: -1,  ↗:-9 ,  ↖:-11,  ↘:+11,  ↙:+9 }
   *
   * @param cur       is the current position of the piece
   * @param positions is the list of position where the piece can move
   * @param direction is to set the direction of 8 straight ways { ↑:-10, ↓:+10, →:+1, ←: -1,  ↗:-9
   *                  ,  ↖:-11,  ↘:+11,  ↙:+9 }
   * @return positions
   */
  public ArrayList<Integer> searchLine(int cur, ArrayList<Integer> positions, int direction) {

    // Before start searching the line, initialize the didEncounter variable.
    // Because it never encountered other piece
    this.valid.setDidEncounter(false);
    for (int i = 1; i < 8; i++) {
      // if the piece can not move -> stop searching
      if (!this.valid.canMove(piece, board, cur + direction * i)) {
        return positions;
      }
      positions.add(cur + direction * i);
    }
    return positions;
  }


}