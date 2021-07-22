package ru.geekbrains.java2_lesson1;

public class RunningTrack extends Obstruction {

    public RunningTrack(int length) {
        super(length);
    }

    @Override
    public boolean overcome(IMoving essence) {
         return essence.running(getSize());

    }
}

