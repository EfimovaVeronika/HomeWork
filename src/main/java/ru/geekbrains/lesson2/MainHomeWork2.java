package ru.geekbrains.lesson2;

public class MainHomeWork2 {
    public static void main(String[] args) {

        System.out.println(checkSumLimits(10, 2, 10, 20));
        System.out.println(checkSumLimits(6, -8, 10, 20));
        System.out.println(checkSumLimits(-30, 19, 10, 20));

        checkNumberSign(3);
        checkNumberSign(-2);
        checkNumberSign(0);

        System.out.println(checkNegative(2));
        System.out.println(checkNegative(0));
        System.out.println(checkNegative(-3));

        repeatString("Java", 5);
        repeatString("Hello", 3);
        repeatString("Dzhigurda", 5);


        for (int i = 1800; i < 2021; i++) {
            if (checkLeapYear(i)) {
                System.out.println(i);
            }
        }


    }

    public static boolean checkSumLimits(int number1, int number2, int lowerLimit, int upperLimit) {
        return number1 + number2 >= lowerLimit && number1 + number2 <= upperLimit;
    }

    public static void checkNumberSign(int number) {
        if (number >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }

    public static boolean checkNegative(int number) {
        return number < 0;
    }

    public static void repeatString(String string, int number) {
        for (int i = 0; i < number; i++) {
            System.out.println(string);
        }
    }

    public static boolean checkLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }
}
