package chess.command;

import java.util.ArrayDeque;

public class MacroMovement implements Movement {

  private ArrayDeque<Movement> movements = new ArrayDeque();

  @Override
  public void run() {
    for (Movement m : this.movements) {
      m.run();
    }
  }

  public void push(Movement movement) {
    if (movement != this) {
      this.movements.push(movement);
    }
  }

  public void undo() {
    if (!this.movements.isEmpty()) {
      this.movements.pop();
    }
  }

  public void clear() {
    this.movements.clear();
  }
}
