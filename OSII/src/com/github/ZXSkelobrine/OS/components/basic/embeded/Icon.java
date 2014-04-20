package com.github.ZXSkelobrine.OS.components.basic.embeded;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.github.ZXSkelobrine.OS.Screen;
import com.github.ZXSkelobrine.OS.misc.SystemSettings;
import com.github.ZXSkelobrine.OS.variables.Coordinate;

@SuppressWarnings("unused")
public class Icon {
	private final int CLOSED = 0;
	private final int HOVER = 1;
	private final int MINIMISED = 2;
	private final int OPEN = 3;
	private BufferedImage[] images;
	private int currentImage;
	private Coordinate location;
	private Graphics graphics;
	private int WxH;
	private String name;

	public Icon(Coordinate coord, BufferedImage[] icon, Graphics g, int size, String text) {
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

	public void clickEvent() {
		currentImage = OPEN;
		Screen.frame.getWindow("Settings").setClosed(false);
	}

	public void hoverEvent() {
	}

	public void closeEvent() {
		SystemSettings.setCurrentFocus(null);
		currentImage = CLOSED;
	}

	private void out(String message) {
		System.out.println(name + ": " + message);
	}

}
