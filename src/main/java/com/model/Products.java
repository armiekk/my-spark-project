package com.model;

/**
 * Created by ARM on 4/12/2558.
 */


import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Products {
    private MongoDatabase getDatabase() throws ClassNotFoundException {
        MongoClientURI connectionString = new MongoClientURI("mongodb://armst0910:1234@ds041924.mongolab.com:41924/stationary");
        MongoClient mongoClient = new MongoClient(connectionString);
        MongoDatabase database = mongoClient.getDatabase("stationary");
        return database;
    }

    public List<Document> getAll(){
        List<Document> ret = new ArrayList<>();
        try {
            MongoDatabase db = getDatabase();
            MongoCollection<Document> collection = db.getCollection("product");
            MongoCursor<Document> cursor = collection.find().iterator();

            while (cursor.hasNext()){
                ret.add(cursor.next());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
