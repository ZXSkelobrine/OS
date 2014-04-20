package com.github.ZXSkelobrine.OS.components.basic.embeded;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.KeyEvent;

import com.github.ZXSkelobrine.OS.misc.SystemSettings;
import com.github.ZXSkelobrine.OS.variables.Coordinate;
import com.github.ZXSkelobrine.OS.variables.Themes;

public class Window {

	private String title;
	private boolean canMinimise;
	private boolean canMaximise;
	private boolean canClose;
	private boolean isMinimised;
	private boolean isMaximised;
	private boolean isClosed;
	private Themes chosenTheme;
	private Dimension size;
	private Coordinate location;
	private Icon parent;

	public Window(String title, boolean canClose, boolean canMaximise, boolean canMinimise, Themes chosenTheme, Dimension size, Coordinate location, Icon parent) {
		this.title = title;
		this.canClose = canClose;
		this.canMaximise = canMaximise;
		this.canMinimise = canMinimise;
		this.chosenTheme = chosenTheme;
		this.size = size;
		this.isClosed = true;
		this.isMaximised = false;
		this.isMinimised = false;
		this.location = location;
		this.parent = parent;
		parent.closeEvent();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean canMinimise() {
		return canMinimise;
	}

	public void setCanMinimise(boolean canMinimise) {
		this.canMinimise = canMinimise;
	}

	public boolean canMaximise() {
		return canMaximise;
	}

	public void setCanMaximise(boolean canMaximise) {
		this.canMaximise = canMaximise;
	}

	public boolean canClose() {
		return canClose;
	}

	public void setCanClose(boolean canClose) {
		this.canClose = canClose;
	}

	public boolean isMinimised() {
		return isMinimised;
	}

	public void setMinimised(boolean isMinimised) {
		this.isMinimised = isMinimised;
	}

	public boolean isMaximised() {
		return isMaximised;
	}

	public void setMaximised(boolean isMaximised) {
		this.isMaximised = isMaximised;
	}

	public boolean isClosed() {
		return isClosed;
	}

	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}

	public Themes getTheme() {
		return chosenTheme;
	}

	public void setTheme(Themes theme) {
		this.chosenTheme = theme;
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	public Coordinate getLocation() {
		return location;
	}

	public void setLocation(Coordinate location) {
		this.location = location;
	}

	public Icon getParent() {
		return parent;
	}

	public void setParentIcon(Icon parent) {
		this.parent = parent;
	}

	public void draw(Graphics g) {
		if (!isClosed) {
			{// Top Tab Drawing
				Graphics2D g2d = (Graphics2D) g;
				g2d.setColor(chosenTheme.getColor().darker());
				g2d.setStroke(new BasicStroke(4));
				g2d.drawLine(location.getX() + 10, location.getY(), location.getX() + (size.width - 10), location.getY());
				g2d.drawLine(location.getX(), location.getY() + 10, location.getX() + size.width, location.getY() + 10);
				g2d.drawLine(location.getX(), location.getY() + 10, location.getX() + 10, location.getY());
				g2d.drawLine(location.getX() + size.width, location.getY() + 10, location.getX() + (size.width - 10), location.getY());
				g.setColor(chosenTheme.getColor());
				int[] x = new int[] { location.getX(), location.getX() + 10, location.getX() + (size.width - 10), location.getX() + size.width };
				int[] y = new int[] { location.getY() + 10, location.getY(), location.getY(), location.getY() + 10 };
				Polygon polygon = new Polygon(x, y, x.length);
				g.fillPolygon(polygon);
			}// End Top Tab Drawing
			{// Box drawing
				Graphics2D g2d = (Graphics2D) g;
				g2d.setColor(chosenTheme.getColor().darker());
				g2d.setStroke(new BasicStroke(4));
				int[] x = new int[] { location.getX(), location.getX() + size.width, location.getX() + size.width, location.getX() };
				int[] y = new int[] { location.getY() + 10, location.getY() + 10, location.getY() + (size.height - 10), location.getY() + (size.height - 10) };
				g2d.drawPolygon(x, y, x.length);
				g.setColor(chosenTheme.getColor());
				g.fillPolygon(x, y, x.length);
			}// End box drawing
			{// Close/Minimise/Maximise Buttons
				g.setColor(Color.RED);
				g.fillRoundRect(location.getX() + (size.width / 2), location.getY(), 7, 7, 5, 5);
			}// End Close/Minimise/Maximise Buttons
		}
	}

	public void clickEvent(Coordinate location) {
		SystemSettings.setCurrentFocus(this);
		if (location.getX() > this.location.getX() + (size.width / 2)) {
			if (location.getY() > this.location.getY()) {
				if (location.getX() < this.location.getX() + (size.width / 2) + 10) {
					if (location.getY() < this.location.getY() + 30) {
						isClosed = true;
						parent.closeEvent();
					}
				}

			}
		}
	}

	@SuppressWarnings("unused")
	private void out(String message) {
		System.out.println(title + ": " + message);
	}

	public void hoverEvent() {
	}

	public void dragEvent(Coordinate location) {
		setLocation(location);
	}

	public void keyEvent(int keyCode, char keyChar) {
		System.out.println("Recieved: " + keyChar + "\t" + keyCode + "\t" + KeyEvent.getKeyText(keyCode));
	}
}
