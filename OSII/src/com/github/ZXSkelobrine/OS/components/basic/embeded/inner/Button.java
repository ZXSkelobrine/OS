package com.github.ZXSkelobrine.OS.components.basic.embeded.inner;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;

import com.github.ZXSkelobrine.OS.components.basic.Component;
import com.github.ZXSkelobrine.OS.components.basic.embeded.Window;
import com.github.ZXSkelobrine.OS.misc.ButtonClickEvent;
import com.github.ZXSkelobrine.OS.misc.Unimplimented;
import com.github.ZXSkelobrine.OS.variables.Coordinate;

public class Button extends Component {
	private Coordinate location;
	private BufferedImage[] images;
	private Window parent;
	private boolean important;
	private Dimension size;
	private Color border;
	private Color textColor;
	private String text;
	private Coordinate origin;
	private int currentImage = 0;
	private final int CLOSED = 0;
	private final int HOVER = 1;
	private final int OPEN = 3;
	private ButtonClickEvent buttonClickEvent;

	public Button(Coordinate location, BufferedImage[] images, Window parent, boolean important, Dimension size, Color border, Color textColor, String text) {
		super(text);
		this.location = new Coordinate(location, parent.getLocation());
		this.images = images;
		this.parent = parent;
		this.important = important;
		this.size = size;
		if (!important) {
			this.border = border;
		} else {
			this.border = Color.RED.darker().darker();
		}
		this.textColor = textColor;
		this.text = text;
		this.origin = location;
	}

	public Button(Coordinate location, BufferedImage[] images, Window parent, boolean important, Dimension size, Color border, Color textColor, String name, Object nullMe) {
		super(name);
		this.location = new Coordinate(location, parent.getLocation());
		this.images = images;
		this.parent = parent;
		this.important = important;
		this.size = size;
		if (!important) {
			this.border = border;
		} else {
			this.border = Color.RED.darker().darker();
		}
		this.textColor = textColor;
		this.origin = location;
		this.text = "";
	}

	/**
	 * This returns the current location.
	 * 
	 * @return {@link Coordinate} - The current location.
	 */
	public Coordinate getLocation() {
		return location;
	}

	/**
	 * This returns the original location.
	 * 
	 * @return {@link Coordinate} - The original location.
	 */
	public Coordinate getOrigin() {
		return origin;
	}

	/**
	 * This sets the location of the Button.
	 * 
	 * @param location
	 *            - The new setting.
	 */
	public void setLocation(Coordinate location) {
		this.location = location;
	}

	/**
	 * This returns the Window parent.
	 * 
	 * @return {@link Window} - The parent window.
	 */
	public Window getParent() {
		return parent;
	}

	/**
	 * This sets the parent {@link Window}.
	 * 
	 * @param parent
	 *            - the new setting.
	 */
	public void setParent(Window newParent) {
		parent = newParent;
	}

	/**
	 * This returns whether the buttons is important
	 * 
	 * @return {@link Boolean} - whether the button is important.
	 */
	public boolean isImportant() {
		return important;
	}

	/**
	 * This sets the current importance of the button.
	 * 
	 * @param isImportant
	 *            - the new setting
	 */
	@Unimplimented
	public void setImportance(boolean isImportant) {
		important = isImportant;
	}

	/**
	 * This returns the current used images.
	 * 
	 * @return {@link BufferedImage}[] - The array of images.
	 */
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
		g.drawImage(images[currentImage], location.getX(), location.getY(), size.width, size.height, null);
		g.setColor(textColor);
		g.drawString(text, location.getX() + size.width / 2, location.getY() + size.height / 2);
	}

	/**
	 * This returns the current text.
	 * 
	 * @return {@link String} - the current text.
	 */
	public String getText() {
		return text;
	}

	public String getName() {
		return super.name;
	}

	/**
	 * This returns the current size of the Button.
	 * 
	 * @return {@link java.awt.Dimension} - The current size.
	 */
	public Dimension getSize() {
		return size;
	}

	public void setClickEvent(ButtonClickEvent event) {
		this.buttonClickEvent = event;
	}

	@Override
	public void clickEvent(Coordinate location) {
		currentImage = OPEN;
		if(buttonClickEvent != null)buttonClickEvent.clickEvent();
	}

	@Override
	public void dragEvent(Coordinate location) {
	}

	@Override
	public void hoverEvent(Coordinate location) {
		currentImage = HOVER;
	}

	@Override
	public void nullEvent(Coordinate location) {
		currentImage = CLOSED;
	}

}
