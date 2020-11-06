package chess.command;

import java.util.ArrayList;

public interface Movement {

  void run();

  ArrayList<Integer> where();

  void setDestination(int dest);

}
