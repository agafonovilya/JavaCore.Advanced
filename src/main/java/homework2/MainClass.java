package homework2;

import homework2.myException.MyArrayDataException;
import homework2.myException.MyArraySizeException;

import java.util.ArrayList;

public class MainClass {

    private static final int CORRECT_ARRAY_SIZE = 4;
    private static final String[][] CORRECT_ARRAY = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
    private static final String[][] INCORRECT_ARRAY_SIZE = {{"1", "2", /*"3",*/ "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
    private static final String[][] INCORRECT_ARRAY_DATA = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"A", "2", "3", "4"}, {"1", "2", "3", "4"}};

    public static void main(String[] args) {

        ArrayList<String[][]> testArrays = new ArrayList<String[][]>(); //Складываем проверяемые массивы в один массив
        testArrays.add(INCORRECT_ARRAY_SIZE);
        testArrays.add(INCORRECT_ARRAY_DATA);
        testArrays.add(CORRECT_ARRAY);

        /*Проходим циклом по тестируемым массивам*/
        for (int i = 0; i < testArrays.size(); i++) {
            try {
                System.out.println("Тест " + (i + 1) );
                testMethod(testArrays.get(i));
            } catch (MyArraySizeException e){
                System.out.println(e.getMessage());
            } catch (MyArrayDataException e){
                System.out.println(e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }

    public static void testMethod(String[][] array) {

        /*Проверяем размер массива*/
        if (array.length != CORRECT_ARRAY_SIZE ) {
            throw new MyArraySizeException("Неверный размер массива");
        } else {
            for (String[] arr: array) {
                if (arr.length != CORRECT_ARRAY_SIZE){
                    throw new MyArraySizeException("Неверный размер массива");
                }
            }
        }

        /*Суммируем элементы массива*/
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println("Сумма элементов массива: " + sum);
    }
}
