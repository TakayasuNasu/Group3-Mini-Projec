package chess.pieces;

import chess.Symbol;

public class Knight extends Piece {

  public Knight() {
    super.position = 1;
  }

  public Knight(int position, boolean isWhite) {
    super.position = position;
    super.isWhite = isWhite;
    super.symbol = super.isWhite ? Symbol.WHITE_KNIGHT : Symbol.BLACK_KNIGHT;
  }

  public Knight(int position) {
    super.position = position;
    super.symbol = super.isWhite ? Symbol.WHITE_KNIGHT : Symbol.BLACK_KNIGHT;
  }
}
