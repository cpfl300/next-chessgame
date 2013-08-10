package pieces;

import java.util.ArrayList;
import java.util.List;


public class Queen extends Piece {
	public Queen(Color color, Position position) {
		super(color, Type.QUEEN, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		List<Position> queenPossibleMove = new ArrayList();
		PositionController positions = new PositionController(getPosition());
		queenPossibleMove.addAll(positions.findsLinearPositionAll());
		queenPossibleMove.addAll(positions.findsDiagonalPositionAll());
		return queenPossibleMove;
	}
}
