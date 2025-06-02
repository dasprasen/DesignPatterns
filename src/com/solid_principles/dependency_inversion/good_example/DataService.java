package com.solid_principles.dependency_inversion.good_example;

// DataService depends on the Database abstraction.
// You can pass in any implementation (MySQL, Mongo, PostgreSQL, etc.) without changing DataService.
public class DataService {
    private Database database;

    public DataService(Database database) {
        this.database = database;
    }

    public void save(String data) {
        database.saveData(data);
    }
}
