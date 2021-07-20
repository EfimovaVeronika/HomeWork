package ru.geekbrains.java2_lesson1;

public class Robot implements IMoving {
    private final int jumpLimit;
    private final int runLimit;

    public Robot(int jumpLimit, int runLimit) {
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
        System.out.println("Робот пробежал");
    }

    @Override
    public void running() {
        System.out.println("Робот прыгнул");

    }
}
