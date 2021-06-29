package ru.geekbrains.lesson3;

import java.util.Arrays;
import java.util.Random;

public class MainHomeWork3 {
    public static void main(String[] args) {
        invertArrayValue();
        fillArray();
        multiplicationArrayElements();
        fillArrayDiagonal();
        fillArrayVariable(5, 6);
        findMinimumElement();
        findMaxElement();

        int[] array78 = new int[5];
        Random rend = new Random();
        for (int i = 0; i < array78.length; i++) {
            array78[i] = rend.nextInt(5) - 2;
        }

        sumArray(array78);

        int number8 = rend.nextInt(5) - 2;

        shiftArray(array78, number8);
    }

    public static void invertArrayValue() {
        int[] invertArray = new int[10];
        Random rend = new Random();
        for (int i = 0; i < invertArray.length; i++) {
            invertArray[i] = rend.nextInt(2);
        }
        System.out.println(Arrays.toString(invertArray));

        for (int i = 0; i < invertArray.length; i++) {
            if (invertArray[i] == 0) {
                invertArray[i] = 1;
            } else {
                invertArray[i] = 0;
            }
        }
        System.out.println(Arrays.toString(invertArray));

    }


    public static void fillArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;

        }
        System.out.println(Arrays.toString(array));
    }

    public static void multiplicationArrayElements() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6)
                array[i] *= 2;
        }
        System.out.println(Arrays.toString(array));

    }

    public static void fillArrayDiagonal() {
        int[][] array = new int[5][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || i == array[i].length - 1 - j) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = 0;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[] fillArrayVariable(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    public static int findMinimumElement() {
        int[] array = new int[5];
        Random rend = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rend.nextInt(10);
        }
        System.out.println(Arrays.toString(array));
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println(min);
        return min;
    }

    public static int findMaxElement() {
        int[] array = new int[5];
        Random rend = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rend.nextInt(10);
        }
        System.out.println(Arrays.toString(array));
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println(max);
        return max;
    }


    public static boolean sumArray(int[] array) {

        System.out.println(Arrays.toString(array));
        int sumAll = 0;
        int sumLeft = 0;
        int sumRight = 0;

        for (int i = 0; i < array.length ; i++) {
            sumAll += array[i];
        }
        sumLeft = array[0];
        sumRight = sumAll - array[0];
        for (int i = 1; i < array.length; i++) {
                if (sumLeft != sumRight) {
                    sumLeft += array[i];
                    sumRight -= array[i];
                }
                else {
                    System.out.println(true);
                    break;
                }
        }
        return true;
    }

    public static void shiftArray(int[] array,int number) {

        System.out.println(Arrays.toString(array));
        System.out.println(number);
        int temp = 0;
        if (number > 0) {
            for (int i = 0; i < number; i++) {
                temp = array[array.length - 1];
                for (int j = 0; j < array.length - 1; j++) {
                    array[(array.length - 1) - j] = array[(array.length - 1) - (j + 1)];
                }
                array[0] = temp;
            }
        }
        if (number < 0) {
            number = Math.abs(number);
            for (int i = 0; i < number; i++) {
                temp = array[0];
                for (int j = 0; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}

