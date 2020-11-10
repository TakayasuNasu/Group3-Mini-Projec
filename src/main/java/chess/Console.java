package chess;

import chess.pieces.Piece;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;

public class Console {

  static void help(){
    System.out.println("* type 'help' for help");
    System.out.println("* type 'board' to see the board again");
    System.out.println("* type 'resign' to resign");
    System.out.println("* type 'moves' to list all possible moves");
    System.out.println("* type 'square' (e.g. 21, 35, 44) to list possible moves for that square");
    System.out.println("type 'UCI' (e.g. 33, 27,70) to make a move");
  }

  static void resign(Player player) {
    if (player.isWhite) {
      System.out.println("Game over Black won by resignation");
    } else {
      System.out.println("Game over White won by resignation");
    }
  }

  static void won(Player player) {
    if (player.isWhite) {
      System.out.println("");
    }
  }

  static void changePlayer(Player player) {
    if (player.isWhite) {
      System.out.println("White's turn finished. next turn is Black.");
    } else {
      System.out.println("Black's turn finished. next turn is White.");
    }
  }

  static void cellNumber() {
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

  static void showBoard(Board bord) {
    StringBuilder sb = new StringBuilder("-------------------------\n");
    for (int i = 11; i < 89; i++) {
      if (Lists.newArrayList(19, 20, 29, 30, 39, 40, 49, 50, 59, 60, 69, 70, 79, 80).contains(i)) {
        continue;
      }
      sb.append("|");
      Piece p = bord.chosen(i);
      if (p != null) {
        sb.append(p.isGone ? Symbol.EMPTY : p.symbol);
      } else {
        sb.append(Symbol.EMPTY);
      }
      if (Lists.newArrayList(18, 28, 38, 48, 58, 68, 78, 88).contains(i)) {
        sb.append("|\n");
      }
    }
    sb.append("-------------------------\n");
    System.out.println(sb.toString());
  }

  static void beforeCall() {
    System.out.print("Enter UCI (type 'help' for help): ");
  }

  static void positions(ArrayList<Integer> positions) {
    System.out.println("You can choose destination from " + Arrays.deepToString(positions.toArray()));
  }

  static void pieceAndPosition(Piece piece, int position) {
    System.out.printf("you chose %s and position is %d\n", piece.symbol, position);
  }

  static void pieceMoved(Piece piece, int position) {
    System.out.printf("you moved %s and destination is %d\n", piece.symbol, position);
  }

  static void error(int code) {
    switch (code) {
      case 1:
        System.err.println("Invalid chosen piece!");
        break;
      case 2:
        System.err.println("Invalid decided piece!");
        break;
      default:
        System.err.println("");
    }
  }

}
