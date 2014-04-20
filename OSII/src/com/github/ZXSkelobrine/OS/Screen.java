package com.github.ZXSkelobrine.OS;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.github.ZXSkelobrine.OS.components.basic.Frame;
import com.github.ZXSkelobrine.OS.components.basic.embeded.Icon;
import com.github.ZXSkelobrine.OS.components.basic.embeded.Window;
import com.github.ZXSkelobrine.OS.components.basic.embeded.inner.Button;
import com.github.ZXSkelobrine.OS.input.Keyboard;
import com.github.ZXSkelobrine.OS.input.Mouse;
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
		setBounds(100, 100, 1200, 900);

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
		frame.addIcon(new Icon(new Coordinate(50, 50), Loader.desktopIcons, frame.getGraphics(), 50, "Settings"));
		frame.addWindow(new Window("Settings", true, true, true, Themes.Dark, new Dimension(1000, 500), new Coordinate(100, 100), frame.getIcon("Settings")));
		frame.getIcon("Settings").setParent(frame.getWindow("Settings"));
		frame.getWindow("Settings").addButton(new Button(new Coordinate(100, 100), Loader.desktopIcons, frame.getWindow("Settings"), true, new Dimension(50, 50), Color.BLUE, Color.BLACK, "Test", null));
	}

}
