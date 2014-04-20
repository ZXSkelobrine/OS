package com.github.ZXSkelobrine.OS.misc;

import com.github.ZXSkelobrine.OS.components.basic.embeded.Window;

public class SystemSettings {
	static Window focused;

	public static Window getCurrentFocus() {
		return focused;
	}

	public static void setCurrentFocus(Window newFocus) {
		focused = newFocus;
	}
}
