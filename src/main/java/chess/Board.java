package chess;

import chess.pieces.Pawn;
import chess.pieces.Piece;
import chess.pieces.Queen;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

  Queen whiteQueen = new Queen();
  Queen blackQueen = new Queen();
  Pawn whitePawn1 = new Pawn();
  Pawn blackPawn1 = new Pawn();

  List<Piece> pieces = new ArrayList<>(Arrays.asList(
      whiteQueen,
      whitePawn1,
      blackQueen,
      blackPawn1
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
