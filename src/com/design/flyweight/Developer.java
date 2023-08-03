package com.design.flyweight;

/**
 * @author Prasenjit Kumar Das
 */
public class Developer implements Employee {
    private final String job;
    private String skill;

    public Developer() {
        job = "fix the issue";
    }

    @Override
    public void assignSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Developer with skill: " + this.skill + " with job: " + job);
    }
}
