package com.zoo.dto;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
public class AnimalRequestDTO {
	private String title;
	private String type;
	private Long preference;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getPreference() {
		return preference;
	}

	public void setPreference(Long preference) {
		this.preference = preference;
	}
}
