package log.com;

public class Constants
{
	public static final String compSize = "normal";
	public static final String sizeVari = "JComponent.sizeVariant";
	public static final String controlSize = "small";
	public static final String title = "Lights Out Game";
	public static final String allOnText = "Turn All Lights On";
	public static final String hintText = "Hints Remaining: ";
	public static final String randomLightsText = "Random Board";
	public static final String moveCounterText = "Moves: ";
	public static final String minMovesText = "Minimum Moves: ";
	public static final String offLightPngLoc = "icon/greyLight32x.png";
	public static final String onLightPngLoc = "icon/greenLight32x.png";
	public static final String lookAndFeelLoc = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
	public static final String[] completedMessage = {
		"Congratulations! You have completed this puzzle in ",
		" moves with ",
		" hints. \nThe minimum number of moves is ",
		". \n",
		"Game Completed!"
	};
	public static final String[] gridPanelStr = {
		"Light (",
		",",
		")."
	};
	public static final String[] finishMessages = { "You must be cheating!",
		"A flawless game!", "Near-perfect!",
		"You had a bit of redundancy!", "A few errors were made!",
		"Decent effort!", "Keep practising!",
		"Don't even bother with this game.", "Nice Score, Bro",
		"Couldn't you have at least gotten 1337?",
		"IT'S OVER NINE THOUSAND!!!", "/fp"
		};
	public static final String stringDefault = "";
	public static final int gridX = 5;
	public static final int gridY = 5;
}
