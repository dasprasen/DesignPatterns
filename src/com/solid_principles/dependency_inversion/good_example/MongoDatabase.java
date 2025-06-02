package com.solid_principles.dependency_inversion.good_example;

public class MongoDatabase implements Database {
    @Override
    public void saveData(String data) {
        System.out.println("Saving data to MongoDB: " + data);
    }
}
