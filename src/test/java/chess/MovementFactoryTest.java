package chess;

import static org.junit.jupiter.api.Assertions.*;

import chess.command.Movement;
import chess.command.QueenMovement;
import chess.pieces.Pawn;
import chess.pieces.Queen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovementFactoryTest {

  MovementFactory factory;
  Board board;

  @BeforeEach
  void setUp() {

    this.factory = new MovementFactory();
    this.board = new Board();
  }

  @Test
  void create() {
    Queen queen = new Queen();
    Movement qm = this.factory.create(queen, this.board);
    Assertions.assertEquals("QueenMovement", qm.getClass().getSimpleName());

    Pawn pawn = new Pawn();
    Movement pm = this.factory.create(pawn, this.board);
    Assertions.assertEquals("PawnMovement", pm.getClass().getSimpleName());

  }
}