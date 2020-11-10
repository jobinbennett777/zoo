package com.zoo.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Noble Sebastian
 * @version 1.0
 *
 */
@Entity
@Table(name = "Animal")
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;
	
	@JsonIgnore
	@Version
	@Column(name = "VERSION_ID", nullable = false, columnDefinition = "int default 0")
	private Integer versionId;
	
	@Column(name = "title")
	private String title; 
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "preference")
	private Long preference;
	
	@JsonIgnore
	@UpdateTimestamp
	@Column(name = "located")
	private Timestamp located;
	
	@JsonIgnore
	@OneToOne
    @JoinColumn(name = "room_id", referencedColumnName = "id")
	private Room room;

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersionId() {
		return versionId;
	}

	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}

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

	public Timestamp getLocated() {
		return located;
	}

	public void setLocated(Timestamp located) {
		this.located = located;
	}



}
