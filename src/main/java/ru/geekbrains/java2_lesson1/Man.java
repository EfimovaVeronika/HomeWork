package ru.geekbrains.java2_lesson1;

public class Man implements IMoving {
    private final int jumpLimit;
    private final int runLimit;

    public Man(int jumpLimit, int runLimit) {
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
        System.out.println("Человек пробежал");

    }

    @Override
    public void running() {
        System.out.println("Человек прыгнул");

    }
}
