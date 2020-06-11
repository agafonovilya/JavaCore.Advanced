package java3homework5;

import java.util.concurrent.CyclicBarrier;

public class MainClass {
    public static final int CARS_COUNT = 4;
    private static boolean hasWinner = false;

    public static void main(String[] args) {
        CyclicBarrier ready = new CyclicBarrier(CARS_COUNT, () -> System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!"));
        CyclicBarrier finish = new CyclicBarrier(CARS_COUNT, () -> System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!"));

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), ready, finish);
        }

        for (Car car : cars) {
            new Thread(car).start();
        }
    }

    public static synchronized boolean checkHasWinner(){
        if(!hasWinner){
            hasWinner = true;
            return false;
        }
        return true;
    }

}




