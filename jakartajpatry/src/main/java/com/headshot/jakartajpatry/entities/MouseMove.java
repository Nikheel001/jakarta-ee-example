package com.headshot.jakartajpatry.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * @author headshot
 *
 */
@Entity
@Table(name = "mousemove")
public class MouseMove {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "_id")
	private int id;
	
	private LocalDateTime entry_date;
	
	private String app_name;
	
	private String information;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(LocalDateTime entry_date) {
		this.entry_date = entry_date;
	}

	public String getApp_name() {
		return app_name;
	}

	public void setApp_name(String app_name) {
		this.app_name = app_name;
	}

	@Override
	public String toString() {
		return String.format("MouseMove [id=%s, entry_date=%s, app_name=%s, information=%s]", id, entry_date, app_name,
				information);
	}
	
}
