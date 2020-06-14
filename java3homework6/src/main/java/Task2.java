//  Написать метод, который проверяет состав массива из чисел 1 и 4.
//  Если в нем нет хоть одной четверки или единицы, то метод вернет false;
//  Написать набор тестов для этого метода (по 3-4 варианта входных данных).
//  [ 1 1 1 4 4 1 4 4 ] -> true
//  [ 1 1 1 1 1 1 ] -> false
//  [ 4 4 4 4 ] -> false
//  [ 1 4 4 1 1 4 3 ] -> false



public class Task2 {

    public boolean hasOneOrFour(int[] initialArray) {
        boolean findOne = false;
        boolean findFour = false;
        for (int a : initialArray) {
            switch (a) {
                case 1: {
                    findOne = true;
                    break;
                }
                case 4: {
                    findFour = true;
                    break;
                }
                default:
                    return false;
            }
        }

        return findFour&&findOne;
    }



}
