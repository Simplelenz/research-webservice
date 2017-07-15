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

import org.tharindu.research.webservice.model.Location;
import org.tharindu.research.webservice.service.LocationService;

@Path("locations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LocationResource {
	
	LocationService locService = new LocationService();
	
	@GET
	public List<Location> getLocations() {
		return locService.getAllLocations();
	}
	
	@GET
	@Path("{locationId}")
	public Location getLocation(@PathParam("locationId") long id) {
		return locService.getLocation(id);
	}
	
	@POST
	public Location addLocation(Location location) {
		return locService.addLocation(location);
	}

//	@PUT
//	@Path("{employeeId}")
//	public Employee updateEmployee(@PathParam("employeeId") long id, Employee employee) {
//		employee.setId(id);
//		return empService.updateEmployee(employee);
//	}
//	
	@DELETE
	@Path("{locationId}")
	public Location deleteLocation(@PathParam("locationId") long id) {
		return locService.deleteLocation(id);
	}
	
	@Path("{locationId}/activities")
	public ActivityResource getActivityResource() {
		return new ActivityResource();
	}
}
