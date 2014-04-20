package com.github.ZXSkelobrine.OS.variables;

import java.awt.event.MouseEvent;

public class Coordinate {
	private int x, y;

	public Coordinate() {
		this(0, 0);
	}

	public Coordinate(MouseEvent event) {
		this.x = event.getX();
		this.y = event.getY();
	}

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Coordinate(Coordinate origin, Coordinate offset) {
		this(origin.getX() + offset.getX(), origin.getY() + offset.getY());
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "X: " + x + "\tY: " + y;
	}
}
