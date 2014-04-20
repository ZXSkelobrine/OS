package com.github.ZXSkelobrine.OS.components.basic.embeded.inner;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;

import com.github.ZXSkelobrine.OS.components.basic.embeded.Window;
import com.github.ZXSkelobrine.OS.variables.Coordinate;

public class Button {
	private Coordinate location;
	private BufferedImage[] images;
	private Window parent;
	private boolean important;
	private Dimension size;
	private Color border;
	private Color fill;
	private Color textColor;
	private String text;

	public Button(Coordinate location, BufferedImage[] images, Window parent, boolean important, Dimension size, Color border, Color fill, Color textColor, String text) {
		this.location = new Coordinate(location, parent.getLocation());
		this.images = images;
		this.parent = parent;
		this.important = important;
		this.size = size;
		this.border = border;
		this.fill = fill;
		this.textColor = textColor;
		this.text = text;
	}

	public Coordinate getLocation() {
		return location;
	}

	public void setLocation(Coordinate location) {
		this.location = location;
	}

	public Window getParent() {
		return parent;
	}

	public void setParent(Window newParent) {
		parent = newParent;
	}

	public boolean isImportant() {
		return important;
	}

	public void setImportance(boolean isImportant) {
		important = isImportant;
	}

	public BufferedImage[] getImages() {
		return images;
	}

	public void draw(Graphics g) {
		int[] x = new int[] { location.getX(), location.getX() + size.width, location.getX() + size.width, location.getX() };
		int[] y = new int[] { location.getY(), location.getY(), location.getY() + size.height, location.getY() + size.height };
		int amount = x.length;
		Polygon polygon = new Polygon(x, y, amount);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(border);
		g2d.drawPolygon(polygon);
		g.setColor(fill);
		g.fillPolygon(polygon);
		g.setColor(textColor);
		g.drawString(text, location.getX() + size.width / 2, location.getY() + size.height / 2);
	}

	public String getText() {
		return text;
	}

}
