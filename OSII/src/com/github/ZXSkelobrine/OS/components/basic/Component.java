package com.github.ZXSkelobrine.OS.components.basic;

import com.github.ZXSkelobrine.OS.variables.Coordinate;

public class Component {

	String name;

	public Component(String name) {
		this.name = name;
	}

	public void clickEvent(Coordinate location) {
		out("Clicked");
	}

	public void hoverEvent(Coordinate location) {
		out("Hovered");
	}

	public void nullEvent(Coordinate location) {
		out("Nulled");
	}

	public void dragEvent(Coordinate location) {
		out("Dragged");
	}

	public void out(String message) {
		System.out.println(name + ": " + message);
	}
}
