package ru.geekbrains.lesson7;

public class Cat {
    private final String name;
    private int appetite = 0;


    public Cat(String name, int appetite) {
        this.name = name;
        if (appetite >= 0) {
            this.appetite = appetite;
        }
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean checkSatiety() {
        return appetite == 0;
    }

    public void eat(Plate plate) {
        appetite -= plate.decreaseFood(appetite);
    }
}
