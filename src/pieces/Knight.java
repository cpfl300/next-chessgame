package pieces;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
	public Knight(Color color, Position position) {
		super(color, Type.KNIGHT, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		PositionController positions = new PositionController(getPosition());
		List<Position> knightPossibleMove = new ArrayList();
		List<Position> linearPosition = positions.findLinearPosition(getPosition());
		
		for(int i = 0 ; i < linearPosition.size(); i++){
			knightPossibleMove.addAll(positions.findDiagonalPosition(linearPosition.get(i)));
		}		
		
		knightPossibleMove.removeAll(linearPosition);

		return knightPossibleMove;
	}
}