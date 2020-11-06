package chess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {

  Board board;

  @BeforeEach
  void setUp() {
    this.board = new Board();
  }

  @Test
  void choosed() throws Exception {
    this.board.chosen(3);
  }
}