package chess;

import static org.junit.jupiter.api.Assertions.*;

import chess.pieces.Pawn;
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
  void choosed() throws Exception {
    this.board.chosen(3);
  }

  @Test
  void promotion() {
    String queen = "Queen";
    Pawn pawn = new Pawn(11);
    Piece piece = this.board.pawnPromotion(pawn,queen);
    System.out.println(pawn.symbol);
    Assertions.assertEquals("Queen", piece.getClass().getSimpleName());
    System.out.println(piece.symbol);
  }

}