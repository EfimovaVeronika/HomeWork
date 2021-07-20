package ru.geekbrains.java2_lesson1;

public abstract class Obstruction {
    private final int size;

    public Obstruction(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public abstract boolean overcome(IMoving essence);
}
