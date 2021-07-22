package ru.geekbrains.java2_lesson1;

public class Wall extends Obstruction {

    public Wall(int height) {
        super(height);
    }

    @Override
    public boolean overcome(IMoving essence) {
       return essence.jumping(getSize());
    }
}
