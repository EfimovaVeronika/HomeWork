package ru.geekbrains.java2_lesson2;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {

    private final int arraySize;


    public MyArraySizeException(int arraySize) {
        super("Размер массива не соответствует " + arraySize + " * " + arraySize);
        this.arraySize = arraySize;
    }

    public int getArraySize() {
        return arraySize;
    }
}
