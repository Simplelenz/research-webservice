package org.tharindu.research.webservice.model;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("locations")
public class Location {
	@Id
	private long id;
	private String name;
	@Embedded
	private List<Activity> activity;
	
	public Location() {
		
	}
	
	public Location(long id, String name, List<Activity> activity) {
		this.id = id;
		this.name = name;
		this.activity = activity;
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

	public List<Activity> getActivity() {
		return activity;
	}

	public void setActivity(List<Activity> activity) {
		this.activity = activity;
	}
	
}
