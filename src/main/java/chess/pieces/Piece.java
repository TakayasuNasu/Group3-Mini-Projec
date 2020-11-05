package chess.pieces;

import chess.Symbol;
import chess.command.Movement;

public abstract class Piece {

  public int position;
  public boolean isWhite = false;
  public boolean isGone = false;
  public String symbol;

}
