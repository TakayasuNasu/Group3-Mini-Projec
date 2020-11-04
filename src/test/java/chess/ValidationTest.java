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
}