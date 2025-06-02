package com.solid_principles.interface_segregation.good_example;

// Clients should not be forced to depend on interfaces they do not use.
public class Main {
    public static void makeWork(Workable worker) {
        worker.work();
    }

    public static void makeEat(Eatable eater) {
        eater.eat();
    }

    public static void main(String[] args) {
        HumanWorker human = new HumanWorker();
        RobotWorker robot = new RobotWorker();

        makeWork(human);  // Human working...
        makeEat(human);   // Human eating...

        makeWork(robot);  // Robot working...
        // makeEat(robot); // Compile-time error! Robot doesn't eat — perfect!
    }
}
