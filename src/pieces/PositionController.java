package pieces;

import java.util.ArrayList;
import java.util.List;

public class PositionController {
	private Position position;;

	public PositionController(Position position) {
		this.position = position;
	}

	public List<Position> findsLinearPositionAll() {
		Direction[] linears = Direction.linearDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : linears) {
			positions.addAll(position.findsPosition(direction));
		}
		return positions;
	}

	public List<Position> findsDiagonalPositionAll() {
		Direction[] diagonals = Direction.diagonalDirection();
		List<Position> positions = new ArrayList<Position>();
		for (Direction direction : diagonals) {
			positions.addAll(position.findsPosition(direction));
		}
		return positions;
	}
	
	List<Position> findLinearPosition(Position position) {
		ArrayList<Position> positions = new ArrayList<Position>();
		Direction[] linears = Direction.linearDirection();
		for (Direction directions : linears) {
			Position currentPosition = position.move(directions);
			if(currentPosition.isValid()){
				positions.add(currentPosition);
			}
		}
		return positions;
	}
	
	List<Position> findDiagonalPosition(Position position) {
		ArrayList<Position> positions = new ArrayList<Position>();
		Direction[] diagonals = Direction.diagonalDirection();
		for (Direction directions : diagonals) {
			Position currentPosition = position.move(directions);
			if(currentPosition.isValid()){
				positions.add(currentPosition);
			}
		}
		return positions;
	}
}
