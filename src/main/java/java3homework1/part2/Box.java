package java3homework1.part2;


import java.util.ArrayList;
import java.util.Arrays;

public class Box <E extends Fruit>{

    private ArrayList<E> box = new ArrayList<>(new ArrayList<>());

    public Box(ArrayList<E> fruits) {
        this.box.addAll(fruits);
    }

    public Box(E... fruits) {
        this.box.addAll(Arrays.asList(fruits));
    }

    public void add(E fruit) {
        box.add(fruit);
    }

    public void moveAllTo(Box<E> anotherBox) {
        for (E fruit : box) {
            anotherBox.add(fruit);
        }

        box.clear();
    }

    public boolean compareTo(Box<?> anotherBox) {
       return this.getWeight() == anotherBox.getWeight();
    }

    public double getWeight() {
        double sum = 0.0;
        for (E fruit : box) {
            sum += fruit.getWeight();
        }
        return sum;
    }

}
