package org.tharindu.research.webservice.model;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("employees")
public class Employee {
	@Id
	private long id;
	@Embedded
	private List<Position> position = new ArrayList<Position>();
	
	public Employee() {
//		this.position = new HashMap<Long, Position>();
		
	}
	
	public Employee(long id) {
		this.id = id;
		
//		this.position = new HashMap<Long, Position>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Position> getPosition() {
		return position;
	}

	public void setPosition(List<Position> position) {
		this.position = position;
	}
}
