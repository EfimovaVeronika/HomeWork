package ru.geekbrains.java2_lesson1;

public class MainHomeWork {
    public static void main(String[] args) {

        IMoving[] essences = {new Man(2, 500),
                new Cat(2, 500),
                new Robot(2, 500)};

        Obstruction[] obstructions = {new Wall(2),
                new RunningTrack(300),
                new RunningTrack(700)};


        for (IMoving essence : essences) {

            for (Obstruction obstruction : obstructions) {

                if (!(obstruction.overcome(essence))) {

                    break;

                }
            }
        }
    }
}


