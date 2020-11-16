package chess.pieces;

public abstract class Piece {

  public int position;
  public boolean isWhite = false;
  public boolean isGone = false;
  public String symbol;


  public void taken(){
    this.isGone = true;
  }
}
