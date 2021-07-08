package ru.geekbrains.lesson7;

import java.util.Random;

public class MainHomeWork7 {
    public static void main(String[] args) {
        Random rand = new Random();

        Plate plate = new Plate(20, 50);
        Cat[] cats =  {
                new Cat("Barsik", 10),
                new Cat("Tom", 5),
                new Cat("Timka", 15),
                new Cat("Rizik", 3),
                new Cat("Pushistik", 7),
                new Cat("Leopold", 0),
                new Cat("Matroskin", 50)} ;

        plate.info();

        int satietyCatCount = 0;
        while (satietyCatCount < cats.length) {
            satietyCatCount = 0;

            for (Cat cat : cats) {
                if (cat.checkSatiety()) {
                    System.out.println(cat.getName() + " не голоден");
                    satietyCatCount++;

                    continue;
                }
                else {
                    System.out.println(cat.getName() + " голоден");
                }

                if (plate.checkEmpty()) {
                    plate.addFood(rand.nextInt(plate.getSize()));
                }

                cat.eat(plate);
                System.out.println(cat.getName() + " поел");

                if (cat.checkSatiety()) {
                    satietyCatCount++;

                    System.out.println(cat.getName() + " теперь не голоден");
                }
                else {
                    System.out.println(cat.getName() + " все еще голоден!");
                }
            }

            System.out.println();
        }
    }
}
