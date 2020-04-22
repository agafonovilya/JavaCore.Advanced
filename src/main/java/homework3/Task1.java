package homework3;

import java.util.LinkedHashMap;
import java.util.Map;

public class Task1 {

    public static final String[] ORIGINAL_ARRAY = new String[]{"a","b","c","d","e","f","g","h","i","j","k","a","a","b","c"}; //Исходный массив

    public static void main(String[] args) {

        Map<String, Integer> analiseResult = new LinkedHashMap<String, Integer>(); //Создаем коллекцию для подсчета дубликатов

        for (String element: ORIGINAL_ARRAY) {
            Integer quantity = analiseResult.get(element); //Запрашиваем значение по ключу, даже если этого ключа нет в коллекции

            if (quantity == null){ // Если ключа нет, то возвращается значение null.
                quantity = 0;   // Заменяем null на 0.
            }

            analiseResult.put(element, ++quantity); // Складываем в ячейку новое значение количества
        }

        System.out.println(analiseResult); //Печатаем результат


    }
}
