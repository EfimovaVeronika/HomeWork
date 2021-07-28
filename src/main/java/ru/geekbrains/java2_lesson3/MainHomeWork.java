package ru.geekbrains.java2_lesson3;

import java.lang.reflect.Array;
import java.util.*;

public class MainHomeWork {
    public static void main(String[] args) {

        //Реализация метода для подсчета повторений слова в массиве строк.
        String[] array = new String[] {"Java", "Привет", "Hello", "Cat", "Dog", "Hi", "Человек", "Hello", "Java", "Cat", "Человек"};

        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (String string : array) {
            set.add(string);

            // Если слово встречается первый раз, то запускаем счетчик.
            // Если совпадение не первое, прибавляем единицу.
            map.put(string, map.getOrDefault(string, 0) + 1);
        }

        System.out.println(set);
        System.out.println(map);



        //Работа с классом phoneBook.
        PhoneBook phoneBook = new PhoneBook();

        Set<String> phoneNumbers = new HashSet<>(Arrays.asList("495-27-17", "495-17-27"));
        phoneBook.add("Иванова", phoneNumbers);
        phoneBook.add("Иванова", new HashSet<>(Arrays.asList("546-790-09", "495-27-17")));
        phoneBook.add("Сидоров", new HashSet<>(Arrays.asList("495-99-03", "495-27-27", "495-65-17")));
        phoneBook.add("Серегин", new HashSet<>(Arrays.asList("495-01-31")));
        phoneBook.add("Антонов", new HashSet<>(Arrays.asList("495-97-14", "678-98-00")));


        phoneBook.get("Иванова");
        phoneBook.get("Серегин");
        phoneBook.get("Антонов");
        phoneBook.get("Бурмистров");

    }
}
