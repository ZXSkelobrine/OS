package com.github.ZXSkelobrine.OS.misc;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Loader {
	private String desktopPathClosed = "/images/icons/desktop/closed.png";
	private String desktopPathMinimised = "/images/icons/desktop/minimised.png";
	private String desktopPathOpen = "/images/icons/desktop/open.png";
	private String desktopPathHover = "/images/icons/desktop/hover.png";
	private String defaultBackgroundPath = "/images/backgrounds/default.png";
	public static BufferedImage[] desktopIcons = new BufferedImage[] { new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB), new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB), new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB), new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB) };
	public static BufferedImage defaultBackground = new BufferedImage(2560, 1600, BufferedImage.TYPE_INT_ARGB);

	public Loader() {
		try {
			BufferedImage store = ImageIO.read(Loader.class.getResource(desktopPathClosed));
			desktopIcons[0].createGraphics().drawImage(store, 0, 0, 50, 50, null);
			store = ImageIO.read(Loader.class.getResource(desktopPathHover));
			desktopIcons[1].createGraphics().drawImage(store, 0, 0, 50, 50, null);
			store = ImageIO.read(Loader.class.getResource(desktopPathMinimised));
			desktopIcons[2].createGraphics().drawImage(store, 0, 0, 50, 50, null);
			store = ImageIO.read(Loader.class.getResource(desktopPathOpen));
			desktopIcons[3].createGraphics().drawImage(store, 0, 0, 50, 50, null);
			store = ImageIO.read(Loader.class.getResource(defaultBackgroundPath));
			defaultBackground.createGraphics().drawImage(store, 0, 0, 1200, 900, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
