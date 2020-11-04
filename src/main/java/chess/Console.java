package chess;

import java.util.ArrayList;
import java.util.Arrays;

public class Console {

  void cellNumber() {
    System.out.println("-------------------------");
    System.out.println("|11|12|13|14|15|16|17|18|");
    System.out.println("|21|22|23|24|25|26|27|28|");
    System.out.println("|31|32|33|34|35|36|37|38|");
    System.out.println("|41|42|43|44|45|46|47|48|");
    System.out.println("|51|52|53|54|55|56|57|58|");
    System.out.println("|61|62|63|64|65|66|67|68|");
    System.out.println("|71|72|73|74|75|76|77|78|");
    System.out.println("|81|82|83|84|85|86|87|88|");
    System.out.println("-------------------------");
  }

  void showBoard() {
    System.out.println("-------------------------");
    System.out.printf("|%s|%s|%s|%s|%s|%s|%s|%s|\n",
        Symbol.BLACK_ROOK,
        Symbol.BLACK_KNIGHT,
        Symbol.BLACK_BISHOP,
        Symbol.BLACK_QUEEN,
        Symbol.BLACK_KING,
        Symbol.BLACK_BISHOP,
        Symbol.BLACK_KNIGHT,
        Symbol.BLACK_ROOK
    );
    System.out.printf("|%s|%s|%s|%s|%s|%s|%s|%s|\n",
        Symbol.BLACK_PAWN,
        Symbol.BLACK_PAWN,
        Symbol.BLACK_PAWN,
        Symbol.BLACK_PAWN,
        Symbol.BLACK_PAWN,
        Symbol.BLACK_PAWN,
        Symbol.BLACK_PAWN,
        Symbol.BLACK_PAWN
    );
    System.out.printf("|%s|%s|%s|%s|%s|%s|%s|%s|\n",
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY
    );
    System.out.printf("|%s|%s|%s|%s|%s|%s|%s|%s|\n",
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY
    );
    System.out.printf("|%s|%s|%s|%s|%s|%s|%s|%s|\n",
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY
    );
    System.out.printf("|%s|%s|%s|%s|%s|%s|%s|%s|\n",
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY,
        Symbol.EMPTY
    );
    System.out.printf("|%s|%s|%s|%s|%s|%s|%s|%s|\n",
        Symbol.WHITE_PAWN,
        Symbol.WHITE_PAWN,
        Symbol.WHITE_PAWN,
        Symbol.WHITE_PAWN,
        Symbol.WHITE_PAWN,
        Symbol.WHITE_PAWN,
        Symbol.WHITE_PAWN,
        Symbol.WHITE_PAWN
    );
    System.out.printf("|%s|%s|%s|%s|%s|%s|%s|%s|\n",
        Symbol.WHITE_ROOK,
        Symbol.WHITE_KNIGHT,
        Symbol.WHITE_BISHOP,
        Symbol.WHITE_QUEEN,
        Symbol.WHITE_KING,
        Symbol.WHITE_BISHOP,
        Symbol.WHITE_KNIGHT,
        Symbol.WHITE_ROOK
    );
    System.out.println("-------------------------");
  }

  void positions(ArrayList<Integer> positions) {
    System.out.println(Arrays.deepToString(positions.toArray()));
  }
}
