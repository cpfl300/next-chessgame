package chess;

public class GenerateConsol implements Generate {
	

	@Override
	public String generate(Board board) {
		
		return board.generateForPrint();
	}

}
