package com.github.ZXSkelobrine.OS.components.basic.embeded;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import com.github.ZXSkelobrine.OS.components.basic.Component;
import com.github.ZXSkelobrine.OS.components.basic.embeded.inner.Button;
import com.github.ZXSkelobrine.OS.misc.SystemSettings;
import com.github.ZXSkelobrine.OS.misc.Unimplimented;
import com.github.ZXSkelobrine.OS.variables.Coordinate;
import com.github.ZXSkelobrine.OS.variables.Themes;

public class Window extends Component {

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
	private List<Component> components = new ArrayList<Component>();
	private List<String> componentNames = new ArrayList<String>();

	public Window(String title, boolean canClose, boolean canMaximise, boolean canMinimise, Themes chosenTheme, Dimension size, Coordinate location, Icon parent) {
		super(title);
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
		if (this.parent != null) parent.closeEvent();
	}

	/**
	 * This returns the title.
	 * 
	 * @return {@link String} - the title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This sets the title.
	 * 
	 * @param title
	 *            - The title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * This returns whether the window can minimise.
	 * 
	 * @return {@link Boolean} - whether the window can minimise.
	 */
	@Unimplimented
	public boolean canMinimise() {
		return canMinimise;
	}

	/**
	 * This sets whether the window can minimise.
	 * 
	 * @param canMinimise
	 *            - The new setting.
	 */
	@Unimplimented
	public void setCanMinimise(boolean canMinimise) {
		this.canMinimise = canMinimise;
	}

	/**
	 * This returns whether the window can maximise.
	 * 
	 * @return {@link Boolean} - whether the window can maximise.
	 */
	@Unimplimented
	public boolean canMaximise() {
		return canMaximise;
	}

	/**
	 * This sets whether the window can maximise.
	 * 
	 * @param canMaximise
	 *            - The new setting.
	 */
	@Unimplimented
	public void setCanMaximise(boolean canMaximise) {
		this.canMaximise = canMaximise;
	}

	/**
	 * This returns whether the window can close.
	 * 
	 * @return {@link Boolean} - whether the window can close.
	 */
	public boolean canClose() {
		return canClose;
	}

	/**
	 * This sets whether the window can close.
	 * 
	 * @param canClose
	 *            - The new setting.
	 */
	public void setCanClose(boolean canClose) {
		this.canClose = canClose;
	}

	/**
	 * This returns whether the window is minimised.
	 * 
	 * @return {@link Boolean} - whether the window is minimised.
	 */
	@Unimplimented
	public boolean isMinimised() {
		return isMinimised;
	}

	/**
	 * This sets whether the window is minimised
	 * 
	 * @param isMinimised
	 *            - the new setting.
	 */
	@Unimplimented
	public void setMinimised(boolean isMinimised) {
		this.isMinimised = isMinimised;
	}

	/**
	 * This returns whether the window is maximised.
	 * 
	 * @return {@link Boolean} - whether the window is maximised.
	 */
	@Unimplimented
	public boolean isMaximised() {
		return isMaximised;
	}

	/**
	 * This sets whether the window is maximised
	 * 
	 * @param isMinimised
	 *            - the new setting.
	 */
	@Unimplimented
	public void setMaximised(boolean isMaximised) {
		this.isMaximised = isMaximised;
	}

	/**
	 * This returns whether the window is closed.
	 * 
	 * @return {@link Boolean} - whether the window is closed.
	 */
	public boolean isClosed() {
		return isClosed;
	}

