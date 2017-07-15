package org.tharindu.research.webservice.service;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.tharindu.research.webservice.database.DatabaseClass;
import org.tharindu.research.webservice.model.Employee;
import org.tharindu.research.webservice.model.Position;

public class PositionService {

	static Datastore datastore = DatabaseClass.getDatastore();
	
	public List<Position> getAllPositions(long employeeId) {
		Query<Employee> query = datastore.createQuery(Employee.class)
				.field("id").equal(employeeId);
		Employee employee = query.project("position", true).get();
		List<Position> positions = employee.getPosition();
		return positions;
	}
	
	public Position addPosition(long employeeId, Position position) { 
		Query<Employee> query = datastore.createQuery(Employee.class)
				.field("id").equal(employeeId);
		UpdateOperations<Employee> updateOperations = datastore.createUpdateOperations(Employee.class)
                .push("position", position);
		datastore.update(query, updateOperations);
		return position;
	}

	public Position getCurrentPositon(long employeeId) {
		Query<Employee> query = datastore.createQuery(Employee.class)
				.field("id").equal(employeeId);
		Employee employee = query.project("position", true).get();
		Position position = employee.getPosition().get(employee.getPosition().size()-1);
		return position;
	}
	
	public Position deletePosition(long employeeId) {
		Query<Employee> query = datastore.createQuery(Employee.class)
				.field("id").equal(employeeId);
		Employee employee = query.project("position", true).get();
		Position position = employee.getPosition().get(employee.getPosition().size()-1);
		UpdateOperations<Employee> updateOperations = datastore.createUpdateOperations(Employee.class)
                .removeLast("position");
		datastore.update(query, updateOperations);
		return position;
	}
	
	public List<Position> deleteAllPositions(long employeeId) {
		Query<Employee> query = datastore.createQuery(Employee.class)
				.field("id").equal(employeeId);
		Employee employee = query.project("position", true).get();
		List<Position> positions = employee.getPosition();
		UpdateOperations<Employee> updateOperations = datastore.createUpdateOperations(Employee.class)
                .removeAll("position", positions);
		datastore.update(query, updateOperations);
		return positions;
	}
}
