package com.github.ZXSkelobrine.OS.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.github.ZXSkelobrine.OS.misc.SystemSettings;

public class Keyboard implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (SystemSettings.getCurrentFocus() != null) SystemSettings.getCurrentFocus().keyEvent(arg0.getKeyCode(), arg0.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}
