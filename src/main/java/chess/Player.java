package chess;

import chess.command.Movement;
import chess.pieces.Piece;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {

  Board board;
  Validation valid = new Validation();
  Scanner scan = new Scanner(System.in);

  public Player(Board board) {
    this.board = board;
  }

  public Piece choose(int position) {
    return this.board.chosen(position);
  }

  public String call() {
    String input = scan.nextLine();
    if (!this.valid.playerCall(input, this.board)) {
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
