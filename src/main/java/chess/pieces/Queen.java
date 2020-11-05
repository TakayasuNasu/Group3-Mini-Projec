package chess.pieces;

import chess.Symbol;
import sun.jvm.hotspot.debugger.cdbg.Sym;

public class Queen extends Piece {

  public Queen() {
    super.position = 1;
  }

  public Queen(int position, boolean isWhite, boolean isGone) {
    super.position = position;
    super.isWhite = isWhite;
    super.isGone = isGone;
    super.symbol = super.isWhite ? Symbol.WHITE_QUEEN : Symbol.BLACK_QUEEN;
  }

}
