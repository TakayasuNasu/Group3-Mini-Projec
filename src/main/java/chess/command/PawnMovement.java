package chess.command;

import chess.Board;
import chess.Validation;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import java.util.ArrayList;

public class PawnMovement implements Movement {

  //Instance variables
  int dest;  // The destination (position where the player is going to move the piece)
  Piece piece; // The piece objet the player is going to move
  Board board; // The board we are using now
  Validation valid = new Validation();// Create a validation object so that we can use validation method "canMove"


  //Constructor
  public PawnMovement(Piece piece, Board board) {
    this.piece = piece;
    this.board = board;
  }

  public PawnMovement(int dest, Piece piece, Board board) {
    this(piece, board);
    this.setDestination(dest);
  }

  /**
   * Move the piece to where the player has decided.
   */
  @Override
  public void run() {
    this.piece.position = this.dest;
  }


  /**
   * Calculate and store list of positions that where the piece can go. Positions are stored as
   * ArrayList like {12,23,45}
   *
   * @return the ArrayList.
   */
  @Override
  public ArrayList<Integer> where() {
    /**
     * {@code positions} is list of position, that the chosen piece can move.
     * {@code disList} is list of distances from the chosen piece.
     *  ex) {1,2,3} indicates {1+curPos,2+curPos,3+curPos}
     */
    ArrayList<Integer> positions = new ArrayList<>();
    ArrayList<Integer> disList = new ArrayList<>();

    int curPos = this.piece.position;

    /**
     * Create and Decide where to search
     * There four position Pawn can move as follows.
     *
     *    4
     *  2 1 3
     *    P
     *
     * pos1 is basic move.
     * pos2,3 is special movement that can go only the opponent piece exits there.
     * pos4 is special movement that can go only from the initial position.
     *
     * pos1 is -10 distance to previous position,
     * pos4 is -20,
     * pos2 is -9,
     * pos3 is -11.
     *
     * When the color is black, those distance be flips(be positive)
     * Because White moves ↑, Black moves ↓.
     *
     * Each pos1...pos3 are stored as list and checked if the piece can move,
     * by {@code checkFront} method.
     * pos4 are checked, in addition to pos1 condition.
     *
     */
    int dir = piece.isWhite ? 1 : -1;
    disList.add(-11*dir);
    disList.add(-9*dir);
    disList.add(-10*dir);

    for (int dis: disList) {
      positions = checkFront(positions, curPos, dis);
    }

    return positions;
  }


  /**
   * Check the 4 positions where Pawn can move.
   *
   *    2
   *  3 1 4
   *    P
   *
   * @param positions is the list where the piece can move
   * @param pos is the position of piece(Pawn) you want to check
   * @param dis is the distance from pos
   * @return positions
   */
  public ArrayList<Integer> checkFront(ArrayList<Integer> positions, int pos, int dis){
    this.valid.setDidEncounter(false);
    dest = pos + dis; // create the destination you want to check.

    // check pos1
    if (Math.abs(dis) == 10){
      // if there exists a piece, you can go there
      if (board.chosen(dest)!=null){
        return positions;
      }else{
        // if no piece and the pos is first position, check pos4
        // But if there exists any piece (including opponent piece),
        // you can't go there.
        Pawn p = (Pawn) this.piece;
        if (p.getDefaultPosition() == p.position &&
            board.chosen(dest + dis) == null &&
            valid.canMove(dest + dis)){
          positions.add(dest + dis);
        }
      }
    }

    //Check pos2,3
    if (Math.abs(dis) == 9 || Math.abs(dis) == 11){
      if (board.chosen(dest)==null){ return positions;}
    }

    //If there are no piece, then check by board area.
    if (this.valid.canMove(piece, board, dest)){
      positions.add(dest);
    };
    return positions;
  }

  @Override
  public void setDestination(int dest) {
    this.dest = dest;
  }
}
