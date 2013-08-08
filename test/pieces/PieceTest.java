package pieces;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class PieceTest extends TestCase {
	public void testIsWhite() throws Exception {
		Piece whitePawn = new Pawn(Color.WHITE, null);
		assertTrue(whitePawn.isWhite());
	}

	public void testIsBlack() throws Exception {
		Piece blackPawn = new Pawn(Color.BLACK, null);
		assertTrue(blackPawn.isBlack());
	}
	
	public void testMove() throws Exception {
		Position source = new Position("a1");
		Position target = new Position("a2");
		Piece whitePawn = new Pawn(Color.WHITE, source);
		assertEquals(new Pawn(Color.WHITE, target), whitePawn.move(target));
	}
	
	public void testLeave() throws Exception {
		Position source = new Position("a1");
		Piece whitePawn = new Pawn(Color.WHITE, source);
		assertEquals(new Empty(Color.NOCOLOR, source), whitePawn.leave());
	}
	
	public void testEmptyPossibleMove() throws Exception {
		Position emptyPosition = new Position("a4");
		Piece empty = new Empty(Color.NOCOLOR, emptyPosition);
		assertEquals(0, empty.getPossibleMoves().size());
		
	}
	
	public void testRookPossibleMove() throws Exception {
		Position rookPosition = new Position("a1");
		Piece rook = new Rook(Color.WHITE, rookPosition);
		assertEquals(14, rook.getPossibleMoves().size());
		System.out.println(rook.getPossibleMoves());

	}
	
	public void testBishopPossibleMove() throws Exception {
		Position bishopPosition = new Position("c1");
		Piece bishop = new Bishop(Color.WHITE,bishopPosition);
		assertEquals(7, bishop.getPossibleMoves().size());
		System.out.println(bishop.getPossibleMoves());

	}
	
	public void testQueenPossibleMove() throws Exception {
		Position queenPosition = new Position("d1");
		Piece queen = new Queen(Color.WHITE, queenPosition);
		assertEquals(21, queen.getPossibleMoves().size());
		System.out.println(queen.getPossibleMoves());
		
	}
}

