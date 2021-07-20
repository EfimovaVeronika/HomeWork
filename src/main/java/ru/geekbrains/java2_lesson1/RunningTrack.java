package ru.geekbrains.java2_lesson1;

public class RunningTrack extends Obstruction {

    public RunningTrack(int length) {
        super(length);
    }

    @Override
    public boolean overcome(IMoving essence) {
        if (getSize() <= essence.getRunLimit()) {
            essence.jumping();

            return true;
        }
        else {

            return false;
        }

    }
}
