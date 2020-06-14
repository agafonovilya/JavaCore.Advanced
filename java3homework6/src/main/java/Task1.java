//  *Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
//  *Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
//  идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
//  иначе в методе необходимо выбросить RuntimeException.
//  *Написать набор тестов для этого метода (по 3-4 варианта входных данных).
//  *Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

public class Task1 {
    //private final static int[] ARRAY = {1,2,4,4,2,3,4,1,7};


    public int[] elementsOfArrayAfterFour(int[] initialArray){
        int indexOfLastFour = -1;
        for (int i = 0; i < initialArray.length; i++) {
            if (initialArray[i] == 4) {
                indexOfLastFour = i;
            }
        }

        if(indexOfLastFour != -1) {
            int[] resultArray = new int[(initialArray.length - 1 - indexOfLastFour)];
            System.arraycopy(initialArray, indexOfLastFour+1, resultArray, 0, (initialArray.length - 1 - indexOfLastFour) );
            return resultArray;
        } else {
            throw new RuntimeException();
        }
    }
}
