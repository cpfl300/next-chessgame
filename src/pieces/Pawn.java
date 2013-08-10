package pieces;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
	public Pawn(Color color, Position position) {
		super(color, Type.PAWN, position);
	}

	@Override
	public List<Position> getPossibleMoves() {
		List<Position> pawnPossibleMove = new ArrayList();
		if (isWhite()) {
			pawnPossibleMove.add(getPosition().move(Direction.NORTH));			
			if (getPosition().getY() == 1) {
				pawnPossibleMove.add(pawnPossibleMove.get(0).move(Direction.NORTH));
			}
		} else {
			pawnPossibleMove.add(getPosition().move(Direction.SOUTH));
			if (getPosition().getY() == 6) {
				pawnPossibleMove.add(pawnPossibleMove.get(0).move(Direction.SOUTH));
			}
		}

		return pawnPossibleMove;
	}
}
