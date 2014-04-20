package com.github.ZXSkelobrine.OS.components.basic.embeded;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.github.ZXSkelobrine.OS.Screen;
import com.github.ZXSkelobrine.OS.components.basic.Component;
import com.github.ZXSkelobrine.OS.misc.SystemSettings;
import com.github.ZXSkelobrine.OS.variables.Coordinate;

public class Icon extends Component {
	private final int CLOSED = 0;
	private final int HOVER = 1;
	private final int OPEN = 3;
	private BufferedImage[] images;
	private int currentImage;
	private Coordinate location;
	private int WxH;
	private String name;
	private Window parent;

	public Icon(Coordinate coord, BufferedImage[] icon, int size, String text, Window parent) {
		super(text);
		images = icon;
		location = coord;
		WxH = size;
		name = text;
		this.parent = parent;
	}

	public Icon(Coordinate coord, BufferedImage[] icon, int size, String text) {
		super(text);
		images = icon;
		location = coord;
		WxH = size;
		name = text;
	}

	/**
	 * This causes the Icon to re-draw itself on given graphics.
	 * 
	 * @param g
	 *            - The {@link Graphics} to draw on.
	 */
	public void draw(Graphics g) {
		g.drawImage(images[currentImage], location.getX(), location.getY(), WxH, WxH, null);
	}

	/**
	 * This returns the current location.
	 * 
	 * @return {@link #Coordinate} - The current location.
	 */
	public Coordinate getLocation() {
		return location;
	}

	/**
	 * This returns the current name.
	 * 
	 * @return {@link String} - the current name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * This sets a new parent window
	 * 
	 * @param parent
	 *            - the new setting.
	 */
	public void setParent(Window parent) {
		this.parent = parent;
	}

	@Override
	public void hoverEvent(Coordinate location) {
		currentImage = HOVER;
	}

	@Override
	public void clickEvent(Coordinate location) {
		currentImage = OPEN;
		Screen.frame.getWindow("Settings").setClosed(false);
	}

	@Override
	public void dragEvent(Coordinate location) {
	}

	@Override
	public void nullEvent(Coordinate location) {
		if (!parent.isClosed()) {
			currentImage = OPEN;
		} else {
			currentImage = CLOSED;
		}
	}

	/**
	 * This is called when the parent window is closed.
	 */
	public void closeEvent() {
		SystemSettings.setCurrentFocus(null);
		currentImage = CLOSED;
	}

}
