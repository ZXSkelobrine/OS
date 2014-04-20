package com.github.ZXSkelobrine.OS.variables;

import java.awt.event.MouseEvent;

public class Coordinate {
	private int x, y;

	/**
	 * This creates a Coordinate at (0, 0) using {@link #Coordinate(int, int)}
	 * and passing it 0 and 0.
	 */
	public Coordinate() {
		this(0, 0);
	}

	/**
	 * This creates a coordinate of the x and y of a mouse event.
	 * 
	 * @param event
	 *            - The event to get the x and y from.
	 */
	public Coordinate(MouseEvent event) {
		this.x = event.getX();
		this.y = event.getY();
	}

	/**
	 * This creates a coordinate from given x and y.
	 * 
	 * @param x
	 *            - The x.
	 * @param y
	 *            - The y.
	 */
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * This creates an offseted coordinate from two sets. It adds the offset x
	 * and y to the origin x and y and calls {@link #Coordinate(int, int)}
	 * 
	 * @param origin
	 *            - The original coordinate.
	 * @param offset
	 *            - This coordinate to get the offset from.
	 */
	public Coordinate(Coordinate origin, Coordinate offset) {
		this(origin.getX() + offset.getX(), origin.getY() + offset.getY());
	}

	/**
	 * This sets a new x
	 * 
	 * @param x
	 *            - The new x.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * This sets a new y.
	 * 
	 * @param y
	 *            - The new y.
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * This returns the current x.
	 * 
	 * @return - The current x.
	 */
	public int getX() {
		return x;
	}

	/**
	 * This returns the current y.
	 * 
	 * @return - The current y.
	 */
	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "X: " + x + "\tY: " + y;
	}
}
