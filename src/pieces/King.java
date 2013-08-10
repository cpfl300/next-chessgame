package pieces;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
	public King(Color color, Position position) {
		super(color, Type.KING, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		List<Position> kingPossibleMove = new ArrayList();
		PositionController positions = new PositionController(getPosition());
		kingPossibleMove.addAll(positions.findLinearPosition(getPosition()));
		kingPossibleMove.addAll(positions.findDiagonalPosition(getPosition()));
		
		return kingPossibleMove;
	}
}
