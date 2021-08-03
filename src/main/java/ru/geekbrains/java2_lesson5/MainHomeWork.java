package ru.geekbrains.java2_lesson5;

import java.util.Arrays;

public class MainHomeWork {

    public static final int size = 10_000_000;

    public static void main(String[] args) {


        // Реализация первого метода
        System.out.println(firstMethod());
//        System.out.println(Arrays.toString(arrayFilling(arrayInit(size))));

        // Реализация втопого метода
        System.out.println(secondMethod());
    }

    // Метод инициализирует массив и заполняет его единицами
    public static float[] arrayInit(int size) {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        return arr;
    }

    // Метод выполняет математическую опперацию внутри каждой ячейки массива
    public static float[] arrayFilling(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i * 1.0 / 5) * Math.cos(0.2f + i * 1.0 / 5) * Math.cos(0.4f + i * 1.0 / 2));
        }
        return arr;
    }

    // Метод выполняет математическую опперацию внутри каждой ячейки второй части разделенного массива
    public static float[] arrayFillingTakeIndex(int size, float[] arr) {
        for (int i = 0; i < size / 2; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + ((size * 1.0 / 2) + i) / 5) * Math.cos(0.2f + ((size * 1.0 / 2) + i) / 5) * Math.cos(0.4f + ((size * 1.0 / 2) + i) / 2));
        }
        return arr;
    }

    public static long firstMethod(){
        long time1 = System.currentTimeMillis();
        arrayFilling(arrayInit(size));
        long time2 = System.currentTimeMillis();
       return time2 - time1;

    }

    public static long secondMethod() {
        long time3 = System.currentTimeMillis();
        float[] array1 = new float[size / 2];
        float[] array2 = new float[size / 2];
        System.arraycopy(arrayInit(size), 0, array1, 0, array1.length);
        System.arraycopy(arrayInit(size), size / 2, array2, 0, array2.length);

//        System.out.println(Arrays.toString(array1));
//        System.out.println(Arrays.toString(array2));


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                arrayFilling(array1);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                arrayFillingTakeIndex(size, array2);
            }
        });

        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        System.out.println(Arrays.toString(array1));
//        System.out.println(Arrays.toString(array2));


        float[] arrСombination = new float[size];
        System.arraycopy(array1, 0, (arrСombination), 0, array1.length);
        System.arraycopy(array2, 0, (arrСombination), size / 2, array2.length);

        long time4 = System.currentTimeMillis();

//        System.out.println(Arrays.toString((arrСombination)));
        return time4 - time3;

    }
}
