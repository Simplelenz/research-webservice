package org.tharindu.research.webservice.model;

import java.time.LocalDateTime;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Activity {
	private long id;
	private String name;
	private LocalDateTime startTime;
	private LocalDateTime endTime;

	public Activity() {
		this.startTime = LocalDateTime.now();
		this.endTime = LocalDateTime.now();
	}

	public Activity(long id, String name) {
		this.id = id;
		this.name = name;
		this.startTime = LocalDateTime.now();
		this.endTime = LocalDateTime.now();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	
}
