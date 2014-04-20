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
	// private final int MINIMISED = 2;
	private final int OPEN = 3;
	private BufferedImage[] images;
	private int currentImage;
	private Coordinate location;
	private Graphics graphics;
	private int WxH;
	private String name;
	private Window parent;

	public Icon(Coordinate coord, BufferedImage[] icon, Graphics g, int size, String text, Window parent) {
		super(text);
		images = icon;
		location = coord;
		graphics = g;
		WxH = size;
		name = text;
		this.parent = parent;
	}

	public Icon(Coordinate coord, BufferedImage[] icon, Graphics g, int size, String text) {
		super(text);
		images = icon;
		location = coord;
		graphics = g;
		WxH = size;
		name = text;
	}

	public void draw() {
		graphics.drawImage(images[currentImage], location.getX(), location.getY(), WxH, WxH, null);
	}

	public void draw(Graphics g) {
		g.drawImage(images[currentImage], location.getX(), location.getY(), WxH, WxH, null);
	}

	public Coordinate getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

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

	public void closeEvent() {
		SystemSettings.setCurrentFocus(null);
		currentImage = CLOSED;
	}

}
