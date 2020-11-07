package com.zoo.exception;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
public class AnimalNotFoundException extends Exception {
	
	private static final long serialVersionUID = -7044951397658166460L;

	public AnimalNotFoundException(String s) {
		super(s);
	}

}
