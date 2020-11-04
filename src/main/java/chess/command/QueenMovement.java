package chess.command;

import chess.Board;
import chess.Validation;
import chess.pieces.Piece;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class QueenMovement implements Movement {

  int dest;
  Piece piece;
  Board board;
  Validation valid = new Validation();

  public QueenMovement() {
  }

  public QueenMovement(int dest, Piece piece, Board board) {
    this.dest = dest;
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
    // Upper
    for (int i = 1; i < 8; i++) {
      if (this.valid.canMove(this.piece.position - (10 * i))) {
        positions.add(this.piece.position - (10 * i));
      }
    }
    // Lower
    for (int i = 1; i < 8; i++) {
      if (this.valid.canMove(this.piece.position + (10 * i))) {
        positions.add(this.piece.position + (10 * i));
      }
    }
    // Right
    for (int i = 1; i < 8; i++) {
      int dest = this.piece.position + i;
      if (this.valid.canMove(dest)
          && dest < (this.piece.position % 10 + 1) * 10) {
        positions.add(dest);
      }
    }
    // Left
    for (int i = 1; i < 8; i++) {
      int dest = this.piece.position - i;
      if (this.valid.canMove(dest)
          && dest > (this.piece.position % 10 - 1) * 10) {
        positions.add(dest);
      }
    }
    // Upper right
    for (int i = 1; i < 8; i++) {
      int dest = this.piece.position - (10 * i) + i;
      if (Lists.newArrayList(19, 29, 39, 49, 59, 69, 79).contains(dest)) {
        break;
      }
      if (this.valid.canMove(dest)) {
        positions.add(dest);
      }
    }
    // Upper left
    for (int i = 1; i < 8; i++) {
      int dest = this.piece.position - (10 * i) - i;
      if (Lists.newArrayList(10, 20, 30, 40, 50, 60, 70).contains(dest)) {
        break;
      }
      if (this.valid.canMove(dest)) {
        positions.add(dest);
      }
    }
    // Lower right
    for (int i = 1; i < 8; i++) {
      int dest = this.piece.position + (10 * i) + i;
      if (Lists.newArrayList(19, 29, 39, 49, 59, 69, 79).contains(dest)) {
        break;
      }
      if (this.valid.canMove(dest)) {
        positions.add(dest);
      }
    }
    // Lower left
    for (int i = 1; i < 8; i++) {
      int dest = this.piece.position + (10 * i) - i;
      if (Lists.newArrayList(10, 20, 30, 40, 50, 60, 70).contains(dest)) {
        break;
      }
      if (this.valid.canMove(dest)) {
        positions.add(dest);
      }
    }
    return new ArrayList<>(new LinkedHashSet<>(positions));
  }
}
