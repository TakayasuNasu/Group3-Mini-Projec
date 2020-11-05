package chess.pieces;

import chess.Symbol;

public class King extends Piece {

  public King() {
    super.position = 1;
  }

  public King(int position, boolean isWhite) {
    super.position = position;
    super.isWhite = isWhite;
    super.symbol = super.isWhite ? Symbol.WHITE_KING : Symbol.BLACK_KING;
  }

  public King(int position) {
    super.position = position;
    super.symbol = super.isWhite ? Symbol.WHITE_KING : Symbol.BLACK_KING;
  }
}
