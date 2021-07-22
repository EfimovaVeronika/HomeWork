package ru.geekbrains.java2_lesson1;

public class Cat implements IMoving {
    private final int jumpLimit;
    private final int runLimit;

    public Cat(int jumpLimit, int runLimit) {
        this.jumpLimit = jumpLimit;
        this.runLimit = runLimit;
    }

    @Override
    public boolean jumping(int height) {
        if (height <= jumpLimit) {
            System.out.println("Кот прыгнул на " + height);
            return true;
        }
        else {
            System.out.println("Кот не может прыгнуть так высоко");
            return false;
        }

    }

    @Override
    public boolean running(int dist) {
        if (dist <= runLimit) {
            System.out.println("Кот пробежал " + dist);
            return true;
        }
        else {
            System.out.println("Кот не может столько пробежать");
            return false;
        }

    }
}