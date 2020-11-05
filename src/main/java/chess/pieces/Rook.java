package chess.pieces;

import chess.Symbol;

public class Rook extends Piece {

  public Rook() {
    super.position = 1;
  }

  public Rook(int position, boolean isWhite) {
    super.position = position;
    super.isWhite = isWhite;
    super.symbol = super.isWhite ? Symbol.WHITE_ROOK : Symbol.BLACK_ROOK;
  }
}
