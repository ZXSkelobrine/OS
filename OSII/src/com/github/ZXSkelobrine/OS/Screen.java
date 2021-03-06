package com.github.ZXSkelobrine.OS;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;

import com.github.ZXSkelobrine.OS.components.basic.Component;
import com.github.ZXSkelobrine.OS.components.basic.Frame;
import com.github.ZXSkelobrine.OS.components.basic.embeded.Icon;
import com.github.ZXSkelobrine.OS.components.basic.embeded.Window;
import com.github.ZXSkelobrine.OS.components.basic.embeded.inner.Button;
import com.github.ZXSkelobrine.OS.input.Keyboard;
import com.github.ZXSkelobrine.OS.input.Mouse;
import com.github.ZXSkelobrine.OS.misc.ButtonClickEvent;
import com.github.ZXSkelobrine.OS.misc.Loader;
import com.github.ZXSkelobrine.OS.variables.Coordinate;
import com.github.ZXSkelobrine.OS.variables.Themes;

public class Screen extends JFrame {

	private static final long serialVersionUID = -2880162891079121676L;
	private JPanel contentPane;
	public static Frame frame = new Frame();
	Mouse mouse = new Mouse();
	Keyboard keyboard = new Keyboard();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Loader();
					Screen frame = new Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Screen() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 675);

		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		addMouseWheelListener(mouse);
		addKeyListener(keyboard);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		frame.setBounds(0, 0, getWidth(), getHeight());
		contentPane.add(frame);
		done();
	}

	public void done() {
		frame.addIcon(new Icon(new Coordinate(50, 50), Loader.desktopIcons, 50, "Settings"));
		frame.addWindow(new Window("Settings", true, true, true, Themes.Dark, new Dimension(1000, 500), new Coordinate(100, 100), frame.getIcon("Settings")));
		frame.getIcon("Settings").setParent(frame.getWindow("Settings"));
		frame.getWindow("Settings").addComponent(new Button(new Coordinate(100, 100), Loader.screenIcons, frame.getWindow("Settings"), true, new Dimension(50, 50), Color.BLUE, Color.BLACK, "Test", null));

		frame.addWindow(new Window("Display Settings", true, false, true, Themes.Light, new Dimension(750, 350), new Coordinate(100, 100), null));
		frame.getWindow("Display Settings").addComponent(new Button(new Coordinate(30, 30), Loader.folderIcons, frame.getWindow("Display Settings"), false, new Dimension(50, 50), Color.BLACK, Color.WHITE, "Choose File", null));
		((Button) frame.getWindow("Settings").getComponent("Test")).setClickEvent(new ButtonClickEvent() {
			@Override
			public void clickEvent() {
				Screen.frame.getWindow("Display Settings").setClosed(false);
			}
		});
		Component c = frame.getWindow("Display Settings").getComponent("Choose File");
		((Button) c).setClickEvent(new ButtonClickEvent() {
			@Override
			public void clickEvent() {
				JFileChooser jfc = new JFileChooser();
				jfc.addChoosableFileFilter(new ImageFilter());
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					File img = jfc.getSelectedFile();
					try {
						BufferedImage bi = ImageIO.read(img);
						BufferedImage newImg = new BufferedImage(1200, 675, BufferedImage.TYPE_INT_ARGB);
						newImg.createGraphics().drawImage(bi, 0, 0, 1200, 675, null);
						Loader.defaultBackground = newImg;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
}

class ImageFilter extends FileFilter {

	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}

		String extension = Utils.getExtension(f);
		if (extension != null) {
			if (extension.equals(Utils.tiff) || extension.equals(Utils.tif) || extension.equals(Utils.gif) || extension.equals(Utils.jpeg) || extension.equals(Utils.jpg) || extension.equals(Utils.png)) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	public String getDescription() {
		return "Images (.tiff, .tif, .gif, .jpeg, .jpg, .png)";
	}
}

class Utils {
	public final static String jpeg = "jpeg";
	public final static String jpg = "jpg";
	public final static String gif = "gif";
	public final static String tiff = "tiff";
	public final static String tif = "tif";
	public final static String png = "png";

	/*
	 * Get the extension of a file.
	 */
	public static String getExtension(File f) {
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');

		if (i > 0 && i < s.length() - 1) {
			ext = s.substring(i + 1).toLowerCase();
		}
		return ext;
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = Utils.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}
