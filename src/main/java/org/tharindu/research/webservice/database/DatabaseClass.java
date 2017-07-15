package org.tharindu.research.webservice.database;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class DatabaseClass {
	
	private static MongoClient mongoClient;
	private static Morphia morphia;
	private static Datastore datastore;
	
	public static MongoClient getMongoClient() {
		DatabaseClass.mongoClient = new MongoClient( "localhost" , 27017 );
		return mongoClient;
	}
	
	public static Morphia getMorphia() {
		morphia = new Morphia();
		morphia.mapPackage("org.tharindu.reseach.webservice");
		return morphia;
	}
	
	public static Datastore getDatastore() {
		datastore = getMorphia().createDatastore(new MongoClient(), "company");
		datastore.ensureIndexes();
		return datastore;
	}
}
