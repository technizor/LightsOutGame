package log.gui;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import org.jetstorm.stormFrame.StormConstraints;
import org.jetstorm.stormFrame.StormFrame;

import log.com.GridController;
import log.com.Constants;

public class MainWindow extends StormFrame implements ActionListener, Runnable, MouseListener
{
	private static final long serialVersionUID = 5716317891219903801L;
	private AppInterface panel;
	private int moveCount = 0;
	private Color defaultButtonColor;
	private GridController controller;
	@SuppressWarnings("unused")
	private CompletedBoardDialog messageBox;
	private boolean won = false;
	private int[][] moveGridCounter = new int[Constants.gridX][Constants.gridY];

	public MainWindow() {
		super(Constants.title, false, false);
		panel.minMoves.setText(Constants.minMovesText + controller.getMinMoves());
		panel.hint.setText(Constants.hintText + controller.getHintsLeft());
		for(int i = 0; i < Constants.gridX; i++) {
			for(int c = 0; c < Constants.gridX; c++) {
				moveGridCounter[i][c] = 0;
			}
		}
		defaultButtonColor = panel.hint.getBackground();
		repaintButtons();
	}
	
	private void repaintButtons()
	{
		boolean[][] gridData = controller.getGrid();
		for (int i = 0; i < 5; i++) {
			for (int c = 0; c < 5; c++) {
				if (gridData[i][c] == false) {
					panel.gridPane.lightButtons[i][c].setIcon(panel.offNorm);
				} else {
					panel.gridPane.lightButtons[i][c].setIcon(panel.onNorm);
				}
			}
		}
	}

	@Override
	public void actionHandler(Object source)
	{
		boolean gridButtonAction = false;
		int x = 0;
		int y = 0;
		OUTER: for (int i = 0; i < Constants.gridX; i++) {
			for (int c = 0; c < Constants.gridY; c++) {
				if (source.equals(panel.gridPane.lightButtons[i][c])) {
					gridButtonAction = true;
					x = i;
					y = c;
					break OUTER;
				}
			}
		}
		if (gridButtonAction != true) {
			if (source == panel.allOn || source == panel.randomLights) {
				controller = new GridController((source == panel.allOn) ? 0 : 1);
				moveCount = 0;
				panel.minMoves.setText(Constants.minMovesText
						+ controller.getMinMoves());
				panel.moveCounter.setText(Constants.moveCounterText + 0);
				for(int i = 0; i < Constants.gridX; i++) {
					for(int c = 0; c < Constants.gridY; c++) {
						panel.gridPane.lightButtons[i][c].setEnabled(true);
						panel.gridPane.lightButtons[i][c].setBackground(defaultButtonColor);
						moveGridCounter[i][c] = 0;
					}
				}
				panel.hint.setText(Constants.hintText + controller.getHintsLeft());
				panel.hint.setEnabled(true);
				repaintButtons();
				won = false;
			} else if (source == panel.hint) {
				int hintsLeft = controller.getHintsLeft();
				if(hintsLeft != 0) {
					ArrayList<int[]> possibleHints = new ArrayList<int[]>();
					int[][] minMovesGrid = controller.getMinGrid();
					for(int i = 0; i < Constants.gridX; i++) {
						for(int c = 0; c < Constants.gridY; c++) {
							if((moveGridCounter[i][c] - minMovesGrid[i][c]) % 2 != 0) {
								int[] co_ords = {i, c};
								possibleHints.add(co_ords);
							}
						}
					}
					int hinted = (int) (Math.random() * (possibleHints.size()-1));
					int[] hintLoc = possibleHints.get(hinted);
					controller.move(hintLoc[0], hintLoc[1]);
					moveGridCounter[hintLoc[0]][hintLoc[1]]++;
					panel.gridPane.lightButtons[hintLoc[0]][hintLoc[1]].setBackground(Color.BLACK);
					controller.useHint();
					panel.hint.setText(Constants.hintText + controller.getHintsLeft());
					if(controller.getHintsLeft() == 0) {
						panel.hint.setEnabled(false);
					}
					repaintButtons();
				}
			}
		} else {
			controller.move(x, y);
			moveGridCounter[x][y]++;
			repaintButtons();
			if (!won)
				moveCount++;
			panel.moveCounter.setText(Constants.moveCounterText + moveCount);
			if (controller.checkWin() && !won) {
				panel.hint.setEnabled(false);
				messageBox = new CompletedBoardDialog(controller.getMinMoves(), moveCount, 3-controller.getHintsLeft());
				for(int i = 0; i < Constants.gridX; i++) {
					for(int c = 0; c < Constants.gridY; c++) {
						panel.gridPane.lightButtons[i][c].setEnabled(true);
					}
				}
				won = true;
			}
		}
	}

	@Override
	public void addActionListeners()
	{
		for (int i = 0; i < 5; i++) {
			for (int c = 0; c < 5; c++) {
				panel.gridPane.lightButtons[i][c].addActionListener(this);
			}
		}
		panel.allOn.addActionListener(this);
		panel.hint.addActionListener(this);
		panel.randomLights.addActionListener(this);
	}

	@Override
	public void buildDefaultElements()
	{
		buildElement(panel, new StormConstraints(1,1,0,0,0,0,0,0));
	}

	@Override
	public void configureElements()
	{
		panel = new AppInterface();
		controller = new GridController(0);
	}

	@Override
	public void run()
	{
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
}
