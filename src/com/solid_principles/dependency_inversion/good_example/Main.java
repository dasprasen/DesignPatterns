package com.solid_principles.dependency_inversion.good_example;

public class Main {
    public static void main(String[] args) {
        Database mysql = new MySQLDatabase();
        Database mongo = new MongoDatabase();

        DataService service1 = new DataService(mysql);
        service1.save("User data");  // Saving to MySQL

        DataService service2 = new DataService(mongo);
        service2.save("Analytics data");  // Saving to MongoDB
    }
}
