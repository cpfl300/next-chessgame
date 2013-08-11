package chess;

import junit.framework.TestCase;
import pieces.Bishop;
import pieces.Empty;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece.Color;
import pieces.PieceOperations;
import pieces.Position;
import pieces.Rook;

public class BoardTest extends TestCase {
	private Board board;

	@Override
	protected void setUp() throws Exception {
		board = new Board();
	}

	public void testCreate() throws Exception {
		board.initialize();
		assertEquals(RankTest.WHITE_PAWN_RANK, board.generateRank(1));
		assertEquals(RankTest.BLACK_PAWN_RANK, board.generateRank(6));
	}

	public void testPrint() throws Exception {
		board.initialize();
		String expected = RankTest.BLACK_EXCEPT_PAWN_RANK + Board.NEW_LINE
				+ RankTest.BLACK_PAWN_RANK + Board.NEW_LINE + createEmptyRank()
				+ createEmptyRank() + createEmptyRank() + createEmptyRank()
				+ RankTest.WHITE_PAWN_RANK + Board.NEW_LINE
				+ RankTest.WHITE_EXCEPT_PAWN_RANK + Board.NEW_LINE;
		assertEquals(expected, board.generateBoard());
		System.out.println(board.generateBoard());
	}

	private String createEmptyRank() {
		return RankTest.EMPTY_RANK + Board.NEW_LINE;
	}

	public void testFindPiece() throws Exception {
		board.initialize();
		assertEquals('R', board.findPiece("a8").getSymbol());
		assertEquals('k', board.findPiece("e1").getSymbol());
	}

	public void testInitializeEmpty() throws Exception {
		board.initializeEmpty();
		System.out.println(board.generateBoard());
	}

	public void testMovePiece() throws Exception {
		board.initialize();
		Position source = new Position("a2");
		PieceOperations sourcePiece = board.findPiece(source);
		assertEquals(new Pawn(Color.WHITE, source), sourcePiece);

		Position target = new Position("a3");
		board.movePiece(source, target);
		assertEquals(new Empty(Color.NOCOLOR, source), board.findPiece(source));
		assertEquals(new Pawn(Color.WHITE, target), board.findPiece(target));
		System.out.println(board.generateBoard());
	}

	public void testEmptyMove() throws Exception {
		Position src = new Position("a3");
		Position target = new Position("a2");
		board.initialize();
		board.movePiece(src, target);
		assertFalse(board.findPiece(target) instanceof Empty);
	}

	public void testTargetPositionInvalid() throws Exception {
		Position src = new Position(0, 7);
		Position target = new Position(0, 8);
		board.initialize();
		try {
			board.movePiece(src, target);
			fail("유효하지 않은 위치로 말을 옮겼으므로 Exception이 발생해야 한다.");
		} catch (Exception e) {

		}
	}

	public void testSameColor() throws Exception {
		Position src = new Position("a1");
		Position target = new Position("a2");
		board.initialize();
		board.movePiece(src, target);
		assertTrue(board.findPiece(src) instanceof Rook);
		assertTrue(board.findPiece(target) instanceof Pawn);
	}
	
	public void testPossibleMove() throws Exception {
		Position knight = new Position("b1");
		Position knightTarget = new Position("c5");
		Position bishop = new Position("c1");
		Position bishopTarget = new Position("c3");
		Position king = new Position("e1");
		Position kingTarget = new Position("d3");
		
		
		board.initialize();
		board.movePiece(knight, knightTarget);
		board.movePiece(bishop, bishopTarget);
		board.movePiece(king, kingTarget);

		assertTrue(board.findPiece(knightTarget) instanceof Empty);
		assertTrue(board.findPiece(bishopTarget) instanceof Empty);
		assertTrue(board.findPiece(kingTarget) instanceof Empty);
		System.out.println(board.generateBoard());
		
	}
	
}
