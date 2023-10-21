package actors;

import actors.enums.Tasks;

import java.util.List;

public class Tutor extends Person {
    private final List<Person> coworkers;

    public Tutor(List<Person> coworkers) {
        this.coworkers = coworkers;
    }


    @Override
    public void doWork(Tasks task) {
        super.doWork(task);
        if (task == Tasks.GIVE_ME_FOOD) {
            Cook cook = (Cook) coworkers.stream().filter(coworker -> coworker.getClass() == Cook.class).toList().get(0);
            Person.giveATask(Tasks.COOK_SOMETHING, this, cook);
        }
    }
}
