package chess;

import chess.pieces.Piece;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.lang.math.NumberUtils;

public class Validation {

//  public boolean canMove(Board board, int position) {
//    Piece piece = board.chosen(position);
//    if (piece == null) {
//      return false;
//    }
//    return this.canMove(position);
//  }

  /**
   * Check if the piece can move at the {@code position}
   *  by Validating the "Existing Piece ".
   *
   *  If some piece {@code position} already exit,
   *   and the color is same -> false
   *   and the color is different -> ture but only once
   *
   * @param myPiece is the piece that you want to move
   * @param board is the board you are playing on now
   * @param position is the location where you want to check if you can move. (Not added yet!)
   * @return
   */
  public boolean canMove(Piece myPiece, Board board, int position) {
    Piece piece = board.chosen(position);
    if (piece != null) {
      if (piece.isWhite == myPiece.isWhite) {
        return false;
      }else{
        // have to fix here
        return true;
      }
    }
    return this.canMove(position);
  }

  /**
   * Check if the piece can move at the {@code position}
   *  by Validating the "Board Area".
   *
   *  If the {@code position} is not in the Board, return false.
   *
   * @param position is the location where you want to check if you can move.
   * @return
   */
  public boolean canMove(int position) {
    if (position < 11) {
      return false;
    }
    if (position > 88) {
      return false;
    }
    if (Lists.newArrayList(19, 20, 29, 30, 39, 40, 49, 50, 59, 60, 69, 70, 79, 80)
        .contains(position)) {
      return false;
    }
    return true;
  }

  public boolean playerCall(String input, Board board) {
    if (Lists.newArrayList("help", "resign").contains(input)) {
      return true;
    }
    if (!NumberUtils.isDigits(input)) {
      return false;
    }
    int position = Integer.parseInt(input);
    Piece p = board.chosen(position);
    if (p == null) {
      return false;
    }
    return true;
  }

  public boolean playerDecide(String input, ArrayList<Integer> positions) {
    if (!NumberUtils.isDigits(input)) {
      return false;
    }
    if (!positions.contains(Integer.parseInt(input))) {
      return false;
    }
    return true;
  }

}
