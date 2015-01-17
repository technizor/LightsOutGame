package log.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import log.com.Constants;

/**
 * AppInterface Class extends JPanel This class contains all visual components
 * of the GUI of this application. The DayCounterApp class handles all events
 * caused by the components within this JPanel.
 * 
 * @author Sherman Ying <idiotioc@gmail.com>
 * @version 1.6
 * @since 2011.0715
 **/

public class AppInterface extends JPanel
{
	private final static long serialVersionUID = 1L;
	private GridBagLayout gridbag = new GridBagLayout();
	ImageIcon offNorm;
	ImageIcon onNorm;
	// ImageIcon offOver = new ImageIcon("icon/greyLight32xMouse.png");
	// ImageIcon onOver = new ImageIcon("icon/greenLight32xMouse.png");
	// ImageIcon offPress = new ImageIcon("icon/greyLight32xPress.png");
	// ImageIcon onPress = new ImageIcon("icon/greenLight32xPress.png");
	JButton allOn;
	JButton randomLights;
	JButton hint;
	JLabel moveCounter;
	JLabel minMoves;
	GridPanel gridPane;

	public AppInterface() {
		gridPane = new GridPanel();
		allOn = new JButton(Constants.allOnText);
		hint = new JButton(Constants.hintText + 0);
		randomLights = new JButton(Constants.randomLightsText);
		moveCounter = new JLabel(Constants.moveCounterText + 0);
		minMoves = new JLabel(Constants.minMovesText + 0);
		java.net.URL imageURL = AppInterface.class
				.getResource(Constants.offLightPngLoc);
		if (imageURL != null) {
			offNorm = new ImageIcon(imageURL);
		} else 
			System.out.println("No image!");
		java.net.URL imageURL2 = AppInterface.class
				.getResource(Constants.onLightPngLoc);
		if (imageURL2 != null) {
			onNorm = new ImageIcon(imageURL2);
		} else
			System.out.println("No image!");
		this.setLayout(gridbag);
		this.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
		buildElements();
	}

	/**
	 * This method is the builder method that creates the components.
	 * 
	 * @param obj
	 *            - represents the component that it is setting up
	 * @param gx
	 *            - Grid Position X
	 * @param gy
	 *            - Grid Position Y
	 * @param gw
	 *            - Grid spaces taken X
	 * @param gh
	 *            - Grid spaces taken Y
	 * @param wx
	 *            - Grid weight X
	 * @param wy
	 *            - Grid weight Y
	 * @param fill
	 *            - 0: Both - 1: None - 2: Horizontal - 3: Vertical
	 * @param alignment
	 *            - 0: Center - 1: North - 2: NE - 3: East - 4: SE - 5: South -
	 *            6: SW - 7: West - 8: NW
	 **/
	private void buildElement(final JComponent obj, final int gx, final int gy,
			final int gw, final int gh, final int wx, final int wy,
			final int fill, final int alignment)
	{
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gx;
		gbc.gridy = gy;
		gbc.gridwidth = gw;
		gbc.gridheight = gh;
		gbc.weightx = wx;
		gbc.weightx = wy;
		switch (fill) {
		case 0:
			gbc.fill = GridBagConstraints.BOTH;
			break;
		case 1:
			gbc.fill = GridBagConstraints.NONE;
			break;
		case 2:
			gbc.fill = GridBagConstraints.HORIZONTAL;
			break;
		case 3:
			gbc.fill = GridBagConstraints.VERTICAL;
			break;
		}
		switch (alignment) {
		case 0:
			gbc.anchor = GridBagConstraints.CENTER;
			break;
		case 1:
			gbc.anchor = GridBagConstraints.NORTH;
			break;
		case 2:
			gbc.anchor = GridBagConstraints.NORTHEAST;
			break;
		case 3:
			gbc.anchor = GridBagConstraints.EAST;
			break;
		case 4:
			gbc.anchor = GridBagConstraints.SOUTHEAST;
			break;
		case 5:
			gbc.anchor = GridBagConstraints.SOUTH;
			break;
		case 6:
			gbc.anchor = GridBagConstraints.SOUTHWEST;
			break;
		case 7:
			gbc.anchor = GridBagConstraints.WEST;
			break;
		case 8:
			gbc.anchor = GridBagConstraints.NORTHWEST;
			break;
		}
		gridbag.setConstraints(obj, gbc);
		obj.putClientProperty(Constants.sizeVari, Constants.compSize);
		this.add(obj);
	}

	/**
	 * This method call a builder method to generate settings for each
	 * component.
	 **/
	private void buildElements()
	{
		buildElement(gridPane, 0, 1, 6, 1, 0, 0, 1, 0);
		buildElement(moveCounter, 0, 2, 3, 1, 0, 0, 0, 0);
		buildElement(minMoves, 3, 2, 3, 1, 0, 0, 0, 0);
		buildElement(allOn, 0, 3, 2, 1, 0, 0, 0, 0);
		buildElement(hint, 2, 3, 2, 1, 0, 0, 0, 0);
		buildElement(randomLights, 4, 3, 2, 1, 0, 0, 0, 0);
	}
}
