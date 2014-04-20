package com.github.ZXSkelobrine.OS;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

import com.github.ZXSkelobrine.OS.components.basic.Frame;
import com.github.ZXSkelobrine.OS.components.basic.embeded.Icon;
import com.github.ZXSkelobrine.OS.components.basic.embeded.Window;

public class Drawer {

	public static BufferedImage render(int w, int h, Frame frame) {
		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.createGraphics();
		synchronized (frame.desktopIcons) {
			List<Icon> icos = frame.desktopIcons;
			for (Icon icon : icos) {
				icon.draw(g);
			}
		}
		synchronized (frame.openWindows) {
			List<Window> windos = frame.openWindows;
			for (Window window : windos) {
				window.draw(g);
			}
		}
		return bi;
	}
}
