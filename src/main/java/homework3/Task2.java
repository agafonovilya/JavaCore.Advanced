package homework3;

import java.util.Map;
import java.util.TreeMap;

public class Task2 {
    public static void main(String[] args) {
        Map<String, String> phonebook = new TreeMap<String, String>(); //Создаем коллекцию

        addContact(phonebook, "Ivanov", "111-111"); //Добавляем абонента
        addContact(phonebook, "Ivanov", "222-222"); //Добавляем абонента
        addContact(phonebook, "Petrov", "333-333"); //Добавляем абонента
        addContact(phonebook, "Kirillov", "444-444"); //Добавляем абонента
        getContact(phonebook,"Ivanov"); //Запрашиваем номер телефона абонента
        System.out.println(phonebook);

    }

    /**
     * Метод добавляет нового абонента в телефонную книгу
     * @param phonebook - телефонная книга
     * @param newSurname - Фамилия абонента
     * @param newPhoneNumber - Номер телефона абонента
     */
    public static void addContact(Map<String, String> phonebook, String newSurname, String newPhoneNumber){

        if (phonebook.containsKey(newSurname)) { //Если книга уже содержит абонента с такой фамилией, то добавляем телефонный номер
            phonebook.put(newSurname, (phonebook.get(newSurname) + ", " + newPhoneNumber) );
        } else {    //Если не содержит, то добавлем абонента
            phonebook.put(newSurname, newPhoneNumber);
        }
    }

    /**
     * Метод выводит в консоль данные абонента
     * @param phonebook - телефонная книга
     * @param surname - Фамилия
     */
    public static void getContact(Map<String, String> phonebook, String surname){
        System.out.println(surname + " " + phonebook.get(surname));
    }
}
