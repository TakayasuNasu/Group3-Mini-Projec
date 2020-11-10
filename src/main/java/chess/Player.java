package chess;

import chess.command.Movement;
import chess.pieces.Piece;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {

  Board board;
  Validation valid = new Validation();
  Scanner scan = new Scanner(System.in);
  boolean isWhite;

  public Player(Board board, boolean isWhite) {
    this.board = board;
    this.isWhite = isWhite;
  }

  /**
   * Get the info of piece at {@code position} of current board.
   * If there is no piece or, player's color and the piece's color is wrong
   *  -> return null
   *
   * @param position that the player has selected
   * @return the info of piece, or null
   */
  public Piece choose(int position) {
    return this.board.chosen(position);
  }

  public String call() {
    String input = scan.nextLine();
    if (!this.valid.playerCall(input, this.board, this.isWhite)) {
      return "error";
    }
    return input;
  }

  public int decide(ArrayList<Integer> positions) {
    String input = scan.nextLine();
    if (!this.valid.playerDecide(input, positions)) {
      return -1;
    }
    return Integer.parseInt(input);
  }

  public void move(Movement movement) {
    movement.run();
  }
}
