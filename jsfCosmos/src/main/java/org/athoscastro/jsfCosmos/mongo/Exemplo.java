package org.athoscastro.jsfCosmos.mongo;

import com.mongodb.*;

public class Exemplo {
	
	private final static String host = "172.17.0.2";
	private final static int port = 27017;

	public static void main(String[] args) {
		try {
			MongoClient mongo = new MongoClient(host, port);
			DB db = mongo.getDB("batata");
			DBCollection coll = db.getCollection("batatinha");
			DBObject doc = new BasicDBObject("nome", "rodrigo")
					.append("idade", "96");
			coll.insert(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
