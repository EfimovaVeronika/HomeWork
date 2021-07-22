package ru.geekbrains.java2_lesson2;

public class MyArrayDataException extends NumberFormatException {
    private final int lineNumber;
    private final int columnNumber;


    public MyArrayDataException(int lineNumber, int columnNumber) {
        super("Ошибка конвертации в ячейке массива " + lineNumber + " ," + columnNumber);
        this.lineNumber = lineNumber;
        this.columnNumber = columnNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

}
