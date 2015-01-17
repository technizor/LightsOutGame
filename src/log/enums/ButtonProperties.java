package log.enums;

import java.awt.Dimension;

public enum ButtonProperties {
	close("X", "Close this application."), minimize("_",
			"Minimize this application.");
	private String labelText;
	private String toolTip;

	ButtonProperties(String l, String t) {
		labelText = l;
		toolTip = t;
	}

	public String getLabel()
	{
		return labelText;
	}

	public Dimension getSize()
	{
		return new Dimension(75, 25);
	}

	public String getToolTip()
	{
		return toolTip;
	}
}
