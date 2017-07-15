package org.tharindu.research.webservice.model;

import java.time.LocalDateTime;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Reference;

@Embedded
public class Position {
	private double latitude;
	private double longitude;
	private LocalDateTime time;
	@Reference(idOnly = true, lazy = true)
	private double locationId;
	
	public Position() {
		this.time = LocalDateTime.now();
		
	}
	
	public Position(double latitude, double longitude, double locationId) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.time = LocalDateTime.now();
		this.locationId = locationId;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	public double getLocationId() {
		return locationId;
	}

	public void setLocationId(double locationId) {
		this.locationId = locationId;
	}
}
