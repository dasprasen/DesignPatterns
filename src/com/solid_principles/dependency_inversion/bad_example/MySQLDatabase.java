package com.solid_principles.dependency_inversion.bad_example;

public class MySQLDatabase {
    public void saveData(String data) {
        System.out.println("Saving data to MySQL: " + data);
    }
}
