package utils;

import actors.Child;
import actors.Cook;
import actors.Person;
import actors.Tutor;
import actors.enums.Tasks;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Timeline {
    private  static Integer currentTick = 0;
    static Cook cook = new Cook();
    static Tutor tutor = new Tutor(List.of(cook));
    static Child child = new Child(tutor);

    private static ScheduledExecutorService timeline = Executors.newSingleThreadScheduledExecutor();

    public static void run() {

        timeline.scheduleAtFixedRate(() -> tickSimulation(), 0, 1, TimeUnit.SECONDS);
    }

    public static void tickSimulation() {
        System.out.println(currentTick);
        currentTick++;
        Integer childSatiety = child.getSatietyBar();
        if (childSatiety < 95) {
            child.doWork(Tasks.GIVE_ME_FOOD);
            timeline.shutdown();
        }
        child.getHungry();
    }
}
