package org.tharindu.research.webservice.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.tharindu.research.webservice.model.Employee;
import org.tharindu.research.webservice.service.EmployeeService;

@Path("employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {

	EmployeeService empService = new EmployeeService();
	
	@GET
	public List<Employee> getEmployees() {
		return empService.getAllEmployees();
	}
	
	@GET
	@Path("{employeeId}")
	public Employee getEmployee(@PathParam("employeeId") long id) {
		return empService.getEmployee(id);
	}
	
	@POST
	public Employee addEmployee(Employee employee) {
		return empService.addEmployee(employee);
	}

//	@PUT
//	@Path("{employeeId}")
//	public Employee updateEmployee(@PathParam("employeeId") long id, Employee employee) {
//		employee.setId(id);
//		return empService.updateEmployee(employee);
//	}
//	
	@DELETE
	@Path("{employeeId}")
	public Employee deleteEmployee(@PathParam("employeeId") long id) {
		return empService.deleteEmployee(id);
	}
	
	@Path("{employeeId}/positions")
	public PositionResource getPositionResource() {
		return new PositionResource();
	}
}
