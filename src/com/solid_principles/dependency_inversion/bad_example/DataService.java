package com.solid_principles.dependency_inversion.bad_example;

// Here, DataService (high-level module) directly depends on MySQLDatabase (low-level module).
// If you want to switch to PostgreSQL or MongoDB, you need to modify DataService.
public class DataService {
    private MySQLDatabase database;

    public DataService() {
        this.database = new MySQLDatabase();
    }

    public void save(String data) {
        database.saveData(data);
    }
}
