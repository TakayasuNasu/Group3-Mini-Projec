package chess.pieces;

import chess.Symbol;

public class Knight extends Piece {

  public Knight() {
    super.position = 1;
  }

  public Knight(int position, boolean isWhite, boolean isGone) {
    super.position = position;
    super.isWhite = isWhite;
    super.isGone = isGone;
    super.symbol = super.isWhite ? Symbol.WHITE_KNIGHT : Symbol.BLACK_KNIGHT;
  }
}
