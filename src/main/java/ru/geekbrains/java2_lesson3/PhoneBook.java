package ru.geekbrains.java2_lesson3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Класс PhoneBook создает объект phoneBook, содержащий только поля имени и номеров телефона.
public class PhoneBook {
   private  Map<String, Set<String>> phoneBook;

   public PhoneBook() {
      phoneBook = new HashMap<>();
   }

   // Метод добавляет новый контакт, если не было совпадения по полю имени, либо добавляет номера телефонов,
   // если было совпадение по имени, но не было совпадения по номеру телефона
   public void add(String name, Set<String> newPhoneNumberSet) {
      if (phoneBook.get(name) != null) {
         Set<String> tmpPhoneNumberSet = phoneBook.get(name);
         tmpPhoneNumberSet.addAll(newPhoneNumberSet);
         phoneBook.put(name, tmpPhoneNumberSet);
      }
      else {
         phoneBook.put(name, new HashSet<>(newPhoneNumberSet));
      }
   }

   // Метод возващает номера телефонов контакта по имени контакта. Если совпадений по
   // имени не найдено, возвращает null.
   public Set<String> get(String name) {
      if (phoneBook.get(name) != null) {
         System.out.println(phoneBook.get(name));
         return phoneBook.get(name);

      } else {
         System.out.println("Такой фамилии нет в списке!");
         return null;
      }
   }
}
