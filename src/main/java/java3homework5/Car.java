package java3homework5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private final Race race;
    private final int speed;
    private final String name;
    private final CyclicBarrier ready;
    private final CyclicBarrier finish;

    public Car(Race race, int speed, CyclicBarrier ready, CyclicBarrier finish) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.ready = ready;
        this.finish = finish;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
    
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            ready.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        checkWin();

        try {
            finish.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private void checkWin() {
        if(!MainClass.checkHasWinner()) {
            System.out.println(this.name + " WIN");
        }
    }
}