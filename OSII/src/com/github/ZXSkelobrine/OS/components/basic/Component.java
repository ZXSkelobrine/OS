package com.github.ZXSkelobrine.OS.components.basic;

import com.github.ZXSkelobrine.OS.variables.Coordinate;

public class Component {

	String name;

	public Component(String name) {
		this.name = name;
	}

	/**
	 * This is called when the component is clicked.
	 * 
	 * @param location
	 *            - The location in terms of the window.
	 */
	public void clickEvent(Coordinate location) {
		out("Clicked");
	}

	/**
	 * This is called when the component is hovered over.
	 * 
	 * @param location
	 *            - The location in terms of the window.
	 */
	public void hoverEvent(Coordinate location) {
		out("Hovered");
	}

	/**
	 * This is called when the component is not hovered over.
	 * 
	 * @param location
	 *            - The location in terms of the window.
	 */
	public void nullEvent(Coordinate location) {
		out("Nulled");
	}

	/**
	 * This is called when the component is dragged.
	 * 
	 * @param location
	 *            - The location in terms of the window.
	 */
	public void dragEvent(Coordinate location) {
		out("Dragged");
	}

	/**
	 * This outputs a message in the form of [name]: [message]
	 * 
	 * @param message
	 *            - The message
	 */
	public void out(String message) {
		System.out.println(name + ": " + message);
	}
}
