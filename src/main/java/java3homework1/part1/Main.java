// 1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа).
// 2. Написать метод, который преобразует массив в ArrayList.
package java3homework1.part1;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1,2,3};
        String[] arr1 = new String[]{"a", "b", "c"};

        /*Меняем местами элементы массива*/
        Integer[] arr2 = arrayElementChanger(arr, 1,2);
        for (Integer a: arr2) {
            System.out.print(a);
        }
        System.out.println();

        /*Преобразуем массив в ArrayList*/
        ArrayList<String> stringArrayList;
        stringArrayList = arrayToArrayList(arr1);
        for (String a: stringArrayList) {
             System.out.print(a);
        }
    }

    static <T> T[] arrayElementChanger(T[] arr,int firstIndex, int secondIndex){
        T temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
        return arr;
    }

    static <T> ArrayList<T> arrayToArrayList(T[] arr){
        ArrayList<T> array = new ArrayList<T>();
        Collections.addAll(array, arr);
        return array;
    }

}
