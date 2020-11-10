package chess;

import static org.junit.jupiter.api.Assertions.*;

import chess.pieces.Piece;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

  Player player;
  boolean playerColor = true;

  @BeforeEach
  void setUp() {
    this.player = new Player(new Board(), playerColor);
  }

  @Test
  void choose() throws Exception {
    Piece piece = this.player.choose(11);
  }

}