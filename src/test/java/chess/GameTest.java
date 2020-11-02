package chess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameTest {

  Game game;

  @BeforeEach
  void breforeEach() {
    this.game = new Game();
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 1, 1})
  @DisplayName("Should check all items in the list")
  void shouldHoge(int value) {
    Assertions.assertEquals(value, this.game.hoge());
  }
}