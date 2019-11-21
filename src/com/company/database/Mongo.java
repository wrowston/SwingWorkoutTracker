package com.company.database;

import com.company.domain.ExerciseList;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Mongo {

    private String uri;
    private MongoClientURI clientURI;
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> collection;

    public Mongo() {
        this.uri = "mongodb+srv://Rowston:NfB2014!@cluster0-mgb11.mongodb.net/test";
        this.clientURI = new MongoClientURI(this.uri);
        this.mongoClient = new MongoClient(this.clientURI);
        this.mongoDatabase = mongoClient.getDatabase("WorkoutTracker");
        this.collection = mongoDatabase.getCollection("Workouts");
    }

    public void addToDatabase(String date, ExerciseList el) {
        List<String> exerciseList = el.getExerciseList();

        Document document = new Document("Date", date);

        for (int i = 0; i < exerciseList.size(); i++) {
            int exerciseNumber = i + 1;
            document.append("Exercise Number " + exerciseNumber, exerciseList.get(i));
        }

        collection.insertOne(document);
    }

    public String searchByDate(String text) {
        List<Document> documents = collection.find().into(new ArrayList<>());
        StringBuilder docInfo = new StringBuilder();

        for(Document document : documents){
            if (document.containsValue(text)) {
                docInfo.append(printFoundWorkout(document));
            }
        }
        return docInfo.toString();
    }

    public String showAll() {
        List<Document> documents = collection.find().into(new ArrayList<>());
        StringBuilder docInfo = new StringBuilder();

        for (Document document : documents) {
            docInfo.append(printFoundWorkout(document));
        }
        return docInfo.toString();
    }

    public String printFoundWorkout(Document document) {
        StringBuilder docInfo = new StringBuilder();

        for (String key : document.keySet()) {
            docInfo.append(key).append(": ").append(document.get(key).toString()).append("\n");
        }
        return docInfo.toString();
    }
}
