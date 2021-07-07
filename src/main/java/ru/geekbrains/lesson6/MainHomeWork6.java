package ru.geekbrains.lesson6;


import ru.geekbrains.lesson6.Animals.*;

public class MainHomeWork6 {
    public static void main(String[] args) {


        Cat cat = new Cat("Бaрсик");
        cat.runForestRun(30);
        cat.swimForestSwim(50);

        Dog dog = new Dog("Шарик");
        dog.runForestRun(900);
        dog.swimForestSwim(9);

        System.out.println(Cat.getCOUNTER());
        System.out.println(Dog.getCOUNTER());
        System.out.println(Animal.getCOUNTER());

    }
}
