package chess.pieces;

import chess.Symbol;

public class Queen extends Piece {

  public Queen() {
    super.position = 1;
  }

  public Queen(int position, boolean isWhite) {
    super.position = position;
    super.isWhite = isWhite;
    super.symbol = super.isWhite ? Symbol.WHITE_QUEEN : Symbol.BLACK_QUEEN;
  }

  public Queen(int position) {
    super.position = position;
    super.symbol = super.isWhite ? Symbol.WHITE_QUEEN : Symbol.BLACK_QUEEN;
  }

}
