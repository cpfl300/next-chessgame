package pieces;

public interface PieceOperations {

	public abstract Position getPosition();

	public abstract char getSymbol();

	public abstract boolean isWhite();

	public abstract PieceOperations leave();

	public abstract PieceOperations move(Position target);

	public abstract int hashCode();

	public abstract boolean equals(Object obj);

	public abstract String toString();

}