package pieces;

import java.util.ArrayList;
import java.util.List;


public class Pawn extends Piece {
	public Pawn(Color color, Position position) {
		super(color, Type.PAWN, position);
	}

	@Override
	List<Position> getPossibleMoves() {
		List<Position> pawnPossibleMove = new ArrayList();
		if(isWhite()){
			pawnPossibleMove.add(getPosition().move(Direction.NORTH));
		}
		else{
			pawnPossibleMove.add(getPosition().move(Direction.SOUTH));
		}
		
		return pawnPossibleMove;
	}
}
