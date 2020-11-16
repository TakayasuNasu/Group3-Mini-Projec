package chess;

import chess.command.Movement;
import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Queen;
import chess.pieces.Rook;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Board {

  King whiteKing = new King(85, true);
  Queen whiteQueen = new Queen(84, true);
  Bishop whiteBishop1 = new Bishop(83, true);
  Bishop whiteBishop2 = new Bishop(86, true);
  Rook whiteRook1 = new Rook(81, true);
  Rook whiteRook2 = new Rook(88, true);
  Knight whiteKnight1 = new Knight(82, true);
  Knight whiteKnight2 = new Knight(87, true);
  Pawn whitePawn1 = new Pawn(71, true);
  Pawn whitePawn2 = new Pawn(72, true);
  Pawn whitePawn3 = new Pawn(73, true);
  Pawn whitePawn4 = new Pawn(74, true);
  Pawn whitePawn5 = new Pawn(75, true);
  Pawn whitePawn6 = new Pawn(76, true);
  Pawn whitePawn7 = new Pawn(77, true);
  Pawn whitePawn8 = new Pawn(78, true);

  King blackKing = new King(15);
  Queen blackQueen = new Queen(14);
  Bishop blackBishop1 = new Bishop(13);
  Bishop blackBishop2 = new Bishop(16);
  Rook blackRook1 = new Rook(11);
  Rook blackRook2 = new Rook(18);
  Knight blackKnight1 = new Knight(12);
  Knight blackKnight2 = new Knight(17);
  Pawn blackPawn1 = new Pawn(21);
  Pawn blackPawn2 = new Pawn(22);
  Pawn blackPawn3 = new Pawn(23);
  Pawn blackPawn4 = new Pawn(24);
  Pawn blackPawn5 = new Pawn(25);
  Pawn blackPawn6 = new Pawn(26);
  Pawn blackPawn7 = new Pawn(27);
  Pawn blackPawn8 = new Pawn(28);

  List<Piece> pieces = new ArrayList<>(Arrays.asList(
      whiteKing,
      whiteQueen,
      whiteBishop1,
      whiteBishop2,
      whiteRook1,
      whiteRook2,
      whiteKnight1,
      whiteKnight2,
      whitePawn1,
      whitePawn2,
      whitePawn3,
      whitePawn4,
      whitePawn5,
      whitePawn6,
      whitePawn7,
      whitePawn8,
      blackKing,
      blackQueen,
      blackBishop1,
      blackBishop2,
      blackRook1,
      blackRook2,
      blackKnight1,
      blackKnight2,
      blackPawn1,
      blackPawn2,
      blackPawn3,
      blackPawn4,
      blackPawn5,
      blackPawn6,
      blackPawn7,
      blackPawn8
  ));

  /**
   * Get the Piece's object at the specified position.
   * <p>
   * ex) if position = 14 and there is a Queen at 14 ->  return (Piece) queen object if there is no
   * piece -> return null
   *
   * @param position is the location where the user selected. It is id on the Board {11...88}
   * @return each piece object (ex, Queen, Rook...) as Piece class. If there is no piece at the
   * position, return null.
   */
  public Piece chosen(int position) {
    List<Piece> list = this.pieces.stream()
        .filter(piece -> piece.position == position && !piece.isGone)
        .collect(Collectors.toList());
    if (list.size() < 1) {
      return null;
    }
    return list.get(0);
  }

  public List<Piece> movablePieces() {
    return this.pieces.stream()
        .filter(piece -> {
          Movement movement = new MovementFactory().create(piece, this);
          return movement.where().size() > 0;
        }).collect(Collectors.toList());
  }

  public King getKing(boolean isWhite) {
    if (isWhite) {
      return this.whiteKing;
    } else {
      return this.blackKing;
    }
  }

  public boolean observePawn() {
    for (Piece p : this.pieces) {
      if (p.getClass().getSimpleName().equals("Pawn")) {
        if (Lists.newArrayList(11, 12, 13, 14, 39, 40, 49, 50, 59, 60, 69, 70, 79, 80)
            .contains(p.position)) {
          return true;
        }
      }
    }
    return false;
  }

  public void overRidePiece(Piece piece) {
    for (int i = 0; i < this.pieces.size(); i++) {
      if (this.pieces.get(i).position == piece.position
          && !this.pieces.get(i).isGone) {
        this.pieces.set(i, piece);
      }
    }
  }

  public Piece pawnPromotion(Piece pawn, String piece) {
    switch (piece) {
      case "Queen":
        pawn = new Queen(pawn.position, pawn.isWhite);
        Console.promoted("Queen");
        break;
      case "Rook":
        pawn = new Rook(pawn.position, pawn.isWhite);
        Console.promoted("Rook");
        break;
      case "Knight":
        pawn = new Knight(pawn.position, pawn.isWhite);
        Console.promoted("Knight");
        break;
      case "Bishop":
        pawn = new Bishop(pawn.position, pawn.isWhite);
        Console.promoted("Bishop");
        break;
    }
    return pawn;

    //      Scanner scan = new Scanner(System.in);
//      piece = scan.nextLine();
//    if (!pawn.getClass().getSimpleName().equals("Pawn")) {
//      return pawn;
//    }
//    if (pawn.position <= 18 || pawn.position >= 81) {
//        if(piece.equals("Queen")){
//          System.out.println("You have promoted to Queen");
//          pawn = new Queen(pawn.position, pawn.isWhite);
//        }
//      if(piece.equals("Rook")){
//        pawn = new Rook(pawn.position, pawn.isWhite);
//        System.out.println("You have promoted to Rook");
//      }
//      if(piece.equals("Bishop")){
//        pawn = new Bishop(pawn.position, pawn.isWhite);
//        System.out.println("You have promoted to Bishop");
//      }
//      if(piece.equals("Knight")){
//        System.out.println("You have promoted to Knight");
//        pawn = new Knight(pawn.position, pawn.isWhite);
//
//      }
  }


}

