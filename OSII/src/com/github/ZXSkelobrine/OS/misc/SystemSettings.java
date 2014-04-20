package com.github.ZXSkelobrine.OS.misc;

import com.github.ZXSkelobrine.OS.components.basic.embeded.Window;

public class SystemSettings {
	static Window focused;

	/**
	 * This gets the current focused window. Used to send the correct window key
	 * inputs currently.
	 * 
	 * @return - The window that is currently open and was clicked last.
	 */
	public static Window getCurrentFocus() {
		return focused;
	}

	/**
	 * This sets the new focused window.
	 * 
	 * @param newFocus
	 *            - The new focused window.
	 */
	public static void setCurrentFocus(Window newFocus) {
		focused = newFocus;
	}
}
