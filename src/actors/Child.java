package actors;

import actors.enums.Tasks;

public class Child extends Person {
    private final Tutor itsTutor;

    public Child(Tutor itsTutor) {
        this.itsTutor = itsTutor;
    }

    @Override
    public void doWork(Tasks task) {
        super.doWork(task);
        Person.giveATask(Tasks.GIVE_ME_FOOD, this, itsTutor);
    }
}
