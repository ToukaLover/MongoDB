package org.example.Conexion;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Conexion {

    private static final MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    private static final MongoDatabase mongoDatabase =mongoClient.getDatabase("BaseDeDatos");

    public static MongoDatabase getMongoDatabase() {
        return mongoDatabase;
    }
}
