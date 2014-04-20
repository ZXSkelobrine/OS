package com.github.ZXSkelobrine.OS;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

import com.github.ZXSkelobrine.OS.components.basic.Frame;
import com.github.ZXSkelobrine.OS.components.basic.embeded.Icon;
import com.github.ZXSkelobrine.OS.components.basic.embeded.Window;

public class Drawer {

	/**
	 * This caused the program to re-render itself and draw a new image. This
	 * asks all icons and windows to redraw themselves onto the buffered images
	 * graphics then returns it.
	 * 
	 * @param w
	 *            - The width to make the buffered image.
	 * @param h
	 *            - The height to make the buffered image.
	 * @param frame
	 *            - The frame to get the icons and windows from.
	 * @return BufferedImage - the drawn image.
	 */
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
