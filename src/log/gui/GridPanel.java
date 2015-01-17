package log.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import log.com.Constants;

public class GridPanel extends JPanel
{
	private static final long serialVersionUID = 2301936708413070062L;
	JButton[][] lightButtons;
	GridLayout gridLayout = new GridLayout(Constants.gridX, Constants.gridY);

	public GridPanel() {
		lightButtons = new JButton[Constants.gridX][Constants.gridY];
		this.setLayout(gridLayout);
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		for (int i = 0; i < Constants.gridX; i++) {
			for (int c = 0; c < Constants.gridX; c++) {
				lightButtons[i][c] = new JButton();
				lightButtons[i][c].setMargin(new Insets(8, 8, 8, 8));
				Dimension defaultSize = new Dimension(32 + 2 * lightButtons[i][c].getInsets().top, 32 + 2 * lightButtons[i][c].getInsets().top);
				lightButtons[i][c].setPreferredSize(defaultSize);
				lightButtons[i][c].setMaximumSize(defaultSize);
				lightButtons[i][c].setMinimumSize(defaultSize);
				lightButtons[i][c].setBorder(null);
				lightButtons[i][c].setBackground(Color.LIGHT_GRAY);
				this.add(Constants.gridPanelStr[0] + i + Constants.gridPanelStr[1] + c + Constants.gridPanelStr[2], lightButtons[i][c]);
			}
		}
	}
}
