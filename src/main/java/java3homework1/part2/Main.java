// 1. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
// 2. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
//      поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
// 3. Для хранения фруктов внутри коробки можно использовать ArrayList;
// 4. Сделать метод getWeight(), который высчитывает вес коробки.
//      Задать вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
// 5. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
//      которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
//      Можно сравнивать коробки с яблоками и апельсинами;
// 6. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
//      Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
//      Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
// 7. Не забываем про метод добавления фрукта в коробку.

package java3homework1.part2;

public class Main {
        public static void main(String[] args) {

                Box<Apple> appleBox = new Box<>();
                appleBox.add(new Apple());
                appleBox.add(new Apple());
                appleBox.add(new Apple());


                Box<Apple> appleBox2 = new Box<>();
                appleBox2.add(new Apple());

                Box<Orange> orangeBox = new Box<>();
                orangeBox.add(new Orange());
                orangeBox.add(new Orange());

                System.out.println("Box weight:");
                System.out.println("appleBox weight is " + appleBox.getWeight());
                System.out.println("appleBox2 weight is " + appleBox2.getWeight());
                System.out.println("orangeBox weight is " + orangeBox.getWeight());

                System.out.println();
                System.out.println("Compare box weight:");
                System.out.println("Compare apples and apples2: " + appleBox.compareTo(appleBox2));
                System.out.println("Compare oranges and apples: " + appleBox.compareTo(orangeBox));
                System.out.println("Compare oranges and apples2: " + appleBox2.compareTo(orangeBox));


                appleBox.moveAllTo(appleBox2);
                System.out.println();
                System.out.println("Box weight after moving:");
                System.out.println("appleBox weight is " + appleBox.getWeight());
                System.out.println("appleBox2 weight is " + appleBox2.getWeight());

        }
}
