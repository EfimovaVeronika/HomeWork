package ru.geekbrains.java2_lesson1;

public class Robot implements IMoving {
    private final int jumpLimit;
    private final int runLimit;

    public Robot(int jumpLimit, int runLimit) {
        this.jumpLimit = jumpLimit;
        this.runLimit = runLimit;
    }

    @Override
    public boolean jumping(int height) {
        if (height <= jumpLimit) {
            System.out.println("Робот прыгнул на " + height);
            return true;
        }
        else {
            System.out.println("Робот не может прыгнуть так высоко");
            return false;
        }

    }

    @Override
    public boolean running(int dist) {
        if (dist <= runLimit) {
            System.out.println("Робот пробежал " + dist);
            return true;
        }
        else {
            System.out.println("Робот не может столько пробежать");
            return false;
        }

    }
}