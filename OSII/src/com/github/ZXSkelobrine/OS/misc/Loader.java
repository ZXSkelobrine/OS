package com.github.ZXSkelobrine.OS.misc;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Loader {
	private String[] desktopPaths = new String[] { "/images/icons/desktop/closed.png", "/images/icons/desktop/hover.png", "/images/icons/desktop/minimised.png", "/images/icons/desktop/open.png" };
	private String[] backgroundPaths = new String[] { "/images/backgrounds/default.png" };
	private String[] folderPaths = new String[] { "/images/icons/folder/default.png", "/images/icons/folder/hover.png", "/images/icons/folder/minimised.png", "/images/icons/folder/open.png" };
	private String[] screenPaths = new String[] { "/images/icons/screen/default.png", "/images/icons/screen/hover.png", "/images/icons/screen/minimised.png", "/images/icons/screen/open.png" };
	public static BufferedImage[] desktopIcons = new BufferedImage[] { new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB), new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB), new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB), new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB) };
	public static BufferedImage[] folderIcons = new BufferedImage[] { new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB), new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB), new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB), new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB) };
	public static BufferedImage[] screenIcons = new BufferedImage[] { new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB), new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB), new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB), new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB) };
	public static BufferedImage defaultBackground = new BufferedImage(2560, 1600, BufferedImage.TYPE_INT_ARGB);

	public Loader() {
		try {
			BufferedImage store = ImageIO.read(Loader.class.getResource(desktopPaths[0]));
			desktopIcons[0].createGraphics().drawImage(store, 0, 0, 50, 50, null);
			store = ImageIO.read(Loader.class.getResource(desktopPaths[1]));
			desktopIcons[1].createGraphics().drawImage(store, 0, 0, 50, 50, null);
			store = ImageIO.read(Loader.class.getResource(desktopPaths[2]));
			desktopIcons[2].createGraphics().drawImage(store, 0, 0, 50, 50, null);
			store = ImageIO.read(Loader.class.getResource(desktopPaths[3]));
			desktopIcons[3].createGraphics().drawImage(store, 0, 0, 50, 50, null);
			store = ImageIO.read(Loader.class.getResource(backgroundPaths[0]));
			defaultBackground.createGraphics().drawImage(store, 0, 0, 1200, 900, null);
			store = ImageIO.read(Loader.class.getResource(folderPaths[0]));
			folderIcons[0].createGraphics().drawImage(store, 0, 0, 50, 50, null);
			store = ImageIO.read(Loader.class.getResource(folderPaths[1]));
			folderIcons[1].createGraphics().drawImage(store, 0, 0, 50, 50, null);
			store = ImageIO.read(Loader.class.getResource(folderPaths[2]));
			folderIcons[2].createGraphics().drawImage(store, 0, 0, 50, 50, null);
			store = ImageIO.read(Loader.class.getResource(folderPaths[3]));
			folderIcons[3].createGraphics().drawImage(store, 0, 0, 50, 50, null);
			store = ImageIO.read(Loader.class.getResource(screenPaths[0]));
			screenIcons[0].createGraphics().drawImage(store, 0, 0, 50, 50, null);
			store = ImageIO.read(Loader.class.getResource(screenPaths[1]));
			screenIcons[1].createGraphics().drawImage(store, 0, 0, 50, 50, null);
			store = ImageIO.read(Loader.class.getResource(screenPaths[2]));
			screenIcons[2].createGraphics().drawImage(store, 0, 0, 50, 50, null);
			store = ImageIO.read(Loader.class.getResource(screenPaths[3]));
			screenIcons[3].createGraphics().drawImage(store, 0, 0, 50, 50, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
