package com.github.ZXSkelobrine.OS.variables;

import java.awt.Color;

public enum Themes {
	Dark(Color.DARK_GRAY), Light(Color.LIGHT_GRAY), Blue(Color.BLUE), Red(Color.RED);

	private Color c;

	private Themes(Color c) {
		this.c = c;
	}

	public Color getColor() {
		return c;
	}
}
