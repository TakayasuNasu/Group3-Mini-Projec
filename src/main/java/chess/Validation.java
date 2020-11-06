package chess;

import chess.pieces.Piece;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.lang.math.NumberUtils;

public class Validation {

  public boolean canMove(Board board, int position) {
    Piece piece = board.chosen(position);
    if (piece == null) {
      return false;
    }
    return this.canMove(position);
  }

  public boolean canMove(Piece myPiece, Board board, int position) {
    Piece piece = board.chosen(position);
    if (piece == null) {
      return false;
    }
    if (piece.isWhite == myPiece.isWhite) {
      return false;
    }
    return this.canMove(position);
  }

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
    if (!p.isGone) {
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
