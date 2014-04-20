package com.github.ZXSkelobrine.OS.components.basic.embeded.inner;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import com.github.ZXSkelobrine.OS.components.basic.Component;
import com.github.ZXSkelobrine.OS.components.basic.embeded.Window;
import com.github.ZXSkelobrine.OS.variables.Coordinate;

public class TextField extends Component {

	private boolean isEditable;
	private Coordinate origin;
	private Coordinate location;
	private Dimension size;
	private Window parent;

	public TextField(String name, boolean isEditable, Coordinate location, Dimension size, Window parent) {
		super(name);
		this.isEditable = isEditable;
		this.origin = location;
		this.location = new Coordinate(location, parent.getLocation());
		this.size = size;
		this.parent = parent;
	}

	public boolean isEditable() {
		return isEditable;
	}

	public void setEditable(boolean isEditable) {
		this.isEditable = isEditable;
	}

	public Coordinate getOrigin() {
		return origin;
	}

	public void setOrigin(Coordinate origin) {
		this.origin = origin;
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	public Window getParent() {
		return parent;
	}

	public void setParent(Window parent) {
		this.parent = parent;
	}

	public Coordinate getLocation() {
		return location;
	}

	public void setLocation(Coordinate location) {
		this.location = location;
	}

	@Override
	public void draw(Graphics g) {
		int[] x = new int[] { location.getX(), location.getX() + size.width, location.getX() + size.width, location.getX() };
		int[] y = new int[] { location.getY(), location.getY(), location.getY() + size.height, location.getY() + size.height };
		int amount = x.length;
		Polygon polygon = new Polygon(x, y, amount);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(3));
		g2d.setColor(Color.DARK_GRAY);
		g2d.drawPolygon(polygon);
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillPolygon(x, y, amount);
	}

}
