package ru.geekbrains.java2_lesson1;

public class Man implements IMoving {
    private final int jumpLimit;
    private final int runLimit;

    public Man(int jumpLimit, int runLimit) {
        this.jumpLimit = jumpLimit;
        this.runLimit = runLimit;
    }

    @Override
    public boolean jumping(int height) {
         if (height <= jumpLimit) {
            System.out.println("Человек прыгнул на " + height);
            return true;
        }
        else {
            System.out.println("Человек не может прыгнуть так высоко");
            return false;
        }
    }

    @Override
    public boolean running(int dist) {
        if (dist <= runLimit) {
            System.out.println("Человек пробежал " + dist);
            return true;
        }
        else {
            System.out.println("Человек не может столько пробежать");
            return false;
        }

    }
}
