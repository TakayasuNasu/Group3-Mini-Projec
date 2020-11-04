package chess;

import static org.junit.jupiter.api.Assertions.*;

import chess.pieces.Piece;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

  Player player;

  @BeforeEach
  void setUp() {
    this.player = new Player(new Board());
  }

  @Test
  void chose() throws Exception {
    Piece piece = this.player.chose(1);
  }

}