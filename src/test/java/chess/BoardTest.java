package chess;

import chess.pieces.Piece;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {

  Board board;

  @BeforeEach
  void setUp() {
    this.board = new Board();
  }

  @Test
  void promotion() {
    String queen = "Queen";
    Piece piece = this.board.pawnPromotion(this.board.chosen(11), queen);
    Assertions.assertEquals("Queen", piece.getClass().getSimpleName());
  }

}