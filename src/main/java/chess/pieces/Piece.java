package chess.pieces;

import chess.command.Movement;

public abstract class Piece {

  public int position;
  public Movement movement;

  abstract void move(int position);

}
