package chess.pieces;

import chess.Symbol;

public class King extends Piece {

  public King() {
    super.position = 1;
  }

  public King(int position, boolean isWhite, boolean isGone) {
    super.position = position;
    super.isWhite = isWhite;
    super.isGone = isGone;
    super.symbol = super.isWhite ? Symbol.WHITE_KING : Symbol.BLACK_KING;
  }
}
