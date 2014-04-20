package com.github.ZXSkelobrine.OS.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import com.github.ZXSkelobrine.OS.Screen;
import com.github.ZXSkelobrine.OS.components.basic.embeded.Icon;
import com.github.ZXSkelobrine.OS.components.basic.embeded.Window;
import com.github.ZXSkelobrine.OS.variables.Coordinate;

public class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener {

	public void mouseWheelMoved(MouseWheelEvent arg0) {
		Screen.frame.repaint();
	}

	public void mouseDragged(MouseEvent e) {
		for (Window window : Screen.frame.openWindows) {
			if (e.getX() > window.getLocation().getX()) {
				if (e.getY() > window.getLocation().getY()) {
					if (e.getX() < window.getLocation().getX() + window.getSize().width) {
						if (e.getY() < window.getLocation().getY() + window.getSize().height) {
							window.dragEvent(new Coordinate(e.getX() - ((window.getSize().width / 2)), e.getY() - ((window.getSize().height / 2))));
						}
					}
				}
			}
		}
		Screen.frame.repaint();
	}

	public void mouseMoved(MouseEvent e) {
		for (Icon icon : Screen.frame.desktopIcons) {
			if (e.getX() > icon.getLocation().getX()) {
				if (e.getY() > icon.getLocation().getY()) {
					if (e.getX() < icon.getLocation().getX() + 50) {
						if (e.getY() < icon.getLocation().getY() + 50) {
							icon.hoverEvent();
						}
					}
				}
			}
		}
		for (Window window : Screen.frame.openWindows) {
			if (e.getX() > window.getLocation().getX()) {
				if (e.getY() > window.getLocation().getY()) {
					if (e.getX() < window.getLocation().getX() + window.getSize().width) {
						if (e.getY() < window.getLocation().getY() + window.getSize().height) {
							window.hoverEvent();
						}
					}
				}
			}
		}
		Screen.frame.repaint();
	}

	public void mouseClicked(MouseEvent e) {
		for (Icon icon : Screen.frame.desktopIcons) {
			if (e.getX() > icon.getLocation().getX()) {
				if (e.getY() > icon.getLocation().getY()) {
					if (e.getX() < icon.getLocation().getX() + 50) {
						if (e.getY() < icon.getLocation().getY() + 50) {
							icon.clickEvent();
						}
					}
				}
			}
		}
		for (Window window : Screen.frame.openWindows) {
			if (e.getX() > window.getLocation().getX()) {
				if (e.getY() > window.getLocation().getY()) {
					if (e.getX() < window.getLocation().getX() + window.getSize().width) {
						if (e.getY() < window.getLocation().getY() + window.getSize().height) {
							window.clickEvent(new Coordinate(e));
						}
					}
				}
			}
		}
		Screen.frame.repaint();
	}

	public void mouseEntered(MouseEvent arg0) {
		Screen.frame.repaint();
	}

	public void mouseExited(MouseEvent arg0) {
		Screen.frame.repaint();
	}

	public void mousePressed(MouseEvent arg0) {
		Screen.frame.repaint();
	}

	public void mouseReleased(MouseEvent arg0) {
		Screen.frame.repaint();
	}

}
