package chess;

import java.util.ArrayList;
import java.util.Arrays;

public class Validation {

  public boolean canMove(int position) {
    if (position < 11) {
      return false;
    }
    if (position > 88) {
      return false;
    }
    if (new ArrayList<>(
        Arrays.asList(19, 20, 29, 30, 39, 40, 49, 50, 59, 60, 69, 70, 79, 80)
    ).contains(position)) {
      return false;
    }
    return true;
  }

}
