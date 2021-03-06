package pieces;

import pieces.Piece.Color;
import junit.framework.TestCase;

public class PieceTest extends TestCase {
	public void testIsWhite() throws Exception {
		PieceOperations whitePawn = new Pawn(Color.WHITE, null);
		assertTrue(whitePawn.isWhite());
	}

	public void testIsBlack() throws Exception {
		Piece blackPawn = new Pawn(Color.BLACK, null);
		assertTrue(blackPawn.isBlack());
	}
	
	public void testMove() throws Exception {
		Position source = new Position("a1");
		Position target = new Position("a2");
		PieceOperations whitePawn = new Pawn(Color.WHITE, source);
		assertEquals(new Pawn(Color.WHITE, target), whitePawn.move(target));
	}
	
	public void testLeave() throws Exception {
		Position source = new Position("a1");
		PieceOperations whitePawn = new Pawn(Color.WHITE, source);
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
	
	public void testKingPossibleMove() throws Exception {
		Position kingPosition = new Position("e1");
		Piece king = new King(Color.WHITE, kingPosition);
		assertEquals(5, king.getPossibleMoves().size());
		System.out.println(king.getPossibleMoves());
	}
	
	public void testPawnPossibleMove() throws Exception {
		Position whitePawnPosition = new Position("a2");
		Piece whitePawn = new Pawn(Color.WHITE, whitePawnPosition);
		assertEquals(2, whitePawn.getPossibleMoves().size());
		System.out.println(whitePawn.getPossibleMoves());

		Position blackPawnPosition = new Position("a7");
		Piece blackPawn = new Pawn(Color.BLACK, blackPawnPosition);
		assertEquals(2, blackPawn.getPossibleMoves().size());
		System.out.println(blackPawn.getPossibleMoves());
	}
	
	public void testKnighttest() throws Exception {
		Position knightPosition = new Position("b1");
		Piece knight = new Knight(Color.WHITE, knightPosition);
		assertEquals(3, knight.getPossibleMoves().size());
		System.out.println(knight.getPossibleMoves());
		
	}
}

