package chess;

import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.lang.math.NumberUtils;

public class Validation {

  /**
   *  This variables is used in {@code canMove()} method,
   *  so the piece can go to the opponent piece's position only the "first" time,
   *  but can not go further than it.
   *
   *  We can manage, "if the piece (you are trying to move) has encountered to opponent piece",
   *  while searching the positions.
   *
   *  How it works:
   *
   *  if this {@code didEncounter} is false && the piece encounter to the opponent piece,
   *   == you can move to the position. And {@code didEncounter} become true.
   *
   *  if this {@code didEncounter} is ture
   *   == it means you've already encountered to the piece
   *   == you can't go further
   *   == so always return false at {@code canMove()} method.
   *
   *  ex)
   *  {w->, , , , B,B}  : {@code didEncounter} false
   *  {  , , , , w,B}   : {@code didEncounter} true
   *
   */
  boolean didEncounter = false;
  public void setDidEncounter(boolean didEncounter) {
    this.didEncounter = didEncounter;
  }

  /**
   * Check if the piece can move at the {@code position}
   *  by Validating the "Existing Piece ".
   *
   *  If some piece {@code position} already exit,
   *   and the color is same -> false
   *   and the color is different -> true
   *
   * @param myPiece is the piece that you want to move
   * @param board is the board you are playing on now
   * @param position is the location where you want to check if you can move. (Not added yet!)
   * @return
   */
  public boolean canMove(Piece myPiece, Board board, int position) {
    Piece piece = board.chosen(position);

    //if the piece encountered to other piece before, you can't move further.
    if (didEncounter){
      return false;
    }

    // If some piece already exist at the position, check the color
    if (piece != null) {

      // if the piece belongs to the user, you never can go there.
      if (piece.isWhite == myPiece.isWhite) {
        return false;

      // if the piece belongs to the opponent, you can go only once (take it)
      }else{
          didEncounter = true; // Encountered to the piece
          return true;
      }
    }

    //If there is no piece, check if it is on the board.
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

    int xAxis = position%10;
    int yAxis = position/10%10;

    return xAxis >= 1 && xAxis <= 8 && yAxis >= 1 && yAxis <= 8;
  }

  public boolean playerCall(String input, Board board, boolean playersColor) {
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
    // if the chosen piece's color and player color don't much -> false
    if (p.isWhite != playersColor) {
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
