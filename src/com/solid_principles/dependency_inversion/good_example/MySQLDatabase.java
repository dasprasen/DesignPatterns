package com.solid_principles.dependency_inversion.good_example;

public class MySQLDatabase implements Database {
    @Override
    public void saveData(String data) {
        System.out.println("Saving data to MySQL: " + data);
    }
}