	/**
	 * This sets whether the window is closed
	 * 
	 * @param isMinimised
	 *            - the new setting.
	 */
	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}

	/**
	 * This returns the current selected theme.
	 * 
	 * @return {@link Themes} - the chosen theme
	 */
	public Themes getTheme() {
		return chosenTheme;
	}

	/**
	 * This sets the new theme.
	 * 
	 * @param theme
	 *            - the new setting.
	 */
	public void setTheme(Themes theme) {
		this.chosenTheme = theme;
	}

	/**
	 * This returns the current size of the Window.
	 * 
	 * @return {@link java.awt.Dimension} - The current size.
	 */
	public Dimension getSize() {
		return size;
	}

	/**
	 * This sets the size of the Window.
	 * 
	 * @param size
	 *            - the new setting
	 */
	public void setSize(Dimension size) {
		this.size = size;
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
	 * This sets the location of the window.
	 * 
	 * @param location
	 *            - The new setting.
	 */
	public void setLocation(Coordinate location) {
		for (Component component : components) {
			if (component instanceof Button) {
				Button button = (Button) component;
				button.setLocation(new Coordinate(button.getOrigin(), button.getParent().getLocation()));
			}
		}
		this.location = location;
	}

	/**
	 * This returns the Icon parent.
	 * 
	 * @return {@link Icon} - The parent icon.
	 */
	public Icon getParent() {
		return parent;
	}

	/**
	 * This sets the parent icon.
	 * 
	 * @param parent
	 *            - the new setting.
	 */
	public void setParentIcon(Icon parent) {
		this.parent = parent;
	}

	/**
	 * This adds a button to the window.
	 * 
	 * @param button
	 *            - The new button.
	 */
	public void addComponent(Component component) {
		componentNames.add(component.getName());
		components.add(component);
	}

	/**
	 * This removes a button from the window.
	 * 
	 * @param button
	 *            - The button.
	 */
	public void removeComponent(Component component) {
		componentNames.remove(component.getName());
		components.remove(component);
	}

	/**
	 * This gets a button from the name.
	 * 
	 * @param text
	 *            - The name.
	 * @return {@link Button} - The button
	 */
	public Component getComponent(String text) {
		return components.get(componentNames.indexOf(text));
	}

	/**
	 * This caused the Window to re-draw istelf
	 * 
	 * @param g
	 *            - The graphics to draw the window to.
	 */
	@Override
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
			{// Buttons
				for (Component component : components) {
					component.draw(g);
				}
			}// End Buttons
		}
	}

	public void clickEvent(Coordinate location) {
		SystemSettings.setCurrentFocus(this);
		if (location.getX() > this.location.getX() + (size.width / 2)) {
			if (location.getY() > this.location.getY()) {
				if (location.getX() < this.location.getX() + (size.width / 2) + 10) {
					if (location.getY() < this.location.getY() + 30) {
						isClosed = true;
						if (parent != null) parent.closeEvent();
					}
				}

			}
		}
		for (Component component : components) {
			if (component instanceof Button) {
				Button button = (Button) component;
				if (location.getX() > button.getLocation().getX()) {
					if (location.getY() > button.getLocation().getY()) {
						if (location.getX() < button.getLocation().getX() + (button.getSize().width + (button.getSize().width / 2))) {
							if (location.getY() < button.getLocation().getY() + (button.getSize().height + (button.getSize().height / 2))) {
								button.clickEvent(location);
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void hoverEvent(Coordinate location) {
		for (Component component : components) {
			if (component instanceof Button) {
				Button button = (Button) component;
				if (location.getX() > button.getLocation().getX()) {
					if (location.getY() > button.getLocation().getY()) {
						if (location.getX() < button.getLocation().getX() + (button.getSize().width + (button.getSize().width / 2))) {
							if (location.getY() < button.getLocation().getY() + (button.getSize().height + (button.getSize().height / 2))) {
								button.hoverEvent(location);
							} else {
								button.nullEvent(location);
							}
						} else {
							button.nullEvent(location);
						}
					} else {
						button.nullEvent(location);
					}
				} else {
					button.nullEvent(location);
				}
			}
		}
	}

	@Override
	public void dragEvent(Coordinate location) {
		if (this.equals(SystemSettings.getCurrentFocus())) setLocation(location);
	}

	@Override
	public void nullEvent(Coordinate location) {
	}

	/**
	 * This is called when the window is currently focused and a key is pressed.
	 * 
	 * @param keyCode
	 *            - The key code.
	 * @param keyChar
	 *            - This key char.
	 */
	public void keyEvent(int keyCode, char keyChar) {
		System.out.println("Recieved: " + keyChar + "\t" + keyCode + "\t" + KeyEvent.getKeyText(keyCode));
	}
}
