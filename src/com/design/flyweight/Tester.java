package com.design.flyweight;

/**
 * @author Prasenjit Kumar Das
 */
public class Tester implements Employee {
    private final String job;
    private String skill;

    public Tester() {
        job = "test the issue";
    }

    @Override
    public void assignSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Tester with skill: " + this.skill + " with job: " + job);
    }
}
