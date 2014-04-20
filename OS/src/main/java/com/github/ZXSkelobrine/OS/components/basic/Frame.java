package com.github.ZXSkelobrine.OS.components.basic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import com.github.ZXSkelobrine.OS.Drawer;
import com.github.ZXSkelobrine.OS.components.basic.embeded.Icon;
import com.github.ZXSkelobrine.OS.components.basic.embeded.Window;
import com.github.ZXSkelobrine.OS.misc.Loader;

public class Frame extends JComponent {

	private static final long serialVersionUID = -2606351039417857060L;
	public List<Icon> desktopIcons = new ArrayList<Icon>();
	public List<String> desktopIconNames = new ArrayList<String>();
	public List<Window> openWindows = new ArrayList<Window>();
	public List<String> openWindowNames = new ArrayList<>();
	public BufferedImage background = Loader.defaultBackground;
	public Graphics g;

	public Frame() {
		super();
		BufferedImage b = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		g = b.createGraphics();
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		this.g = g;
		g.setColor(Color.WHITE);
		g.drawImage(background, 0, 0, null);
		g.drawImage(Drawer.render(getWidth(), getHeight(), this), 0, 0, null);
		super.paintComponent(g);
	}

	public synchronized void addIcon(Icon icon) {
		desktopIconNames.add(icon.getName());
		desktopIcons.add(icon);
	}

	public synchronized void removeIcon(Icon icon) {
		desktopIconNames.remove(icon.getName());
		desktopIcons.remove(icon);
	}

	public synchronized void addWindow(Window window) {
		openWindowNames.add(window.getTitle());
		openWindows.add(window);
	}

	public synchronized void removeWindow(Window window) {
		openWindowNames.remove(window.getTitle());
		openWindows.remove(window);
	}

	public synchronized Window getWindow(String title) {
		return openWindows.get(openWindowNames.indexOf(title));
	}

	public synchronized Icon getIcon(String name) {
		return desktopIcons.get(desktopIconNames.indexOf(name));
	}

	public synchronized void start() {
		Thread t = new Thread() {
			@Override
			public void run() {
				while (true) {
					repaint();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		t.start();
	}
}
