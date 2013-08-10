package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Bishop;
import pieces.Empty;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Position;
import pieces.Queen;
import pieces.Rook;

public class Board {
	public static final String NEW_LINE = System.getProperty("line.separator");
	public static final int ROW_SIZE = 8;
	public static final int COLUMN_SIZE = 8;

	List<Rank> ranks = new ArrayList<Rank>();

	Board() {
	}

	void initialize() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			if (i == 0) {
				rank.initializeWhiteExceptPawn();
			} else if (i == 1) {
				rank.initializeWhitePawn();
			} else if (i == 6) {
				rank.initializeBlackPawn();
			} else if (i == 7) {
				rank.initializeBlackExceptPawn();
			} else {
				rank.initializeEmpty();
			}
			ranks.add(rank);
		}
	}

	void initializeEmpty() {
		for (int i = 0; i < ROW_SIZE; i++) {
			Rank rank = new Rank(i);
			rank.initializeEmpty();
			ranks.add(rank);
		}
	}

	Piece findPiece(String xy) {
		Position position = new Position(xy);
		return findPiece(position);
	}

	Piece findPiece(Position position) {
		Rank rank = ranks.get(position.getY());
		return rank.findPiece(position);
	}

	void movePiece(String source, String target) {
		movePiece(new Position(source), new Position(target));
	}

	void movePiece(Position source, Position target) {

		Piece targetPiece = findPiece(source);

		if (targetPiece instanceof Empty) {
			System.out.println("말이 없어서 움직일 수 없습니다.");
			return;
		}
		if(!target.isValid()){
			throw new ArrayIndexOutOfBoundsException();
		}

		Piece sourcePiece = targetPiece.leave();

		if(targetPiece.isWhite() == findPiece(target).isWhite()){
			System.out.println("같은 편의 말은 잡을 수 없습니다.");
			return;
		}
		// Piece를 이동가능한 위치가 아닌 곳으로 이동시키려고 하는 경우 이동시키지 않는다.
		if(targetPiece instanceof Pawn){
			Pawn pawn = (Pawn) targetPiece;
			if(!pawn.getPossibleMoves().contains(target)){
				return;
			}
		}
		if(targetPiece instanceof Bishop){
			Bishop bishop = (Bishop) targetPiece;
			if(!bishop.getPossibleMoves().contains(target)){
				return;
			}
		}
		if(targetPiece instanceof King){
			King king = (King) targetPiece;
			if(!king.getPossibleMoves().contains(target)){
				return;
			}
		}
		if(targetPiece instanceof Knight){
			Knight knight = (Knight) targetPiece;
			if(!knight.getPossibleMoves().contains(target)){
				return;
			}
		}
		if(targetPiece instanceof Queen){
			Queen queen = (Queen) targetPiece;
			if(!queen.getPossibleMoves().contains(target)){
				return;
			}
		}
		if(targetPiece instanceof Rook){
			Rook rook = (Rook) targetPiece;
			if(!rook.getPossibleMoves().contains(target)){
				return;
			}
		}
		
		Rank sourceRank = ranks.get(source.getY());
		sourceRank.move(sourcePiece, source); // 원래 있던 자리를 empty로 비웁니다.

		Rank targetRank = ranks.get(target.getY());
		targetRank.move(targetPiece, target); // sourcePiece를 target위치로 옮깁니다.


	}

	String generateRank(int rankIndex) {
		Rank rank = ranks.get(rankIndex);
		StringBuilder sb = new StringBuilder();
		sb.append(rank.generate());
		return sb.toString();
	}

	String generateBoard() {
		StringBuilder sb = new StringBuilder();
		for (int i = ROW_SIZE; i > 0; i--) {
			sb.append(generateRank(i - 1) + NEW_LINE);
		}
		return sb.toString();
	}
}
