package chess.pieces;

import chess.Symbol;

public class Bishop extends Piece {

  public Bishop() {
    super.position = 1;
  }

  public Bishop(int position, boolean isWhite) {
    super.position = position;
    super.isWhite = isWhite;
    super.symbol = super.isWhite ? Symbol.WHITE_BISHOP : Symbol.BLACK_BISHOP;
  }

  public Bishop(int position) {
    super.position = position;
    super.symbol = super.isWhite ? Symbol.WHITE_BISHOP : Symbol.BLACK_BISHOP;
  }
}
