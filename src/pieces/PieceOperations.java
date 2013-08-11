package pieces;

public interface PieceOperations {
	public Position getPosition();

	public char getSymbol();

	public boolean isWhite();

	public Piece leave();

	public Piece move(Position target);
}
