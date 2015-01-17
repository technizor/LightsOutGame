package log.com;

public class MoveLogic
{
	private final boolean outputSolution = false;
	private final boolean[][] lightChaserAlgorithm = {
			// Bottom Light Layout
			{ true, false, false, false, true },
			{ false, true, false, true, false },
			{ true, true, true, false, false },
			{ false, false, true, true, true },
			{ true, false, true, true, false },
			{ false, true, true, false, true },
			{ true, true, false, true, true },
			// Top Lights to trigger
			{ true, true, false, false, false },
			{ true, false, false, true, false },
			{ false, true, false, false, false },
			{ false, false, false, true, false },
			{ false, false, false, false, true },
			{ true, false, false, false, false },
			{ false, false, true, false, false }
	/*
	 * Bottom row Top row OxxxO OOxxx xOxOx OxxOx OOOxx xOxxx xxOOO xxxOx OxOOx
	 * xxxxO xOOxO Oxxxx OOxOO xxOxx
	 */
	};
	private int[][] minMovesGrid = new int[Constants.gridX][Constants.gridY];
	private boolean[][] lightGrid = new boolean[Constants.gridX][Constants.gridY];
	private int hintsLeft = 3;
	private int minMoves = 0;

	public MoveLogic(int type) {
		for (int i = 0; i < Constants.gridX; i++) {
			for (int c = 0; c < Constants.gridY; c++) {
				lightGrid[i][c] = true;
			}
		}
		if (type == 1) {
			int num = (int) (Math.random() * 40 + 10);
			for (int i = 0; i < num; i++) {
				int x = (int) (Math.random() * Constants.gridX-1);
				int y = (int) (Math.random() * Constants.gridY-1);
				move(x, y);
			}
		}
		findMinMoves();
	}

	boolean checkWin()
	{
		for (int i = 0; i < Constants.gridX; i++) {
			for (int c = 0; c < Constants.gridY; c++) {
				if (lightGrid[i][c] == true)
					return false;
			}
		}
		return true;
	}

	private void findMinMoves()
	{
		boolean[][] tempGrid = new boolean[Constants.gridX][Constants.gridY];
		int[][] countGrid = new int[Constants.gridX][Constants.gridY];
		int moveCounter = 0;
		boolean unfinished = true;
		for (int i = 0; i < Constants.gridX; i++) {
			for (int c = 0; c < Constants.gridY; c++) {
				tempGrid[i][c] = lightGrid[i][c];
				countGrid[i][c] = 0;
			}
		}
		while (unfinished) {
			boolean[] bottomLine = new boolean[Constants.gridY];
			for (int i = 1; i < Constants.gridX; i++) {
				for (int c = 0; c < Constants.gridY; c++) {
					if (tempGrid[i - 1][c]) {
						tempGrid[i][c] = !tempGrid[i][c];
						if (i != 0)
							tempGrid[i - 1][c] = !tempGrid[i - 1][c];
						if (i != Constants.gridX-1)
							tempGrid[i + 1][c] = !tempGrid[i + 1][c];
						if (c != 0)
							tempGrid[i][c - 1] = !tempGrid[i][c - 1];
						if (c != Constants.gridY-1)
							tempGrid[i][c + 1] = !tempGrid[i][c + 1];
						countGrid[i][c]++;
					}
				}
			}
			for (int i = 0; i < Constants.gridY; i++) {
				bottomLine[i] = tempGrid[Constants.gridX-1][i];
			}
			for (int i = 0; i < 7; i++) {
				boolean equalBottom = true;
				for (int c = 0; c < 5; c++) {
					if (bottomLine[c] != lightChaserAlgorithm[i][c])
						equalBottom = false;
				}
				if (equalBottom) {
					for (int c = 0; c < Constants.gridY; c++) {
						if (lightChaserAlgorithm[i + 7][c]) {
							tempGrid[0][c] = !tempGrid[0][c];
							if (c != 0)
								tempGrid[0][c - 1] = !tempGrid[0][c - 1];
							if (c != 4)
								tempGrid[0][c + 1] = !tempGrid[0][c + 1];
							tempGrid[1][c] = !tempGrid[1][c];
							countGrid[0][c]++;
						}
					}
					break;
				}
			}
			unfinished = false;
			for (int i = 0; i < Constants.gridX; i++) {
				for (int c = 0; c < Constants.gridY; c++) {
					if (tempGrid[i][c])
						unfinished = true;
				}
			}
		}
		for (int i = 0; i < Constants.gridX; i++) {
			for (int c = 0; c < Constants.gridY; c++) {
				moveCounter += countGrid[i][c] % 2;
			}
		}
		minMoves = moveCounter;
		for (int i = 0; i < Constants.gridX; i++) {
			for (int c = 0; c < Constants.gridY; c++) {
				minMovesGrid[i][c] = countGrid[i][c] % 2;
				if (outputSolution) System.out.print(countGrid[i][c] % 2);
			}
			if (outputSolution) System.out.println();
		}
	}

	boolean[][] getGrid()
	{
		return lightGrid;
	}
	int[][] getMinGrid()
	{
		return minMovesGrid;
	}
	int getHintsLeft()
	{
		return hintsLeft;
	}
	int getMinMoves()
	{
		return minMoves;
	}
	void useHint()
	{
		hintsLeft--;
	}

	public void move(int x, int y)
	{
		lightGrid[x][y] = !lightGrid[x][y];
		if (x != 0)
			lightGrid[x - 1][y] = !lightGrid[x - 1][y];
		if (x != Constants.gridX-1)
			lightGrid[x + 1][y] = !lightGrid[x + 1][y];
		if (y != 0)
			lightGrid[x][y - 1] = !lightGrid[x][y - 1];
		if (y != Constants.gridY-1)
			lightGrid[x][y + 1] = !lightGrid[x][y + 1];
	}
}
