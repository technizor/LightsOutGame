package log.gui;

import javax.swing.JOptionPane;

import log.com.Constants;

public class CompletedBoardDialog extends JOptionPane
{
	private static final long serialVersionUID = -785539973218186055L;
	private String messageText;
	public CompletedBoardDialog (int min, int moveCount, int hintNum)
	{
		messageText = Constants.completedMessage[0] + moveCount
				+ Constants.completedMessage[1] + hintNum + Constants.completedMessage[2] 
						+ min + Constants.completedMessage[3];
		String subMessage = Constants.stringDefault;
		int diff = (moveCount + hintNum) - min;
		if (diff < 0) subMessage = Constants.finishMessages[0];
		else if (diff == 0) subMessage = Constants.finishMessages[1];
		else if (diff <= 2) subMessage = Constants.finishMessages[2];
		else if (diff <= 4) subMessage = Constants.finishMessages[3];
		else if (diff <= 6) subMessage = Constants.finishMessages[4];
		else if (diff <= 8) subMessage = Constants.finishMessages[5];
		else if (diff <= 10) subMessage = Constants.finishMessages[6];
		else if (diff <= 49) subMessage = Constants.finishMessages[7];
		else if (diff <= 1336) subMessage = Constants.finishMessages[8];
		else if (diff == 1337) subMessage = Constants.finishMessages[9];
		else if (diff <= 9000) subMessage = Constants.finishMessages[10];
		else subMessage = Constants.finishMessages[11];
		messageText += subMessage;
		String titleText = "Lights Out Game: Board Completed!";
		System.out.println(messageText);
		JOptionPane.showMessageDialog(this, messageText,
                titleText, getMessageType());
	}
}
