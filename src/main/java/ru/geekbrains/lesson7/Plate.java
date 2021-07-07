package ru.geekbrains.lesson7;

public class Plate {
    private int food = 0;
    private final int size;

    public Plate(int food, int size) {
        this.size = size;
        if (food >= 0 && food <= this.size) {
            this.food = food;
        }
        else {
            System.out.println("Количество еды не может быть отрицательным! Тарелка пуста");
        }

    }

    public int getSize() {
        return size;
    }

    public boolean checkEmpty() {
        return food == 0;
    }

    public int decreaseFood(int appetite) {
        if (appetite <= food) {
            food -= appetite;
            return appetite;
        }
        else {
            int catEat = food;
            food = 0;
            return catEat;
        }
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public void addFood(int newFood) {
        if (newFood > 0 && food + newFood <= size) {
            food += newFood;
        }
        System.out.println(food + " стало еды в тарелке");
    }
}


