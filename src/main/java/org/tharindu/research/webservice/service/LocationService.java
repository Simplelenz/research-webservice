package org.tharindu.research.webservice.service;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.tharindu.research.webservice.database.DatabaseClass;
import org.tharindu.research.webservice.model.Location;

public class LocationService {
	
	static Datastore datastore = DatabaseClass.getDatastore();
	
	public List<Location> getAllLocations() {
		Query<Location> query = datastore.createQuery(Location.class);
		List<Location> locations = query.asList();
		return locations;
	}
	
	public Location getLocation(long id) {
		Query<Location> query = datastore.createQuery(Location.class)
				.field("id").equal(id);
		Location location = query.get();
		return location;
	}
	
	public Location addLocation(Location location) {
		datastore.save(location);
		return location;
	}
	
	public Location deleteLocation(long id) {
		Query<Location> deleteQuery = datastore.createQuery(Location.class)
				.field("id").equal(id);
		Location location = deleteQuery.get();
		datastore.delete(deleteQuery);
		return location;
	}

}
