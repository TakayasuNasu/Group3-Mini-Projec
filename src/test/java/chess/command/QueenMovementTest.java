package chess.command;

import static org.junit.jupiter.api.Assertions.*;

import chess.Board;
import chess.pieces.Queen;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueenMovementTest {

  QueenMovement movement;

  @BeforeEach
  void setUp() {
    Board board = new Board();
    Queen queen = new Queen();
    queen.position = 41;
    this.movement = new QueenMovement(queen, board);
  }

  @Test
  void where() {
    ArrayList<Integer> positions = this.movement.where();
    System.out.println(Arrays.deepToString(positions.toArray()));
  }
}