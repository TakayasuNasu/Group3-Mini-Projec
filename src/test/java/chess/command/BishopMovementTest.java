package chess.command;

import static org.junit.jupiter.api.Assertions.*;

import chess.Board;
import chess.pieces.Bishop;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BishopMovementTest {

  BishopMovement movement;
  int testPosition = 17; // set the position you want to check

  @BeforeEach
  void setUp() {
    Board board = new Board();
    Bishop bishop = new Bishop();
    bishop.position = testPosition;
    this.movement = new BishopMovement(1, bishop, board);
  }

  @Test
  void where() {

    ArrayList<Integer> positions = this.movement.where();
    System.out.println("Test position is: "+testPosition);

    System.out.print("The positions where the piece can move: ");
    System.out.println(Arrays.deepToString(positions.toArray()));

    String s1 = "|11|12|13|14|15|16|17|18|\n";
    String s2 = "|21|22|23|24|25|26|27|28|\n";
    String s3 = "|31|32|33|34|35|36|37|38|\n";
    String s4 = "|41|42|43|44|45|46|47|48|\n";
    String s5 = "|51|52|53|54|55|56|57|58|\n";
    String s6 = "|61|62|63|64|65|66|67|68|\n";
    String s7 = "|71|72|73|74|75|76|77|78|\n";
    String s8 = "|81|82|83|84|85|86|87|88|\n";

    /**
     * "  " == where the piece can move
     * "!!" == the position of piece itself
     */
    String s = s1+s2+s3+s4+s5+s6+s7+s8;
    for (Integer i: positions) {
      s = s.replace(Integer.toString(i), "  ");
    }
    s = s.replace(Integer.toString(testPosition), "!!");
    System.out.println(s);

  }
}