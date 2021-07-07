package ru.geekbrains.lesson6.Animals;

public abstract class Animal {
    public final static int MIN_DIST = 0;
    private static int COUNTER = 0;

    private final String name;

    public Animal (String name) {
        this.name = name;
        COUNTER++;
    }

    public static int getCOUNTER() {
        return COUNTER;
    }

    public String getName() {
        return name;
    }

    public abstract void runForestRun(int distance);

    public abstract void swimForestSwim(int distance);
}
