package chess.command;

import chess.Board;
import chess.Validation;
import chess.pieces.Piece;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class QueenMovement implements Movement {

  int dest;
  Piece piece;
  Board board;
  Validation valid = new Validation();

  public QueenMovement(Piece piece, Board board) {
    this.piece = piece;
    this.board = board;
  }

  @Override
  public void run() {
    this.piece.position = this.dest;
  }

  @Override
  public ArrayList<Integer> where() {
    ArrayList<Integer> positions = new ArrayList<>();

    int curPosition = this.piece.position;

//    { ↑:-10, ↓:+10, →:+1, ←: -1,  ↗:-9 ,  ↖:-11,  ↘:+11,  ↙:+9 }
    ArrayList<Integer> directions = new ArrayList<>();
    directions.add(-10); // Up    ↑
    directions.add(+10); // Down  ↓
    directions.add(-1);  // Right →
    directions.add(+1);  // Left  ←
    directions.add(-9);  // Up+Right   ↗
    directions.add(+9);  // Down+Left  ↙
    directions.add(-11); // Up+Left    ↖
    directions.add(+11); // Down+Right ↘

    for (int direction : directions) {
      positions = searchLine(curPosition, positions, direction);
    }

    return positions;
  }


  @Override
  public void setDestination(int dest) {
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



