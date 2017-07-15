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

import org.tharindu.research.webservice.model.Activity;
import org.tharindu.research.webservice.service.ActivityService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ActivityResource {

ActivityService activityService = new ActivityService();
	
	@GET
	public List<Activity> getlocationActivities(@PathParam("locationId") long id) {
		return activityService.getAllActivities(id);
	}
	
//	@GET
//	@Path("activity")
//	public Activity getCurrentActivity(@PathParam("locationId") long id) {
//		return activityService.getCurrentActivity(id);
//	}
	
	@POST
	@Path("activity")
	public Activity addCurrentActivity(@PathParam("locationId") long id, Activity activity) {
		return activityService.addActivity(id, activity);
	}
	
	@DELETE
	@Path("activity")
	public Activity deletelocationActivity(@PathParam("locationId") long id) {
		return activityService.deleteActivity(id);
	}

	@DELETE
	public List<Activity> deletelocationActivities(@PathParam("locationId") long id) {
		return activityService.deleteAllActivities(id);
	}
}
