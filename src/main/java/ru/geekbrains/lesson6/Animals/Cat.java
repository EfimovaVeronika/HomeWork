package ru.geekbrains.lesson6.Animals;

public class Cat extends Animal {
    public final static int MAX_RUN_DIST = 200;
    private static int COUNTER = 0;

    public Cat(String name) {
        super(name);
        COUNTER++;
    }

    public static int getCOUNTER() {
        return COUNTER;
    }

    @Override
    public void runForestRun(int distance) {
        if (distance > MAX_RUN_DIST || distance <= Animal.MIN_DIST) {
            System.out.println(super.getName() + " не может столько пробежать!");
        }
        else {
            System.out.println(super.getName() + " пробежал " + distance + " м!");
        }
    }

    @Override
    public void swimForestSwim(int distance) {
        System.out.println(super.getName() + " не может плыть!");
    }
}

