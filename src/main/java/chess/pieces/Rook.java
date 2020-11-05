package chess.pieces;

import chess.Symbol;

public class Rook extends Piece {

  public Rook() {
    super.position = 1;
  }

  public Rook(int position, boolean isWhite, boolean isGone) {
    super.position = position;
    super.isWhite = isWhite;
    super.isGone = isGone;
    super.symbol = super.isWhite ? Symbol.WHITE_ROOK : Symbol.BLACK_ROOK;
  }
}
