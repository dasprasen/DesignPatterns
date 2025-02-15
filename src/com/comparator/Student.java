package com.comparator;

public class Student {

    int rollNum;
    int age;
    String name;

    public int getRollNum() {
        return rollNum;
    }

    public void setRollNum(int rollNum) {
        this.rollNum = rollNum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(int rollNum, int age, String name) {
        this.rollNum = rollNum;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNum=" + rollNum +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

}
