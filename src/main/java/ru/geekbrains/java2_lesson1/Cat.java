package ru.geekbrains.java2_lesson1;

public class Cat implements IMoving {
    private final int jumpLimit;
    private final int runLimit;

    public Cat(int jumpLimit, int runLimit) {
        this.jumpLimit = jumpLimit;
        this.runLimit = runLimit;
    }

    @Override
    public int getJumpLimit() {
        return jumpLimit;
    }

    @Override
    public int getRunLimit() {
        return runLimit;
    }

    @Override
    public void jumping() {
        System.out.println("Кот пробежал");
    }

    @Override
    public void running() {
        System.out.println("Кот прыгнул");

    }
}
