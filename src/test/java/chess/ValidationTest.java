package chess;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationTest {

  Validation valid;

  @BeforeEach
  void setUp() {
    this.valid = new Validation();
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 19, 20, 29, 30, 39, 40, 49, 50, 59, 60, 69,
      70, 79, 80, 89, 90, 91, 92})
  void canMove(int position) {
    Assertions.assertTrue(!this.valid.canMove(position));
  }

  @ParameterizedTest
  @ValueSource(strings = {"help", "resign", "11", "24", "77", "88"})
  void playerCall(String input) {
    Board board = new Board();
    Assertions.assertTrue(this.valid.playerCall(input, board));
  }

  @ParameterizedTest
  @ValueSource(strings = {"hoge", "fuga", "5", "19", "31", "90"})
  void notPlayerCall(String input) {
    Board board = new Board();
    Assertions.assertTrue(!this.valid.playerCall(input, board));
  }
}