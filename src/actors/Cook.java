package actors;

import actors.enums.Tasks;

import java.util.List;

public class Cook extends Person{
    @Override
    public void doWork(Tasks task) {
        super.doWork(task);
        System.out.println("Cooking");
    }
}
