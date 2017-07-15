package org.tharindu.research.webservice.service;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.tharindu.research.webservice.database.DatabaseClass;
import org.tharindu.research.webservice.model.Location;
import org.tharindu.research.webservice.model.Activity;

public class ActivityService {

static Datastore datastore = DatabaseClass.getDatastore();
	
	public List<Activity> getAllActivities(long locationId) {
		Query<Location> query = datastore.createQuery(Location.class)
				.field("id").equal(locationId);
		Location location = query.project("activity", true).get();
		List<Activity> activities = location.getActivity();
		return activities;
	}
	
	public Activity addActivity(long locationId, Activity activity) { 
		Query<Location> query = datastore.createQuery(Location.class)
				.field("id").equal(locationId);
		UpdateOperations<Location> updateOperations = datastore.createUpdateOperations(Location.class)
                .push("activity", activity);
		datastore.update(query, updateOperations);
		return activity;
	}

//	public Activity getCurrentActivity(long locationId) {
//		Query<Location> query = datastore.createQuery(Location.class)
//				.field("id").equal(locationId);
//		Location location = query.project("activity", true).get();
//		Activity activity = location.getActivity().get(location.getActivity().size()-1);
//		return activity;
//	}
	
	public Activity deleteActivity(long locationId) {
		Query<Location> query = datastore.createQuery(Location.class)
				.field("id").equal(locationId);
		Location location = query.project("activity", true).get();
		Activity activity = location.getActivity().get(location.getActivity().size()-1);
		UpdateOperations<Location> updateOperations = datastore.createUpdateOperations(Location.class)
                .removeLast("activity");
		datastore.update(query, updateOperations);
		return activity;
	}
	
	public List<Activity> deleteAllActivities(long locationId) {
		Query<Location> query = datastore.createQuery(Location.class)
				.field("id").equal(locationId);
		Location location = query.project("activity", true).get();
		List<Activity> activities = location.getActivity();
		UpdateOperations<Location> updateOperations = datastore.createUpdateOperations(Location.class)
                .removeAll("activity", activities);
		datastore.update(query, updateOperations);
		return activities;
	}
}
