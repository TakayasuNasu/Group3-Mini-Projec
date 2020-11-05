package chess.pieces;

import chess.Symbol;

public class Pawn extends Piece {

  public Pawn() {
    super.position = 2;
  }

  public Pawn(int position, boolean isWhite) {
    super.position = position;
    super.isWhite = isWhite;
    super.symbol = super.isWhite ? Symbol.WHITE_PAWN : Symbol.BLACK_PAWN;
  }

  public Pawn(int position) {
    super.position = position;
    super.symbol = super.isWhite ? Symbol.WHITE_PAWN : Symbol.BLACK_PAWN;
  }

}
