package chess.pieces;

import chess.command.Movement;

public abstract class Piece {

  public int position;

  abstract void move(int position);

}
