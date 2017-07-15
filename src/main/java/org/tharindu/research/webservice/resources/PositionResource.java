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

import org.tharindu.research.webservice.model.Position;
import org.tharindu.research.webservice.service.PositionService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PositionResource {
	
	PositionService positionService = new PositionService();
	
	@GET
	public List<Position> getEmployeePositions(@PathParam("employeeId") long id) {
		return positionService.getAllPositions(id);
	}
	
	@GET
	@Path("position")
	public Position getCurrentPosition(@PathParam("employeeId") long id) {
		return positionService.getCurrentPositon(id);
	}
	
	@POST
	@Path("position")
	public Position addCurrentPosition(@PathParam("employeeId") long id, Position position) {
		return positionService.addPosition(id, position);
	}
	
	@DELETE
	@Path("position")
	public Position deleteEmployeePosition(@PathParam("employeeId") long id) {
		return positionService.deletePosition(id);
	}

	@DELETE
	public List<Position> deleteEmployeePositions(@PathParam("employeeId") long id) {
		return positionService.deleteAllPositions(id);
	}
}
