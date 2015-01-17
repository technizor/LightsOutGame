package log.com;

public class GridController
{
	private MoveLogic board;

	public GridController(int type) {
		board = new MoveLogic(type);
	}

	public boolean checkWin()
	{
		return board.checkWin();
	}

	public boolean[][] getGrid()
	{
		return board.getGrid();
	}

	public int getMinMoves()
	{
		return board.getMinMoves();
	}
	
	public int[][] getMinGrid()
	{
		return board.getMinGrid();
		
	}
	
	public int getHintsLeft()
	{
		return board.getHintsLeft();
	}
	
	public void useHint()
	{
		board.useHint();
	}
	
	public void move(int x, int y)
	{
		board.move(x, y);
	}
}
