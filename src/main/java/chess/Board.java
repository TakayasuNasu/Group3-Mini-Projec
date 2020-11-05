package chess;

import chess.pieces.Bishop;
import chess.pieces.King;
import chess.pieces.Knight;
import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Queen;
import chess.pieces.Rook;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

  King whiteKing = new King(84, true);
  Queen whiteQueen = new Queen(85, true);
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

  public Piece choosed(int position) throws Exception {
    List<Piece> list = this.pieces.stream()
        .filter(piece -> piece.position == position)
        .collect(Collectors.toList());
    if (list.size() < 1) {
      throw new Exception("Exception message");
    }
    return list.get(0);
  }

}
