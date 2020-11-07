package chess.command;

import chess.Board;
import chess.Validation;
import chess.pieces.Piece;
import java.util.ArrayList;

public class BishopMovement implements Movement {

  //Instance variables
  int dest;  // The destination (position where the player is going to move the piece)
  Piece piece; // The piece objet the player is going to move
  Board board; // The board we are using now
  Validation valid = new Validation();// Create a validation object so that we can use validation method "canMove"


  //Constructor
  public BishopMovement(Piece piece, Board board) {
    this.piece = piece;
    this.board = board;
  }

  public BishopMovement(int dest, Piece piece, Board board) {
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

    int curPosition = this.piece.position;

    //Up   + right  direction　↗
    positions = searchDiagonal(curPosition, positions, -9);

    //Up   + Left   direction　↖
    positions = searchDiagonal(curPosition, positions, -11);

    //Down + right  direction　↘
    positions = searchDiagonal(curPosition, positions, 11);

    //Down + left   direction　↙
    positions = searchDiagonal(curPosition, positions, 9);

    return positions;
  }

  @Override
  public void setDestination(int dest) {
    this.dest = dest;
  }


  /**
   * Search if the piece can move in Diagonal way. There are 4 ways to search and each ways are
   * selected by {@code direction} {  ↗:-9 ,  ↖:-11,  ↘:11,  ↙:9 }
   *
   * @param cur       is the current position of the piece
   * @param positions is the list of position where the piece can move
   * @param direction is to set the direction of 4 diagonal ways {  ↗:-9 ,  ↖:-11,  ↘:11,  ↙:9 }
   * @return positions
   */
  public ArrayList<Integer> searchDiagonal(int cur, ArrayList<Integer> positions, int direction) {
    for (int i = 1; i < 8; i++) {
      // if the piece can not move -> stop searching
      if (!this.valid.canMove(cur + direction * i)) {
        return positions;
      }
      positions.add(cur + direction * i);
    }
    return positions;
  }
}
