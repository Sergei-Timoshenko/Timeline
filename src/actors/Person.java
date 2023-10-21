package actors;

import actors.enums.Tasks;

public class Person {
    Integer satietyBar = 100;
    Integer tirednessBar = 0;

    public void eat() {

    }

    public Integer getSatietyBar() {
        return satietyBar;
    }

    public Integer getTirednessBar() {
        return tirednessBar;
    }

    public void getTired() {
        tirednessBar += 1;
    }

    public void getHungry() {
        satietyBar -= 1;
    }


    public void doWork(Tasks task) {
        System.out.println("Working");
    }

    private static <T extends Person> void getATask(Tasks task, T receiver) {
        System.out.println("Task received by " + receiver.getClass().getName());
        receiver.doWork(task);
    }


    public static <T extends Person> void giveATask(Tasks task, T sender, T receiver) {
        System.out.println("Task sent by " + sender.getClass().getName() + " to " + receiver.getClass().getName());
        Person.getATask(task, receiver);
    }
}
