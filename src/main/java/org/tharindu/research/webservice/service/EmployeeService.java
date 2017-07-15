package org.tharindu.research.webservice.service;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.tharindu.research.webservice.database.DatabaseClass;
import org.tharindu.research.webservice.model.Employee;

public class EmployeeService {

	static Datastore datastore = DatabaseClass.getDatastore();
	
	public Employee addEmployee(Employee employee) {
		datastore.save(employee);
		return employee;
	}
	
	public List<Employee> getAllEmployees() {
		Query<Employee> query = datastore.createQuery(Employee.class);
		List<Employee> employees = query.asList();
		return employees;
	}
	
	public Employee getEmployee(long id) {
		Query<Employee> query = datastore.createQuery(Employee.class)
				.field("id").equal(id);
		Employee employee = query.get();
		return employee;
	}
	
	public Employee deleteEmployee(long id) {
		Query<Employee> deleteQuery = datastore.createQuery(Employee.class)
				.field("id").equal(id);
		Employee employee = deleteQuery.get();
		datastore.delete(deleteQuery);
		return employee;
	}
}
