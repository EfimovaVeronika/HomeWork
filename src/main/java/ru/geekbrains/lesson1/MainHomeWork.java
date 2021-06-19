package ru.geekbrains.lesson1;

import java.awt.*;

public class MainHomeWork {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        Numbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");

    }

    public static void checkSumSign() {
        int a = 3;
        int b = -8;
        int c = a + b;

        if (c >= 0) {
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
    }


    public static void printColor() {
        int value = 8;

        if (value <= 0) {
            System.out.println("Красный");
        }
        if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        }
        if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    public static void Numbers() {
        int a = 9;
        int b = 11;

        if (a >= b) {
            System.out.println(a + " >= " +  b);
        }
        else {
            System.out.println(a + " < " + b);
        }
    }
}

